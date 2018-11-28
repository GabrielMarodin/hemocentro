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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author edjandir
 */
@Entity
@Table(name= "pacientes")
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="sobrenome")
    private String sobrenome;
    
    @Column(name="tipo_sanguineo")
    private String tipoSanguineo;
    
    @Column(name="condicao")
    private String condicao;
    
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="pacientes")
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

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }
    
    public List<BancoSangue> getBancosSangue() {
        return bancosSangue;
    }

    public void setBancosSangue(List<BancoSangue> bancosSangue) {
        this.bancosSangue = bancosSangue;
    }
    

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nome=" + nome + ", Sobrenome=" + sobrenome + ", tipo_sanguineo=" + tipoSanguineo + ", condicao=" + condicao + '}';
    }
    
}
