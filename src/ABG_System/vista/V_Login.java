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

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/Login.png"));
        Image image = icon.getImage();
        jPanel1 = new javax.swing.JPanel(){
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUsuario.setFont(new java.awt.Font("Script MT Bold", 3, 24)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(164, 224, 240));
        jPanel1.add(labelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 170, 60));

        labelclave.setFont(new java.awt.Font("Script MT Bold", 3, 24)); // NOI18N
        labelclave.setForeground(new java.awt.Color(164, 224, 240));
        jPanel1.add(labelclave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 280, 60));

        LabelTitulo.setFont(new java.awt.Font("Script MT Bold", 3, 36)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(164, 224, 240));
        LabelTitulo.setText("    ABG ");
        jPanel1.add(LabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 170, 60));

        txtUsuario.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        txtUsuario.setText("Usuario:");
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 250, 60));

        JpassUser.setText("jPasswordField1");
        jPanel1.add(JpassUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 260, 60));

        txtPassUser.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        txtPassUser.setForeground(new java.awt.Color(153, 153, 153));
        txtPassUser.setText("Contraseña:");
        jPanel1.add(txtPassUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 260, 60));

        BtnIngresar.setBackground(new java.awt.Color(186, 252, 245));
        BtnIngresar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 18)); // NOI18N
        BtnIngresar.setText("INGRESAR");
        BtnIngresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(BtnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 160, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JPasswordField JpassUser;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labelclave;
    private javax.swing.JTextField txtPassUser;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
