/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package V93Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class VistaUsuario extends javax.swing.JFrame {

    /**
     * Creates new form VistaUsuario
     */
    public VistaUsuario() {
        initComponents();
        
    }

    public JTable getTableUsuario() {
        return TableUsuario;
    }

    public void setTableUsuario(JTable TableUsuario) {
        this.TableUsuario = TableUsuario;
    }

    public JButton getBtnEliminarUsuario() {
        return btnEliminarUsuario;
    }

    public void setBtnEliminarUsuario(JButton btnEliminarUsuario) {
        this.btnEliminarUsuario = btnEliminarUsuario;
    }

    public JButton getBtnGuardarUsuario() {
        return btnGuardarUsuario;
    }

    public void setBtnGuardarUsuario(JButton btnGuardarUsuario) {
        this.btnGuardarUsuario = btnGuardarUsuario;
    }

    public JButton getBtnModificarUsuario() {
        return btnModificarUsuario;
    }

    public void setBtnModificarUsuario(JButton btnModificarUsuario) {
        this.btnModificarUsuario = btnModificarUsuario;
    }

    public JButton getBtnNuevoUsuario() {
        return btnNuevoUsuario;
    }

    public void setBtnNuevoUsuario(JButton btnNuevoUsuario) {
        this.btnNuevoUsuario = btnNuevoUsuario;
    }

    public JComboBox<String> getjComboBoxEstadoUsuario() {
        return jComboBoxEstadoUsuario;
    }

    public void setjComboBoxEstadoUsuario(JComboBox<String> jComboBoxEstadoUsuario) {
        this.jComboBoxEstadoUsuario = jComboBoxEstadoUsuario;
    }

    public JComboBox<String> getjComboBoxRolUsuario() {
        return jComboBoxRolUsuario;
    }

    public void setjComboBoxRolUsuario(JComboBox<String> jComboBoxRolUsuario) {
        this.jComboBoxRolUsuario = jComboBoxRolUsuario;
    }

    public JTextField getTxtCedulaUsuario() {
        return txtCedulaUsuario;
    }

    public void setTxtCedulaUsuario(JTextField txtCedulaUsuario) {
        this.txtCedulaUsuario = txtCedulaUsuario;
    }

    public JTextField getTxtNombreUsuario() {
        return txtNombreUsuario;
    }

    public void setTxtNombreUsuario(JTextField txtNombreUsuario) {
        this.txtNombreUsuario = txtNombreUsuario;
    }

    public JTextField getTxtPasswordUsuario() {
        return txtPasswordUsuario;
    }

    public void setTxtPasswordUsuario(JTextField txtPasswordUsuario) {
        this.txtPasswordUsuario = txtPasswordUsuario;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TableUsuario = new javax.swing.JTable();
        txtCedulaUsuario = new javax.swing.JTextField();
        txtNombreUsuario = new javax.swing.JTextField();
        txtPasswordUsuario = new javax.swing.JTextField();
        jComboBoxRolUsuario = new javax.swing.JComboBox<>();
        jComboBoxEstadoUsuario = new javax.swing.JComboBox<>();
        btnGuardarUsuario = new javax.swing.JButton();
        btnModificarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnNuevoUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("USUARIO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CEDULA:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("PASSWORD:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("NOMBRE:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("ROL:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("ESTADO:");

        TableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CEDULA", "NOMBRE", "PASSWORD", "ROL", "ESTADO"
            }
        ));
        jScrollPane1.setViewportView(TableUsuario);

        jComboBoxRolUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));

        btnGuardarUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/V93/imagen/GuardarTodo.png"))); // NOI18N
        btnGuardarUsuario.setText("GUARDAR");

        btnModificarUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/V93/imagen/Actualizar (2).png"))); // NOI18N
        btnModificarUsuario.setText("MODIFICAR");

        btnEliminarUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/V93/imagen/eliminar.png"))); // NOI18N
        btnEliminarUsuario.setText("ELIMINAR");

        btnNuevoUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/V93/imagen/nuevo.png"))); // NOI18N
        btnNuevoUsuario.setText("NUEVO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnGuardarUsuario)
                        .addGap(28, 28, 28)
                        .addComponent(btnModificarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(btnEliminarUsuario)
                        .addGap(41, 41, 41)
                        .addComponent(btnNuevoUsuario)))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxEstadoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasswordUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(221, 221, 221)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCedulaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(123, 123, 123))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCedulaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPasswordUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(jComboBoxRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxEstadoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarUsuario)
                    .addComponent(btnModificarUsuario)
                    .addComponent(btnEliminarUsuario)
                    .addComponent(btnNuevoUsuario))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableUsuario;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnGuardarUsuario;
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JComboBox<String> jComboBoxEstadoUsuario;
    private javax.swing.JComboBox<String> jComboBoxRolUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCedulaUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtPasswordUsuario;
    // End of variables declaration//GEN-END:variables
}
