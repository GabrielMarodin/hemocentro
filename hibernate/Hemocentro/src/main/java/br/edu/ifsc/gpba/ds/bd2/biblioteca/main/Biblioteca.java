/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.gpba.ds.bd2.biblioteca.main;

import br.edu.ifsc.gpba.ds.bd2.biblioteca.dao.PacienteHbnDAO;
import br.edu.ifsc.gpba.ds.bd2.biblioteca.dao.BancoSangueHbnDAO;
import br.edu.ifsc.gpba.ds.bd2.biblioteca.dao.AbstractDAO;
import br.edu.ifsc.gpba.ds.bd2.biblioteca.dao.HibernateUtil;
import br.edu.ifsc.gpba.ds.bd2.biblioteca.dao.DoadorHbnDAO;
import br.edu.ifsc.gpba.ds.bd2.biblioteca.dao.interfaces.DAO;
import br.edu.ifsc.gpba.ds.bd2.biblioteca.model.Paciente;
import br.edu.ifsc.gpba.ds.bd2.biblioteca.model.BancoSangue;
import br.edu.ifsc.gpba.ds.bd2.biblioteca.model.Doador;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import br.edu.ifsc.gpba.ds.bd2.biblioteca.dao.interfaces.PacienteDAO;

/**
 *
 * @author edjandir
 */
public class Biblioteca {
    
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        org.hibernate.Transaction tx = null;
        
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            
            DAO pacienteDAO = new PacienteHbnDAO();
            pacienteDAO.setSession(session);
            Paciente paciente = (Paciente)pacienteDAO.findById(2l);
            
            System.out.println(paciente.getBancosSangue().get(0).getNome());
            
            DAO doadorDAO = new DoadorHbnDAO();
            doadorDAO.setSession(session);
            Doador doador = (Doador)doadorDAO.findById(1L);
            
//            tx = session.beginTransaction();
//            doador.getPacientees().add(paciente);
//            doadorDAO.save(doador);
//            tx.commit();
//            System.out.println(bancosangue.getDoadors().get(0).getNome());
            
        }
        catch(HibernateException e) {
            tx.rollback();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
    
    
    private static Paciente createPaciente() {
        Paciente paciente = new Paciente();
        paciente.setNome("joao");
        paciente.setSobrenome("miguel");
        paciente.setTipoSanguineo("AB");
        paciente.setCondicao("triste");
        return paciente;
    }
    
    private static BancoSangue createBancoSangue() {
        BancoSangue bancosangue = new BancoSangue();
        bancosangue.setNome("bancosanguinho");
        bancosangue.setEndereco("lá");
        bancosangue.setTelefone("48991688195");
        return bancosangue;
    }
    
    private static Doador createDoador(BancoSangue bancosangue) {
        Doador doador = new Doador();
        doador.setNome("davi");
        doador.setSobrenome("seer");
        doador.setEndereco("lé");
        doador.setTelefone("48999999999");
        doador.setCpf("1235678912");
        doador.setTipoSanguineo("O");
        doador.setRelatorioMedico("feliz");
        doador.setBancosSangue(bancosangue);
        return doador;
    }
    
}
