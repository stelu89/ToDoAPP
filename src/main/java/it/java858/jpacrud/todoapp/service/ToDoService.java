/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.jpacrud.todoapp.service;

import it.java858.jpacrud.todoapp.entity.ToDo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tss
 */
public class ToDoService {

    private ToDoService() {    
    }
    
    public static ToDo Save(ToDo toSave){
        
        EntityManager em = DbService.getEM();
        em.getTransaction().begin();
        ToDo saved = em.merge(toSave);
        em.getTransaction().commit();
        return saved;
    }
    public static List<ToDo> Estrai(){
        EntityManager em = DbService.getEM();
        List<ToDo> tod;
        tod = em.createQuery("select t from ToDo t order by t.Testo",ToDo.class).getResultList();
        em.close();
        return tod;   
    }
    public static void EliminaT(ToDo t){
        EntityManager  em = DbService.getEM();
        em.getTransaction().begin();
        ToDo find = em.find(ToDo.class, t.getId());
        em.remove(find);
        em.getTransaction().commit();
}
}
