
package it.java858.jpacrud.todoapp;

import it.java858.jpacrud.todoapp.GUI.Main;
import it.java858.jpacrud.todoapp.entity.Categoria;
import it.java858.jpacrud.todoapp.entity.ToDo;
import it.java858.jpacrud.todoapp.service.CategoriaService;
import it.java858.jpacrud.todoapp.service.DbService;
import it.java858.jpacrud.todoapp.service.ToDoService;
import it.java858.jpacrud.todoapp.service.event.CategoriaEventListener;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tss
 */
public class App {
    
    public static void main(String[] args) {
     
        CategoriaService.addCategoriaEventListener(new AscoltaEventiCategoria());
       
        //creazione display e form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    class AscoltaEventiCategoria implements CategoriaEventListener {

        @Override
        public void onCreate(Categoria c) {
            System.out.println("Hai creato la categoria: " + c);
        }

        @Override
        public void onUpdate(Categoria c) {
             System.out.println("Hai Aggiornato la categoria: " + c);
        }

        @Override
        public void onDelete(Categoria c) {
            System.out.println("Hai Eliminato la categoria: " + c);
        }
        
    }
}
