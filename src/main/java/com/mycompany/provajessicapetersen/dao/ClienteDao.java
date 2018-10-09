/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.provajessicapetersen.dao;

import com.mycompany.provajessicapetersen.Model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author 08187832908
 */
public class ClienteDao extends Dao{
    
    public List<Cliente> buscarPorId(Long id){
        EntityManager em = getEntity();
        Query busca = em.createNamedQuery("id");
        busca.setParameter("id", id);
        return busca.getResultList();
    }
    
    public List<Cliente> buscaTodosClientes(){
        EntityManager em = getEntity();
        Query busca = em.createNamedQuery("todos");
        return busca.getResultList();
    }
}
