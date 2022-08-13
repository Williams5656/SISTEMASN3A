package vista;

import java.awt.Color;
import java.awt.Font;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn_Ingresar = new javax.swing.JButton();
        LabelClave = new javax.swing.JLabel();
        LabelUsuario = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jPassClave = new javax.swing.JPasswordField();
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

        Btn_Ingresar.setBackground(new java.awt.Color(204, 204, 204));
        Btn_Ingresar.setFont(new java.awt.Font("Microsoft Tai Le", 3, 24)); // NOI18N
        Btn_Ingresar.setText("Ingresar");
        Btn_Ingresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Btn_Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, 170, 50));

        LabelClave.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        LabelClave.setForeground(new java.awt.Color(164, 224, 240));
        getContentPane().add(LabelClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 220, 60));

        LabelUsuario.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        LabelUsuario.setForeground(new java.awt.Color(164, 224, 240));
        getContentPane().add(LabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 220, 60));
        getContentPane().add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 290, 60));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 290, 60));

        jPassClave.setText("jPasswordField1");
        getContentPane().add(jPassClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 290, 60));

        LabelMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/esconder.png"))); // NOI18N
        getContentPane().add(LabelMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 80, 80));

        LabelOcultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ojo.png"))); // NOI18N
        getContentPane().add(LabelOcultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 90, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconoInico.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 130, 130));

        PanelCerrar.setBackground(new java.awt.Color(3, 3, 3));
        PanelCerrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Efecto_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerca.png"))); // NOI18N
        PanelCerrar.add(Efecto_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 70));

        Btn_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar-sesion.png"))); // NOI18N
        PanelCerrar.add(Btn_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 70));

        getContentPane().add(PanelCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 70, 70));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Login.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 561, 650));

        BarraMovi.setText("jLabel1");
        getContentPane().add(BarraMovi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 60));

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
