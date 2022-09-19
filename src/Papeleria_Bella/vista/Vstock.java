/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Papeleria_Bella.vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author JimmGM
 */
public class Vstock extends javax.swing.JFrame {

    /**
     * Creates new form Vstock
     */
    public Vstock() {
        initComponents();
    }

    public JButton getButtonbuscar() {
        return buttonbuscar;
    }

    public void setButtonbuscar(JButton buttonbuscar) {
        this.buttonbuscar = buttonbuscar;
    }

    public JButton getButtoneliminar() {
        return buttoneliminar;
    }

    public void setButtoneliminar(JButton buttoneliminar) {
        this.buttoneliminar = buttoneliminar;
    }

    public JButton getButtonguardar() {
        return buttonguardar;
    }

    public void setButtonguardar(JButton buttonguardar) {
        this.buttonguardar = buttonguardar;
    }

    public JButton getButtonimprimir() {
        return buttonimprimir;
    }

    public void setButtonimprimir(JButton buttonimprimir) {
        this.buttonimprimir = buttonimprimir;
    }

    public JButton getButtonmodificar() {
        return buttonmodificar;
    }

    public void setButtonmodificar(JButton buttonmodificar) {
        this.buttonmodificar = buttonmodificar;
    }

    public JButton getButtonnuevo() {
        return buttonnuevo;
    }

    public void setButtonnuevo(JButton buttonnuevo) {
        this.buttonnuevo = buttonnuevo;
    }

    public JLabel getjLabel17() {
        return jLabel17;
    }

    public void setjLabel17(JLabel jLabel17) {
        this.jLabel17 = jLabel17;
    }

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }

    public JLabel getjLabel19() {
        return jLabel19;
    }

    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel20() {
        return jLabel20;
    }

    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLabelcod_producto() {
        return labelcod_producto;
    }

    public void setLabelcod_producto(JLabel labelcod_producto) {
        this.labelcod_producto = labelcod_producto;
    }

    public JLabel getLabelcodigo1() {
        return labelcodigo1;
    }

    public void setLabelcodigo1(JLabel labelcodigo1) {
        this.labelcodigo1 = labelcodigo1;
    }

    public JTable getTablastock() {
        return tablastock;
    }

    public void setTablastock(JTable tablastock) {
        this.tablastock = tablastock;
    }

    public JTextField getTxtnom_producto() {
        return txtnom_producto;
    }

    public void setTxtnom_producto(JTextField txtnom_producto) {
        this.txtnom_producto = txtnom_producto;
    }

    public JTextField getTxtstock1() {
        return txtstock1;
    }

    public void setTxtstock1(JTextField txtstock1) {
        this.txtstock1 = txtstock1;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        labelcod_producto = new javax.swing.JLabel();
        labelcodigo1 = new javax.swing.JLabel();
        txtnom_producto = new javax.swing.JTextField();
        txtstock1 = new javax.swing.JTextField();
        buttonbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablastock = new javax.swing.JTable();
        buttonnuevo = new javax.swing.JButton();
        buttonguardar = new javax.swing.JButton();
        buttonmodificar = new javax.swing.JButton();
        buttoneliminar = new javax.swing.JButton();
        buttonimprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Sitka Small", 3, 24)); // NOI18N
        jLabel2.setText("Stock");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 80, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel17.setText("Código Producto:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 140, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel18.setText("Nombre Producto:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel19.setText("Stock:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel20.setText("Código:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));
        getContentPane().add(labelcod_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 110, 20));
        getContentPane().add(labelcodigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 110, 20));
        getContentPane().add(txtnom_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 90, -1));
        getContentPane().add(txtstock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 90, -1));

        buttonbuscar.setBackground(new java.awt.Color(232, 255, 255));
        buttonbuscar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        getContentPane().add(buttonbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 30, 30));

        tablastock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Codigo Producto", "Stock", "Nombre Producto"
            }
        ));
        jScrollPane1.setViewportView(tablastock);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, 140));

        buttonnuevo.setBackground(new java.awt.Color(232, 255, 255));
        buttonnuevo.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add(3).png"))); // NOI18N
        getContentPane().add(buttonnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 50, 40));

        buttonguardar.setBackground(new java.awt.Color(232, 255, 255));
        buttonguardar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download.png"))); // NOI18N
        getContentPane().add(buttonguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 50, -1));

        buttonmodificar.setBackground(new java.awt.Color(232, 255, 255));
        buttonmodificar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        getContentPane().add(buttonmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 60, 40));

        buttoneliminar.setBackground(new java.awt.Color(232, 255, 255));
        buttoneliminar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttoneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/garbage-bin(1).png"))); // NOI18N
        getContentPane().add(buttoneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 50, 40));

        buttonimprimir.setBackground(new java.awt.Color(232, 255, 255));
        buttonimprimir.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-imprimir-32.png"))); // NOI18N
        getContentPane().add(buttonimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 40, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonbuscar;
    private javax.swing.JButton buttoneliminar;
    private javax.swing.JButton buttonguardar;
    private javax.swing.JButton buttonimprimir;
    private javax.swing.JButton buttonmodificar;
    private javax.swing.JButton buttonnuevo;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelcod_producto;
    private javax.swing.JLabel labelcodigo1;
    private javax.swing.JTable tablastock;
    private javax.swing.JTextField txtnom_producto;
    private javax.swing.JTextField txtstock1;
    // End of variables declaration//GEN-END:variables
}
