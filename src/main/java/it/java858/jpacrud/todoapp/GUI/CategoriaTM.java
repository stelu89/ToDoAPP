/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.jpacrud.todoapp.GUI;

import it.java858.jpacrud.todoapp.entity.Categoria;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tss
 */
public class CategoriaTM extends AbstractTableModel {

    //nomi campi della tabella
    String[] nomi = {"id", "nome"};

    List<Categoria> categorie;

    public CategoriaTM(List<Categoria> categorie) {
        this.categorie = categorie;
    }

    public void changeDATA(List<Categoria> data) {
    
        categorie=data;
        fireTableDataChanged(); // serve per segnalare che i dati sono cambiati 
    }

    @Override
    public int getRowCount() {
      return categorie.size();
    }

    @Override
    public int getColumnCount() {
        return nomi.length;
       
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch (columnIndex){
           
           case 0:return categorie.get(rowIndex).getId();
           case 1:return categorie.get(rowIndex).getNome();
           default: return null;   
       }
    }
    public String getColumnName(int column){
        return nomi[column];
    }

    public Categoria get(int row){
        
        return categorie.get(row);
    }

}
