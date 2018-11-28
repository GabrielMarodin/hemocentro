/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.gpba.ds.bd2.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author edjandir
 */
@Entity
@Table(name="doador")
public class Doador {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="sobrenome")
    private String sobrenome;
    
    @Column(name="endereco")
    private String endereco;
    
    @Column(name="telefone")
    private String telefone;
    
    @Column(name="cpf")
    private String cpf;
    
    @Column(name="tipo_sanguineo")
    private String tipoSanguineo;
    
    @Column(name="relatorio_medico")
    private String relatorioMedico;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "doador_banco", joinColumns = @JoinColumn(name = "doador_id"), inverseJoinColumns = @JoinColumn(name = "banco_id"))
    private List<BancoSangue> bancosSangue = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getRelatorioMedico() {
        return relatorioMedico;
    }

    public void setRelatorioMedico(String relatorioMedico) {
        this.relatorioMedico = relatorioMedico;
    }
    
    public List<BancoSangue> getBancosSangue() {
        return bancosSangue;
    }

    public void setBancosSangue(BancoSangue bancosSangue) {
        this.bancosSangue.add(bancosSangue) ;
    }
  
    @Override
    public String toString() {
        return "Doador{" + "id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome +
               ", endereco=" + endereco +
               ", telefone=" + telefone + ", cpf=" + cpf + ", tipo_sanguineo=" + tipoSanguineo + ", relatorio_medico=" + relatorioMedico + '}';
    }
    
}
