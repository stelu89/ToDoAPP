/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.jpacrud.todoapp.service;

import it.java858.jpacrud.todoapp.entity.Categoria;
import it.java858.jpacrud.todoapp.service.event.CategoriaEventListener;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tss
 */
public class CategoriaService {

    private static List<CategoriaEventListener> listeners = new ArrayList<>();
    
    private CategoriaService() {
    }
    
    // aggiunge ascoltatore alla lista
    public static void addCategoriaEventListener(CategoriaEventListener listener){
        listeners.add(listener);
    }
    public static Categoria save(Categoria c){
        EntityManager  em = DbService.getEM();
        em.getTransaction().begin();
        Categoria saved = em.merge(c);
        em.getTransaction().commit();
        for(CategoriaEventListener listener : listeners){
            if (c.getId()==null){
                listener.onCreate(saved);
            }
            else {
                listener.onUpdate(saved);
            }
        }
        return saved;
    }
    public static List<Categoria> Estrai(){
        EntityManager em = DbService.getEM();
        List<Categoria> cat;
        cat = em.createQuery("select c from Categoria c order by c.nome",Categoria.class).getResultList();
        em.close();
        return cat;
        
    }
    public static void Elimina(Categoria c){
        EntityManager  em = DbService.getEM();
        em.getTransaction().begin();
        Categoria find = em.find(Categoria.class, c.getId());
        em.remove(find);
        em.getTransaction().commit();
        for (CategoriaEventListener listener : listeners) {
            listener.onDelete(c);
        }
}
}