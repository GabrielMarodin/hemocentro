/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.gpba.ds.bd2.biblioteca.dao.interfaces;

/**
 *
 * @author edjandir
 */

import java.util.List;

import org.hibernate.Session;

public interface DAO<T,ID> {

    public T findById(ID id);

    public List<T> findAll();

    public T save(T entity);

    public void delete(T entity);

    public void flush();

    public void clear();

    public void setSession(Session session);
    
}
