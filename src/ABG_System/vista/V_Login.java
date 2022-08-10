package ABG_System.vista;

import java.awt.*;
import javax.swing.*;

public class V_Login extends javax.swing.JFrame {

    public V_Login() {
        initComponents();
    }

    public JButton getBtnIngresar() {
        return BtnIngresar;
    }

    public void setBtnIngresar(JButton BtnIngresar) {
        this.BtnIngresar = BtnIngresar;
    }

    public JPasswordField getJpassUser() {
        return JpassUser;
    }

    public void setJpassUser(JPasswordField JpassUser) {
        this.JpassUser = JpassUser;
    }

    public JLabel getLabelTitulo() {
        return LabelTitulo;
    }

    public void setLabelTitulo(JLabel LabelTitulo) {
        this.LabelTitulo = LabelTitulo;
    }

    public JLabel getLabelUsuario() {
        return labelUsuario;
    }

    public void setLabelUsuario(JLabel labelUsuario) {
        this.labelUsuario = labelUsuario;
    }

    public JLabel getLabelclave() {
        return labelclave;
    }

    public void setLabelclave(JLabel labelclave) {
        this.labelclave = labelclave;
    }

    public JTextField getTxtPassUser() {
        return txtPassUser;
    }

    public void setTxtPassUser(JTextField txtPassUser) {
        this.txtPassUser = txtPassUser;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public JPanel getPanelCerrar() {
        return PanelCerrar;
    }

    public void setPanelCerrar(JPanel PanelCerrar) {
        this.PanelCerrar = PanelCerrar;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public JLabel getAnimacion_Cerrar() {
        return Animacion_Cerrar;
    }

    public void setAnimacion_Cerrar(JLabel Animacion_Cerrar) {
        this.Animacion_Cerrar = Animacion_Cerrar;
    }

    public JPanel getBarraMovi() {
        return BarraMovi;
    }

    public void setBarraMovi(JPanel BarraMovi) {
        this.BarraMovi = BarraMovi;
    }

    public JLabel getBtn_Cerrar() {
        return Btn_Cerrar;
    }

    public void setBtn_Cerrar(JLabel Btn_Cerrar) {
        this.Btn_Cerrar = Btn_Cerrar;
    }

    public JLabel getLabelMostrar() {
        return labelMostrar;
    }

    public void setLabelMostrar(JLabel labelMostrar) {
        this.labelMostrar = labelMostrar;
    }

    public JLabel getLabelOcultar() {
        return labelOcultar;
    }

    public void setLabelOcultar(JLabel labelOcultar) {
        this.labelOcultar = labelOcultar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/ABG_System/controlador/Login.png"));
        Image image = icon.getImage();
        Fondo = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        }
        ;
        labelUsuario = new javax.swing.JLabel();
        labelclave = new javax.swing.JLabel();
        LabelTitulo = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        JpassUser = new javax.swing.JPasswordField();
        txtPassUser = new javax.swing.JTextField();
        BtnIngresar = new javax.swing.JButton();
        BarraMovi = new javax.swing.JPanel();
        PanelCerrar = new javax.swing.JPanel();
        Animacion_Cerrar = new javax.swing.JLabel();
        Btn_Cerrar = new javax.swing.JLabel();
        labelMostrar = new javax.swing.JLabel();
        labelOcultar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        Fondo.setBackground(new java.awt.Color(3, 3, 3));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUsuario.setFont(new java.awt.Font("Script MT Bold", 3, 24)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(164, 224, 240));
        Fondo.add(labelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 170, 60));

        labelclave.setFont(new java.awt.Font("Script MT Bold", 3, 24)); // NOI18N
        labelclave.setForeground(new java.awt.Color(164, 224, 240));
        Fondo.add(labelclave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 280, 60));

        LabelTitulo.setFont(new java.awt.Font("Script MT Bold", 3, 36)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(164, 224, 240));
        LabelTitulo.setText("    ABG ");
        Fondo.add(LabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 170, 60));

        txtUsuario.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        Fondo.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 250, 60));
        Fondo.add(JpassUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 260, 60));

        txtPassUser.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        txtPassUser.setForeground(new java.awt.Color(153, 153, 153));
        txtPassUser.setText("Contraseña:");
        Fondo.add(txtPassUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 260, 60));

        BtnIngresar.setBackground(new java.awt.Color(186, 252, 245));
        BtnIngresar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 18)); // NOI18N
        BtnIngresar.setText("INGRESAR");
        BtnIngresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Fondo.add(BtnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 160, 50));

        BarraMovi.setBackground(new java.awt.Color(3, 3, 3));
        BarraMovi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelCerrar.setBackground(new java.awt.Color(3, 3, 3));
        PanelCerrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Animacion_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ABG_System/controlador/cerca.png"))); // NOI18N
        PanelCerrar.add(Animacion_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 46, 60));

        Btn_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ABG_System/controlador/cerrar-sesion.png"))); // NOI18N
        PanelCerrar.add(Btn_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 50, 60));

        BarraMovi.add(PanelCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, -1));

        Fondo.add(BarraMovi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 60));

        labelMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ABG_System/controlador/ojo.png"))); // NOI18N
        Fondo.add(labelMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 80, 70));

        labelOcultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ABG_System/controlador/esconder.png"))); // NOI18N
        labelOcultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelOcultarMouseEntered(evt);
            }
        });
        Fondo.add(labelOcultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 70, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelOcultarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOcultarMouseEntered
      
    }//GEN-LAST:event_labelOcultarMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Animacion_Cerrar;
    private javax.swing.JPanel BarraMovi;
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JLabel Btn_Cerrar;
    private javax.swing.JPanel Fondo;
    private javax.swing.JPasswordField JpassUser;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel PanelCerrar;
    private javax.swing.JLabel labelMostrar;
    private javax.swing.JLabel labelOcultar;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labelclave;
    private javax.swing.JTextField txtPassUser;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
