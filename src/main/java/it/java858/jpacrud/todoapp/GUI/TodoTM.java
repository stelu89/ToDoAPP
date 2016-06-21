/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.jpacrud.todoapp.GUI;

import it.java858.jpacrud.todoapp.entity.ToDo;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tss
 */
public class TodoTM extends AbstractTableModel{
    
    String[] nomi = {"id","Testo","dataCreazione"};
    List<ToDo> todo;
    
    public TodoTM(List<ToDo> todo) {
        this.todo = todo;
    }

    public void changeDATA(List<ToDo> data) {
    
        todo=data;
        fireTableDataChanged(); // serve per segnalare che i dati sono cambiati 
    }

    @Override
    public int getRowCount() {
        return todo.size();
    }

    @Override
    public int getColumnCount() {
        return nomi.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
           
           case 0:return todo.get(rowIndex).getId();
           case 1:return todo.get(rowIndex).getTesto();
           case 2:return todo.get(rowIndex).getDataCreazione();
           default: return null;   
       }
    }
    public String getColumnName(int column){
        return nomi[column];
    }

    public ToDo get(int row){
        
        return todo.get(row);
    }
}

