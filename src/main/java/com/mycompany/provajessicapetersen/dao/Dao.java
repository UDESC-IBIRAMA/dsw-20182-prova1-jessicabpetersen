/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.provajessicapetersen.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 08187832908
 */
public class Dao {
    public EntityManager getEntity(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("provaJessicaBernardiPetersen");
        return emf.createEntityManager();
    }
    
    
    public void salvar(Object objeto) {
        EntityManager em = getEntity();

        em.getTransaction().begin();

        try {
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    } 
    
    public Object ler(Class classe, long id){
        Object object = null;
        EntityManager em = getEntity();
        
        em.getTransaction().begin();
        
        try{
            object = em.find(classe, id);
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally{
            em.close();
        }
        return object;
    }
    
    public  void update(Object object){
        EntityManager em = getEntity();
        
        em.getTransaction().begin();
        
        try{
            em.merge(object);
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }
    
    public void remover(Object object){
        EntityManager em = getEntity();
        
        em.getTransaction().begin();
        
        try{
            em.remove(object);
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }
}
