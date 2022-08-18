package vista;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class V_Usuario extends javax.swing.JInternalFrame {

    public V_Usuario() {
        initComponents();
    }

    public JLabel getLabelTituloUsuario() {
        return LabelTituloUsuario;
    }

    public void setLabelTituloUsuario(JLabel LabelTituloUsuario) {
        this.LabelTituloUsuario = LabelTituloUsuario;
    }

    public JPanel getPanel_Efecto_Usuario() {
        return Panel_Efecto_Usuario;
    }

    public void setPanel_Efecto_Usuario(JPanel Panel_Efecto_Usuario) {
        this.Panel_Efecto_Usuario = Panel_Efecto_Usuario;
    }

    public JButton getBtnBuscarPersona() {
        return BtnBuscarPersona;
    }

    public void setBtnBuscarPersona(JButton BtnBuscarPersona) {
        this.BtnBuscarPersona = BtnBuscarPersona;
    }

    public JButton getBtnBuscarRol() {
        return BtnBuscarRol;
    }

    public void setBtnBuscarRol(JButton BtnBuscarRol) {
        this.BtnBuscarRol = BtnBuscarRol;
    }

    public JCheckBox getCheckBoxEstado() {
        return CheckBoxEstado;
    }

    public void setCheckBoxEstado(JCheckBox CheckBoxEstado) {
        this.CheckBoxEstado = CheckBoxEstado;
    }

    public JPasswordField getJPassClave() {
        return JPassClave;
    }

    public void setJPassClave(JPasswordField JPassClave) {
        this.JPassClave = JPassClave;
    }

    public JLabel getLabelCodigoRol() {
        return LabelCodigoRol;
    }

    public void setLabelCodigoRol(JLabel LabelCodigoRol) {
        this.LabelCodigoRol = LabelCodigoRol;
    }

    public JLabel getLabelNombresPersona() {
        return LabelNombresPersona;
    }

    public void setLabelNombresPersona(JLabel LabelNombresPersona) {
        this.LabelNombresPersona = LabelNombresPersona;
    }

    public JTable getTableUsuario() {
        return TableUsuario;
    }

    public void setTableUsuario(JTable TableUsuario) {
        this.TableUsuario = TableUsuario;
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

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
    }

    public JLabel getLabelCodigoUsuario() {
        return labelCodigoUsuario;
    }

    public void setLabelCodigoUsuario(JLabel labelCodigoUsuario) {
        this.labelCodigoUsuario = labelCodigoUsuario;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(JTextField txtClave) {
        this.txtClave = txtClave;
    }

    public JTextField getTxtNombreRol() {
        return txtNombreRol;
    }

    public void setTxtNombreRol(JTextField txtNombreRol) {
        this.txtNombreRol = txtNombreRol;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnnuevo = new javax.swing.JButton();
        btnguardarp = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelCodigoUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        BtnBuscarRol = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        LabelNombresPersona = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JPassClave = new javax.swing.JPasswordField();
        txtClave = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNombreRol = new javax.swing.JTextField();
        BtnBuscarPersona = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        CheckBoxEstado = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableUsuario = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        LabelCodigoRol = new javax.swing.JLabel();
        Panel_Efecto_Usuario = new javax.swing.JPanel();
        LabelTituloUsuario = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevapersona.png"))); // NOI18N
        btnnuevo.setText("NUEVO");
        getContentPane().add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 170, 40));

        btnguardarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar-archivo.png"))); // NOI18N
        btnguardarp.setText("GUARDAR");
        getContentPane().add(btnguardarp, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 180, 40));

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lapiz.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        getContentPane().add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 190, 40));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminarusuario.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 180, 40));

        jLabel2.setText("CODIGO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 100, 40));
        getContentPane().add(labelCodigoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 130, 30));

        jLabel4.setText("CEDULA:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 80, 40));
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 220, 40));

        BtnBuscarRol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        getContentPane().add(BtnBuscarRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 90, 50));

        jLabel5.setText("NOMBRES:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 110, 50));
        getContentPane().add(LabelNombresPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 300, 50));

        jLabel7.setText("USUARIO:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 90, 50));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 220, 40));

        jLabel8.setText("CLAVE:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 70, 40));

        JPassClave.setText("jPasswordField1");
        getContentPane().add(JPassClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 220, 40));
        getContentPane().add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 220, 40));

        jLabel9.setText("ROL:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 50, 40));
        getContentPane().add(txtNombreRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 220, 40));

        BtnBuscarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        getContentPane().add(BtnBuscarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 90, 50));

        jLabel10.setText("ESTADO:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 80, 40));

        CheckBoxEstado.setText("Activo");
        getContentPane().add(CheckBoxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 110, 30));

        TableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "CEDULA", "USUARIO", "CLAVE", "ROL", "ESTADO"
            }
        ));
        jScrollPane1.setViewportView(TableUsuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 920, 100));

        jLabel11.setText("CODIGO:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 110, 50));
        getContentPane().add(LabelCodigoRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 240, 40));

        Panel_Efecto_Usuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelTituloUsuario.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        LabelTituloUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grupo.png"))); // NOI18N
        LabelTituloUsuario.setText("USUARIO");
        Panel_Efecto_Usuario.add(LabelTituloUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 60));

        getContentPane().add(Panel_Efecto_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 200, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscarPersona;
    private javax.swing.JButton BtnBuscarRol;
    private javax.swing.JCheckBox CheckBoxEstado;
    private javax.swing.JPasswordField JPassClave;
    private javax.swing.JLabel LabelCodigoRol;
    private javax.swing.JLabel LabelNombresPersona;
    private javax.swing.JLabel LabelTituloUsuario;
    private javax.swing.JPanel Panel_Efecto_Usuario;
    private javax.swing.JTable TableUsuario;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardarp;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelCodigoUsuario;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtNombreRol;
    // End of variables declaration//GEN-END:variables
}
