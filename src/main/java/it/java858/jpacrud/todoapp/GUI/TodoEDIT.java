/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.jpacrud.todoapp.GUI;

import it.java858.jpacrud.todoapp.entity.ToDo;
import it.java858.jpacrud.todoapp.service.ToDoService;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class TodoEDIT extends javax.swing.JDialog {

    ToDo to;
    /**
     * Creates new form TodoEDIT
     */
    public TodoEDIT(java.awt.Frame parent, boolean modal,ToDo to) {
        super(parent, modal);
        initComponents();
        init(to);
    }
    public TodoEDIT(java.awt.Dialog parent, boolean modal,ToDo to) {
        super(parent, modal);
        initComponents();
        init(to);
    }
 
    public void modelToView(){
        tfTodo.setText(to.getTesto());
    }
    public void viewToModel(){
        to.setTesto(tfTodo.getText());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfTodo = new javax.swing.JTextField();
        cmdSalva = new javax.swing.JButton();
        cmdAnnulla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Creazione Modifica di un ToDo");

        jLabel2.setText("Nome ToDo :");

        cmdSalva.setText("Salva");
        cmdSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSalvaActionPerformed(evt);
            }
        });

        cmdAnnulla.setText("Annulla");
        cmdAnnulla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAnnullaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdSalva)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdAnnulla))
                            .addComponent(tfTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfTodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdSalva)
                    .addComponent(cmdAnnulla))
                .addGap(0, 110, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAnnullaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAnnullaActionPerformed
           close();
    }//GEN-LAST:event_cmdAnnullaActionPerformed

    private void cmdSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSalvaActionPerformed
        viewToModel();
        ToDoService.Save(to);
        JOptionPane.showMessageDialog(this, "ToDo Salvato");
        close();
    }//GEN-LAST:event_cmdSalvaActionPerformed
     private void close(){
        this.setVisible(false);
        this.dispose();
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAnnulla;
    private javax.swing.JButton cmdSalva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfTodo;
    // End of variables declaration//GEN-END:variables

    private void init(ToDo to) {
        this.to = to;
        modelToView();
    }
}