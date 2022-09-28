package Papeleria_Bella.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Vclientes extends javax.swing.JFrame {

    public Vclientes() {
        initComponents();
    }

    public JSpinner getTxtPorcentajeDiscapacidad() {
        return TxtPorcentajeDiscapacidad;
    }

    public void setTxtPorcentajeDiscapacidad(JSpinner TxtPorcentajeDiscapacidad) {
        this.TxtPorcentajeDiscapacidad = TxtPorcentajeDiscapacidad;
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

    public JLabel getLabelCelular() {
        return LabelCelular;
    }

    public void setLabelCelular(JLabel LabelCelular) {
        this.LabelCelular = LabelCelular;
    }

    public JLabel getLabelPorcentajeDiscapacidad() {
        return LabelPorcentajeDiscapacidad;
    }

    public void setLabelPorcentajeDiscapacidad(JLabel LabelPorcentajeDiscapacidad) {
        this.LabelPorcentajeDiscapacidad = LabelPorcentajeDiscapacidad;
    }

    public JLabel getLabelTINombres() {
        return LabelTINombres;
    }

    public void setLabelTINombres(JLabel LabelTINombres) {
        this.LabelTINombres = LabelTINombres;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getTablacliente() {
        return tablacliente;
    }

    public void setTablacliente(JTable tablacliente) {
        this.tablacliente = tablacliente;
    }

    public JLabel getLabelcelular() {
        return labelcelular;
    }

    public void setLabelcelular(JLabel labelcelular) {
        this.labelcelular = labelcelular;
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

    public JComboBox<String> getCmbDiscapacidad() {
        return cmbDiscapacidad;
    }

    public void setCmbDiscapacidad(JComboBox<String> cmbDiscapacidad) {
        this.cmbDiscapacidad = cmbDiscapacidad;
    }

    public JComboBox<String> getCmbEstado() {
        return cmbEstado;
    }

    public void setCmbEstado(JComboBox<String> cmbEstado) {
        this.cmbEstado = cmbEstado;
    }

    public JLabel getLabelcodigo2() {
        return labelcodigo2;
    }

    public void setLabelcodigo2(JLabel labelcodigo2) {
        this.labelcodigo2 = labelcodigo2;
    }

    public JLabel getLabelnombres() {
        return labelnombres;
    }

    public void setLabelnombres(JLabel labelnombres) {
        this.labelnombres = labelnombres;
    }

    public JTextField getTxtcedula() {
        return txtcedula;
    }

    public void setTxtcedula(JTextField txtcedula) {
        this.txtcedula = txtcedula;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        LabelTINombres = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        buttonnuevo = new javax.swing.JButton();
        buttonguardar = new javax.swing.JButton();
        buttonmodificar = new javax.swing.JButton();
        buttoneliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacliente = new javax.swing.JTable();
        buttonimprimir = new javax.swing.JButton();
        buttonbuscar = new javax.swing.JButton();
        labelcodigo2 = new javax.swing.JLabel();
        labelnombres = new javax.swing.JLabel();
        labelcelular = new javax.swing.JLabel();
        LabelPorcentajeDiscapacidad = new javax.swing.JLabel();
        LabelCelular = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbDiscapacidad = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        TxtPorcentajeDiscapacidad = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Sitka Small", 3, 24)); // NOI18N
        jLabel2.setText("Clientes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 110, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel17.setText("Cédula:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 70, 40));

        LabelTINombres.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        LabelTINombres.setText("Nombres:");
        getContentPane().add(LabelTINombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel22.setText("Estado:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel23.setText("Código:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        txtcedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaActionPerformed(evt);
            }
        });
        getContentPane().add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 130, 20));

        buttonnuevo.setBackground(new java.awt.Color(232, 255, 255));
        buttonnuevo.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add(3).png"))); // NOI18N
        getContentPane().add(buttonnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 40, 40));

        buttonguardar.setBackground(new java.awt.Color(232, 255, 255));
        buttonguardar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download.png"))); // NOI18N
        getContentPane().add(buttonguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, 40, -1));

        buttonmodificar.setBackground(new java.awt.Color(232, 255, 255));
        buttonmodificar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        getContentPane().add(buttonmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 50, 40));

        buttoneliminar.setBackground(new java.awt.Color(232, 255, 255));
        buttoneliminar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttoneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/garbage-bin(1).png"))); // NOI18N
        getContentPane().add(buttoneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, 40, 40));

        tablacliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Cedula", "Nombres", "Celular", "Estado", "Discapacidad", "Porcentaje"
            }
        ));
        jScrollPane1.setViewportView(tablacliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 660, 100));

        buttonimprimir.setBackground(new java.awt.Color(232, 255, 255));
        buttonimprimir.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/printer (5).png"))); // NOI18N
        getContentPane().add(buttonimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 410, 50, -1));

        buttonbuscar.setBackground(new java.awt.Color(232, 255, 255));
        buttonbuscar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        getContentPane().add(buttonbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 50, 30));
        getContentPane().add(labelcodigo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 130, 30));
        getContentPane().add(labelnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 200, 30));
        getContentPane().add(labelcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 130, 30));

        LabelPorcentajeDiscapacidad.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        LabelPorcentajeDiscapacidad.setText("Porcentaje de Discapacidad: ");
        getContentPane().add(LabelPorcentajeDiscapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, -1, -1));

        LabelCelular.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        LabelCelular.setText("Celular:");
        getContentPane().add(LabelCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        cmbDiscapacidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        getContentPane().add(cmbDiscapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 80, -1));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel26.setText("Discapacidad: ");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, -1));
        getContentPane().add(TxtPorcentajeDiscapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 80, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCelular;
    private javax.swing.JLabel LabelPorcentajeDiscapacidad;
    private javax.swing.JLabel LabelTINombres;
    private javax.swing.JSpinner TxtPorcentajeDiscapacidad;
    private javax.swing.JButton buttonbuscar;
    private javax.swing.JButton buttoneliminar;
    private javax.swing.JButton buttonguardar;
    private javax.swing.JButton buttonimprimir;
    private javax.swing.JButton buttonmodificar;
    private javax.swing.JButton buttonnuevo;
    private javax.swing.JComboBox<String> cmbDiscapacidad;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelcelular;
    private javax.swing.JLabel labelcodigo2;
    private javax.swing.JLabel labelnombres;
    private javax.swing.JTable tablacliente;
    private javax.swing.JTextField txtcedula;
    // End of variables declaration//GEN-END:variables
}
