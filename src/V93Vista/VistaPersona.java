/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package V93Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class VistaPersona extends javax.swing.JFrame {

    /**
     * Creates new form VistaPersona
     */
    public VistaPersona() {
        initComponents();
        
        
    }

    public JLabel getJLabelFotoPersona() {
        return JLabelFotoPersona;
    }

    public void setJLabelFotoPersona(JLabel JLabelFotoPersona) {
        this.JLabelFotoPersona = JLabelFotoPersona;
    }

    public JTable getTablePersona() {
        return TablePersona;
    }

    public void setTablePersona(JTable TablePersona) {
        this.TablePersona = TablePersona;
    }

    public JButton getBtnEliminarPersona() {
        return btnEliminarPersona;
    }

    public void setBtnEliminarPersona(JButton btnEliminarPersona) {
        this.btnEliminarPersona = btnEliminarPersona;
    }

    public JButton getBtnGuardarPersona() {
        return btnGuardarPersona;
    }

    public void setBtnGuardarPersona(JButton btnGuardarPersona) {
        this.btnGuardarPersona = btnGuardarPersona;
    }

    public JButton getBtnModificarPersona() {
        return btnModificarPersona;
    }

    public void setBtnModificarPersona(JButton btnModificarPersona) {
        this.btnModificarPersona = btnModificarPersona;
    }

    public JButton getBtnNuevoPersona() {
        return btnNuevoPersona;
    }

    public void setBtnNuevoPersona(JButton btnNuevoPersona) {
        this.btnNuevoPersona = btnNuevoPersona;
    }

    public JTextField getTxtCedulaPersona() {
        return txtCedulaPersona;
    }

    public void setTxtCedulaPersona(JTextField txtCedulaPersona) {
        this.txtCedulaPersona = txtCedulaPersona;
    }

    public JTextField getTxtCelularPersona() {
        return txtCelularPersona;
    }

    public void setTxtCelularPersona(JTextField txtCelularPersona) {
        this.txtCelularPersona = txtCelularPersona;
    }

    public JTextField getTxtCiudadPersona() {
        return txtCiudadPersona;
    }

    public void setTxtCiudadPersona(JTextField txtCiudadPersona) {
        this.txtCiudadPersona = txtCiudadPersona;
    }

    public JTextField getTxtDireccionPersona() {
        return txtDireccionPersona;
    }

    public void setTxtDireccionPersona(JTextField txtDireccionPersona) {
        this.txtDireccionPersona = txtDireccionPersona;
    }

    public JTextField getTxtFechaNacimientoPersona() {
        return txtFechaNacimientoPersona;
    }

    public void setTxtFechaNacimientoPersona(JTextField txtFechaNacimientoPersona) {
        this.txtFechaNacimientoPersona = txtFechaNacimientoPersona;
    }

    public JTextField getTxtNombrePersona() {
        return txtNombrePersona;
    }

    public void setTxtNombrePersona(JTextField txtNombrePersona) {
        this.txtNombrePersona = txtNombrePersona;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePersona = new javax.swing.JTable();
        txtCedulaPersona = new javax.swing.JTextField();
        txtNombrePersona = new javax.swing.JTextField();
        txtDireccionPersona = new javax.swing.JTextField();
        txtFechaNacimientoPersona = new javax.swing.JTextField();
        txtCiudadPersona = new javax.swing.JTextField();
        txtCelularPersona = new javax.swing.JTextField();
        btnGuardarPersona = new javax.swing.JButton();
        btnModificarPersona = new javax.swing.JButton();
        btnEliminarPersona = new javax.swing.JButton();
        btnNuevoPersona = new javax.swing.JButton();
        JLabelFotoPersona = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("PERSONA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CEDULA:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NOMBRE:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("DIRECCION:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("FECHA_NACIMIENTO:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("CIUDAD:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("CELULAR:");

        TablePersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CEDULA", "NOMBRE", "DIRECCION", "FECHA_NACIMIENTO", "CIUDAD", "CELULAR"
            }
        ));
        jScrollPane1.setViewportView(TablePersona);

        btnGuardarPersona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardarPersona.setText("GUARDAR");

        btnModificarPersona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificarPersona.setText("MODIFICAR");

        btnEliminarPersona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarPersona.setText("ELIMINAR");

        btnNuevoPersona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevoPersona.setText("NUEVO");

        JLabelFotoPersona.setText("FOTO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCedulaPersona)
                    .addComponent(txtNombrePersona)
                    .addComponent(txtDireccionPersona)
                    .addComponent(txtFechaNacimientoPersona)
                    .addComponent(txtCiudadPersona)
                    .addComponent(txtCelularPersona, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLabelFotoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnGuardarPersona)
                        .addGap(60, 60, 60)
                        .addComponent(btnModificarPersona)
                        .addGap(54, 54, 54)
                        .addComponent(btnEliminarPersona)
                        .addGap(67, 67, 67)
                        .addComponent(btnNuevoPersona)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCedulaPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDireccionPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JLabelFotoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFechaNacimientoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCiudadPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCelularPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarPersona)
                    .addComponent(btnModificarPersona)
                    .addComponent(btnEliminarPersona)
                    .addComponent(btnNuevoPersona))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelFotoPersona;
    private javax.swing.JTable TablePersona;
    private javax.swing.JButton btnEliminarPersona;
    private javax.swing.JButton btnGuardarPersona;
    private javax.swing.JButton btnModificarPersona;
    private javax.swing.JButton btnNuevoPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCedulaPersona;
    private javax.swing.JTextField txtCelularPersona;
    private javax.swing.JTextField txtCiudadPersona;
    private javax.swing.JTextField txtDireccionPersona;
    private javax.swing.JTextField txtFechaNacimientoPersona;
    private javax.swing.JTextField txtNombrePersona;
    // End of variables declaration//GEN-END:variables
}