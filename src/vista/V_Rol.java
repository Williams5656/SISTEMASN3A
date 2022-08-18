package vista;

import javax.swing.*;

public class V_Rol extends javax.swing.JInternalFrame {

    public V_Rol() {
        initComponents();
    }

    public JButton getBtnBuscarRol() {
        return BtnBuscarRol;
    }

    public void setBtnBuscarRol(JButton BtnBuscarRol) {
        this.BtnBuscarRol = BtnBuscarRol;
    }

    public JTextField getTxtBuscarRol() {
        return txtBuscarRol;
    }

    public void setTxtBuscarRol(JTextField txtBuscarRol) {
        this.txtBuscarRol = txtBuscarRol;
    }

    public JCheckBox getCheckBoxEstado() {
        return CheckBoxEstado;
    }

    public void setCheckBoxEstado(JCheckBox CheckBoxEstado) {
        this.CheckBoxEstado = CheckBoxEstado;
    }

    public JTable getTableRol() {
        return TableRol;
    }

    public void setTableRol(JTable TableRol) {
        this.TableRol = TableRol;
    }

    public JTextArea getTxtDescripcion() {
        return TxtDescripcion;
    }

    public void setTxtDescripcion(JTextArea TxtDescripcion) {
        this.TxtDescripcion = TxtDescripcion;
    }

    public JButton getBtneliminar() {
        return btneliminar;
    }

    public void setBtneliminar(JButton btneliminar) {
        this.btneliminar = btneliminar;
    }

    public JButton getBtnguardarp() {
        return btnguardarp;
    }

    public void setBtnguardarp(JButton btnguardarp) {
        this.btnguardarp = btnguardarp;
    }

    public JButton getBtnmodificar() {
        return btnmodificar;
    }

    public void setBtnmodificar(JButton btnmodificar) {
        this.btnmodificar = btnmodificar;
    }

    public JButton getBtnnuevo() {
        return btnnuevo;
    }

    public void setBtnnuevo(JButton btnnuevo) {
        this.btnnuevo = btnnuevo;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JLabel getLabelCodRol() {
        return labelCodRol;
    }

    public void setLabelCodRol(JLabel labelCodRol) {
        this.labelCodRol = labelCodRol;
    }

    public JTextField getTxtnombre() {
        return txtnombre;
    }

    public void setTxtnombre(JTextField txtnombre) {
        this.txtnombre = txtnombre;
    }

    public JLabel getLabelEstado() {
        return LabelEstado;
    }

    public void setLabelEstado(JLabel LabelEstado) {
        this.LabelEstado = LabelEstado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LabelEstado = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableRol = new javax.swing.JTable();
        CheckBoxEstado = new javax.swing.JCheckBox();
        btnnuevo = new javax.swing.JButton();
        btnguardarp = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        labelCodRol = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtDescripcion = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtBuscarRol = new javax.swing.JTextField();
        BtnBuscarRol = new javax.swing.JButton();

        setBackground(new java.awt.Color(79, 213, 223));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Imgrol.png"))); // NOI18N
        jLabel1.setText("ROLES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 190, 50));

        jLabel2.setText("CODIGO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 100, 30));

        jLabel3.setText("NOMBRE:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 90, 40));

        jLabel4.setText("DESCRIPCION:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 130, 40));

        jLabel5.setText("ESTADO:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 100, 40));

        LabelEstado.setText("Activo");
        getContentPane().add(LabelEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 110, 30));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 170, 40));

        TableRol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "DESCRIPCION", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableRol);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 840, 110));

        CheckBoxEstado.setBackground(new java.awt.Color(79, 213, 223));
        getContentPane().add(CheckBoxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 30, 30));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevapersona.png"))); // NOI18N
        btnnuevo.setText("NUEVO");
        getContentPane().add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 170, 40));

        btnguardarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar-archivo.png"))); // NOI18N
        btnguardarp.setText("GUARDAR");
        getContentPane().add(btnguardarp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 180, 40));

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lapiz.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        getContentPane().add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 190, 40));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminarusuario.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 180, 50));
        getContentPane().add(labelCodRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 160, 30));

        TxtDescripcion.setColumns(20);
        TxtDescripcion.setRows(5);
        jScrollPane2.setViewportView(TxtDescripcion);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 390, 110));

        jLabel6.setText("BUSCAR:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 90, 40));

        txtBuscarRol.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        txtBuscarRol.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscarRol.setText("Ingrese el nombre del rol");
        getContentPane().add(txtBuscarRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 250, 40));

        BtnBuscarRol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        getContentPane().add(BtnBuscarRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 70, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscarRol;
    private javax.swing.JCheckBox CheckBoxEstado;
    private javax.swing.JLabel LabelEstado;
    private javax.swing.JTable TableRol;
    private javax.swing.JTextArea TxtDescripcion;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardarp;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCodRol;
    private javax.swing.JTextField txtBuscarRol;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables

}
