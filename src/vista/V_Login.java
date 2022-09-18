package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class V_Login extends javax.swing.JFrame {

    public V_Login() {
        initComponents();
    }

    public JLabel getBarraMovi() {
        return BarraMovi;
    }

    public void setBarraMovi(JLabel BarraMovi) {
        this.BarraMovi = BarraMovi;
    }

    public JLabel getBtn_Cerrar() {
        return Btn_Cerrar;
    }

    public void setBtn_Cerrar(JLabel Btn_Cerrar) {
        this.Btn_Cerrar = Btn_Cerrar;
    }

    public JButton getBtn_Ingresar() {
        return Btn_Ingresar;
    }

    public void setBtn_Ingresar(JButton Btn_Ingresar) {
        this.Btn_Ingresar = Btn_Ingresar;
    }

    public JLabel getEfecto_Cerrar() {
        return Efecto_Cerrar;
    }

    public JPanel getPanelCerrar() {
        return PanelCerrar;
    }

    public void setPanelCerrar(JPanel PanelCerrar) {
        this.PanelCerrar = PanelCerrar;
    }

    public void setEfecto_Cerrar(JLabel Efecto_Cerrar) {
        this.Efecto_Cerrar = Efecto_Cerrar;
    }

    public JLabel getLabelClave() {
        return LabelClave;
    }

    public void setLabelClave(JLabel LabelClave) {
        this.LabelClave = LabelClave;
    }

    public JLabel getLabelMostrar() {
        return LabelMostrar;
    }

    public void setLabelMostrar(JLabel LabelMostrar) {
        this.LabelMostrar = LabelMostrar;
    }

    public JLabel getLabelOcultar() {
        return LabelOcultar;
    }

    public void setLabelOcultar(JLabel LabelOcultar) {
        this.LabelOcultar = LabelOcultar;
    }

    public JLabel getLabelUsuario() {
        return LabelUsuario;
    }

    public void setLabelUsuario(JLabel LabelUsuario) {
        this.LabelUsuario = LabelUsuario;
    }

    public JPasswordField getjPassClave() {
        return jPassClave;
    }

    public void setjPassClave(JPasswordField jPassClave) {
        this.jPassClave = jPassClave;
    }

    public JTextField getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(JTextField txtClave) {
        this.txtClave = txtClave;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn_Ingresar = new javax.swing.JButton();
        LabelClave = new javax.swing.JLabel();
        LabelUsuario = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        jPassClave = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        LabelMostrar = new javax.swing.JLabel();
        LabelOcultar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PanelCerrar = new javax.swing.JPanel();
        Efecto_Cerrar = new javax.swing.JLabel();
        Btn_Cerrar = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();
        BarraMovi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Ingresar.setBackground(new java.awt.Color(186, 246, 158));
        Btn_Ingresar.setFont(new java.awt.Font("Microsoft Tai Le", 3, 18)); // NOI18N
        Btn_Ingresar.setText("Ingresar");
        Btn_Ingresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Btn_Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 140, 30));

        LabelClave.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        LabelClave.setForeground(new java.awt.Color(164, 224, 240));
        getContentPane().add(LabelClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 140, 30));

        LabelUsuario.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        LabelUsuario.setForeground(new java.awt.Color(164, 224, 240));
        getContentPane().add(LabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, 30));
        getContentPane().add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 240, 30));

        jPassClave.setText("jPasswordField1");
        getContentPane().add(jPassClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 240, 30));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 240, 30));

        LabelMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/esconder2.png"))); // NOI18N
        getContentPane().add(LabelMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 50, 30));

        LabelOcultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ojo2.png"))); // NOI18N
        getContentPane().add(LabelOcultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 50, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconLog.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, 80));

        PanelCerrar.setBackground(new java.awt.Color(3, 3, 3));
        PanelCerrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Efecto_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerca.png"))); // NOI18N
        PanelCerrar.add(Efecto_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        Btn_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar-sesion2.png"))); // NOI18N
        PanelCerrar.add(Btn_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        getContentPane().add(PanelCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 50, 40));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LoginFondo.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 380));
        getContentPane().add(BarraMovi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BarraMovi;
    private javax.swing.JLabel Btn_Cerrar;
    private javax.swing.JButton Btn_Ingresar;
    private javax.swing.JLabel Efecto_Cerrar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel LabelClave;
    private javax.swing.JLabel LabelMostrar;
    private javax.swing.JLabel LabelOcultar;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JPanel PanelCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPassClave;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
