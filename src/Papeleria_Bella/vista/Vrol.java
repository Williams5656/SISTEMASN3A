/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Papeleria_Bella.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author hp
 */
public class Vrol extends javax.swing.JFrame {

    /**
     * Creates new form Vrol
     */
    public Vrol() {
        initComponents();
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboestado = new javax.swing.JComboBox<String>();
        txtnombre = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablarol = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        buttonguardar = new javax.swing.JButton();
        buttonnuevo = new javax.swing.JButton();
        buttoneliminar = new javax.swing.JButton();
        buttonmodificar = new javax.swing.JButton();
        buttonbuscar = new javax.swing.JButton();
        labelcodigo = new javax.swing.JLabel();
        buttonimprimir = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Small", 3, 24)); // NOI18N
        jLabel1.setText("Roles");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 78, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setText("Codigo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setText("Nombre:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel9.setText("Buscar codigo:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel10.setText("Descripcion:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel11.setText("Estado:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        comboestado.setBackground(new java.awt.Color(232, 255, 255));
        comboestado.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        comboestado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(comboestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 127, -1));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 128, -1));
        getContentPane().add(txtdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 130, 20));

        tablarol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Descripcion", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tablarol);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 599, 315));
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 122, -1));

        buttonguardar.setBackground(new java.awt.Color(232, 255, 255));
        buttonguardar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download.png"))); // NOI18N
        buttonguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonguardarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 50, 40));

        buttonnuevo.setBackground(new java.awt.Color(232, 255, 255));
        buttonnuevo.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add(3).png"))); // NOI18N
        getContentPane().add(buttonnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 50, 40));

        buttoneliminar.setBackground(new java.awt.Color(232, 255, 255));
        buttoneliminar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttoneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/garbage-bin(1).png"))); // NOI18N
        getContentPane().add(buttoneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, 40, 40));

        buttonmodificar.setBackground(new java.awt.Color(232, 255, 255));
        buttonmodificar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        getContentPane().add(buttonmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 40, 40));

        buttonbuscar.setBackground(new java.awt.Color(232, 255, 255));
        buttonbuscar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        getContentPane().add(buttonbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 50, 30));
        getContentPane().add(labelcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 130, 30));

        buttonimprimir.setBackground(new java.awt.Color(232, 255, 255));
        buttonimprimir.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-imprimir-32.png"))); // NOI18N
        getContentPane().add(buttonimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 590, 30, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo-color-verde-menta-morado-fondo-degradado-borroso-abstracto-plantilla-banner-telon-fondo-malla-colores-dulces_335640-3361.png"))); // NOI18N
        fondo.setPreferredSize(new java.awt.Dimension(1210, 620));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 850, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonguardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonguardarActionPerformed

    
    

    public JButton getButtonimprimir() {
        return buttonimprimir;
    }

    public void setButtonimprimir(JButton buttonimprimir) {
        this.buttonimprimir = buttonimprimir;
    }

    public JLabel getFondo() {
        return fondo;
    }

    /**
     * @param args the command line arguments
     */
    public void setFondo(JLabel fondo) {
        this.fondo = fondo;
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

    public JComboBox<String> getComboestado() {
        return comboestado;
    }

    public void setComboestado(JComboBox<String> comboestado) {
        this.comboestado = comboestado;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getTablarol() {
        return tablarol;
    }

    public void setTablarol(JTable tablarol) {
        this.tablarol = tablarol;
    }

    public JTextField getTxtbuscar() {
        return txtbuscar;
    }

    public void setTxtbuscar(JTextField txtbuscar) {
        this.txtbuscar = txtbuscar;
    }

    

    public JTextField getTxtdescripcion() {
        return txtdescripcion;
    }

    public void setTxtdescripcion(JTextField txtdescripcion) {
        this.txtdescripcion = txtdescripcion;
    }

    public JTextField getTxtnombre() {
        return txtnombre;
    }

    public void setTxtnombre(JTextField txtnombre) {
        this.txtnombre = txtnombre;
    }

    

    public JLabel getLabelcodigo() {
        return labelcodigo;
    }

    public void setLabelcodigo(JLabel labelcodigo) {
        this.labelcodigo = labelcodigo;
    }

    

   
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonbuscar;
    private javax.swing.JButton buttoneliminar;
    private javax.swing.JButton buttonguardar;
    private javax.swing.JButton buttonimprimir;
    private javax.swing.JButton buttonmodificar;
    private javax.swing.JButton buttonnuevo;
    private javax.swing.JComboBox<String> comboestado;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelcodigo;
    private javax.swing.JTable tablarol;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
