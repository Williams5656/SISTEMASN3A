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

    public JButton getBtnImprimirPersona() {
        return btnImprimirPersona;
    }

    public void setBtnImprimirPersona(JButton btnImprimirPersona) {
        this.btnImprimirPersona = btnImprimirPersona;
    }

    public JButton getBtnbuscarp() {
        return btnbuscarp;
    }

    public void setBtnbuscarp(JButton btnbuscarp) {
        this.btnbuscarp = btnbuscarp;
    }

    public JTextField getTxtbuscarp() {
        return txtbuscarp;
    }

    public void setTxtbuscarp(JTextField txtbuscarp) {
        this.txtbuscarp = txtbuscarp;
    }

  

    public JButton getBtnFoto() {
        return btnFoto;
    }

    public void setBtnFoto(JButton btnFoto) {
        this.btnFoto = btnFoto;
    }
 
    public JLabel getLbFoto() {
        return lbFoto;
    }

    public void setLbFoto(JLabel lbFoto) {
        this.lbFoto = lbFoto;
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
        lbFoto = new javax.swing.JLabel();
        btnFoto = new javax.swing.JButton();
        btnbuscarp = new javax.swing.JButton();
        txtbuscarp = new javax.swing.JTextField();
        btnImprimirPersona = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/NuevoUsuarioP.png"))); // NOI18N
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
        btnGuardarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/GuardarTodo.png"))); // NOI18N
        btnGuardarPersona.setText("GUARDAR");

        btnModificarPersona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Actualizar (2).png"))); // NOI18N
        btnModificarPersona.setText("MODIFICAR");

        btnEliminarPersona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/eliminar.png"))); // NOI18N
        btnEliminarPersona.setText("ELIMINAR");

        btnNuevoPersona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevoPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/nuevo.png"))); // NOI18N
        btnNuevoPersona.setText("NUEVO");

        lbFoto.setText("FOTO");

        btnFoto.setText("foto");

        btnbuscarp.setText("BUSCAR POR CEDULA");

        btnImprimirPersona.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnImprimirPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/print.png"))); // NOI18N
        btnImprimirPersona.setText("IMPRIMIR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardarPersona)
                        .addGap(43, 43, 43)
                        .addComponent(btnModificarPersona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarPersona)
                        .addGap(56, 56, 56)
                        .addComponent(btnNuevoPersona)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnbuscarp, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtbuscarp, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombrePersona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDireccionPersona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFechaNacimientoPersona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCiudadPersona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCelularPersona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(txtCedulaPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(btnImprimirPersona)))
                .addContainerGap(358, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCedulaPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtDireccionPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtCiudadPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtCelularPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(txtFechaNacimientoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53)
                        .addComponent(btnbuscarp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbuscarp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFoto))))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevoPersona)
                            .addComponent(btnEliminarPersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnImprimirPersona))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuardarPersona)
                        .addComponent(btnModificarPersona)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablePersona;
    private javax.swing.JButton btnEliminarPersona;
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnGuardarPersona;
    private javax.swing.JButton btnImprimirPersona;
    private javax.swing.JButton btnModificarPersona;
    private javax.swing.JButton btnNuevoPersona;
    private javax.swing.JButton btnbuscarp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JTextField txtCedulaPersona;
    private javax.swing.JTextField txtCelularPersona;
    private javax.swing.JTextField txtCiudadPersona;
    private javax.swing.JTextField txtDireccionPersona;
    private javax.swing.JTextField txtFechaNacimientoPersona;
    private javax.swing.JTextField txtNombrePersona;
    private javax.swing.JTextField txtbuscarp;
    // End of variables declaration//GEN-END:variables
}
