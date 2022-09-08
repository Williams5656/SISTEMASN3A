package vista;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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

    public JButton getBtnimprimir() {
        return btnimprimir;
    }

    public void setBtnimprimir(JButton btnimprimir) {
        this.btnimprimir = btnimprimir;
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

    public JLabel getLabelEstado() {
        return labelEstado;
    }

    public void setLabelEstado(JLabel labelEstado) {
        this.labelEstado = labelEstado;
    }

    public JButton getBtnBuscarPersona() {
        return BtnBuscarPersona;
    }

    public void setBtnBuscarPersona(JButton BtnBuscarPersona) {
        this.BtnBuscarPersona = BtnBuscarPersona;
    }

    public JComboBox<String> getCmbRol() {
        return cmbRol;
    }

    public void setCmbRol(JComboBox<String> cmbRol) {
        this.cmbRol = cmbRol;
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

    public JTextField getTxtUsuario() {
        return TxtUsuario;
    }

    public void setTxtUsuario(JTextField TxtUsuario) {
        this.TxtUsuario = TxtUsuario;
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
        jLabel5 = new javax.swing.JLabel();
        LabelNombresPersona = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JPassClave = new javax.swing.JPasswordField();
        txtClave = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        BtnBuscarPersona = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        CheckBoxEstado = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableUsuario = new javax.swing.JTable();
        Panel_Efecto_Usuario = new javax.swing.JPanel();
        LabelTituloUsuario = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        labelEstado = new javax.swing.JLabel();
        btnimprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevapersona.png"))); // NOI18N
        btnnuevo.setText("NUEVO");
        getContentPane().add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 170, 30));

        btnguardarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar-archivo.png"))); // NOI18N
        btnguardarp.setText("GUARDAR");
        getContentPane().add(btnguardarp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 180, 30));

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lapiz.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        getContentPane().add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 190, 30));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminarusuario.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 170, 30));

        jLabel2.setText("CODIGO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 100, 30));
        getContentPane().add(labelCodigoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 130, 30));

        jLabel4.setText("CEDULA:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 80, 30));
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 220, 30));

        jLabel5.setText("NOMBRES:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 100, 40));
        getContentPane().add(LabelNombresPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 300, 40));

        jLabel7.setText("USUARIO:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 90, 40));
        getContentPane().add(TxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 220, 30));

        jLabel8.setText("CLAVE:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 70, 30));

        JPassClave.setText("jPasswordField1");
        getContentPane().add(JPassClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 220, 30));
        getContentPane().add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 220, 30));

        jLabel9.setText("ROL:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 50, 30));

        BtnBuscarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        getContentPane().add(BtnBuscarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 90, 40));

        jLabel10.setText("ESTADO:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 80, 30));
        getContentPane().add(CheckBoxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 30, 30));

        TableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "CEDULA", "USUARIO", "ROL", "ESTADO"
            }
        ));
        jScrollPane1.setViewportView(TableUsuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 930, 110));

        Panel_Efecto_Usuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelTituloUsuario.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        LabelTituloUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grupo.png"))); // NOI18N
        LabelTituloUsuario.setText("USUARIO");
        Panel_Efecto_Usuario.add(LabelTituloUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 60));

        getContentPane().add(Panel_Efecto_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 200, 60));

        getContentPane().add(cmbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 220, 30));

        labelEstado.setText("Activo");
        getContentPane().add(labelEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 110, 30));

        btnimprimir.setText("IMPRIMIR");
        getContentPane().add(btnimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 550, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscarPersona;
    private javax.swing.JCheckBox CheckBoxEstado;
    private javax.swing.JPasswordField JPassClave;
    private javax.swing.JLabel LabelNombresPersona;
    private javax.swing.JLabel LabelTituloUsuario;
    private javax.swing.JPanel Panel_Efecto_Usuario;
    private javax.swing.JTable TableUsuario;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardarp;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodigoUsuario;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtClave;
    // End of variables declaration//GEN-END:variables
}
