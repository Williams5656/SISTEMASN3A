package MUEBLES.Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Minicio extends javax.swing.JFrame {

    public Minicio() {
        initComponents();
    }

    public JButton getBtncancelar_inicio() {
        return Btncancelar_inicio;
    }

    public void setBtncancelar_inicio(JButton Btncancelar_inicio) {
        this.Btncancelar_inicio = Btncancelar_inicio;
    }

    public JButton getBtningresar_inicio() {
        return Btningresar_inicio;
    }

    public void setBtningresar_inicio(JButton Btningresar_inicio) {
        this.Btningresar_inicio = Btningresar_inicio;
    }

    public JButton getBtnloguear_inicio() {
        return Btnloguear_inicio;
    }

    public void setBtnloguear_inicio(JButton Btnloguear_inicio) {
        this.Btnloguear_inicio = Btnloguear_inicio;
    }

    public JPasswordField getTxtContrasenia_inicio() {
        return TxtContrasenia_inicio;
    }

    public void setTxtContrasenia_inicio(JPasswordField TxtContrasenia_inicio) {
        this.TxtContrasenia_inicio = TxtContrasenia_inicio;
    }

    public JTextField getTxtusuario_inicio() {
        return Txtusuario_inicio;
    }

    public void setTxtusuario_inicio(JTextField Txtusuario_inicio) {
        this.Txtusuario_inicio = Txtusuario_inicio;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Btningresar_inicio = new javax.swing.JButton();
        Btncancelar_inicio = new javax.swing.JButton();
        Btnloguear_inicio = new javax.swing.JButton();
        Txtusuario_inicio = new javax.swing.JTextField();
        TxtContrasenia_inicio = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("USUARIO:");

        jLabel2.setText("CONTRASEÑA:");

        Btningresar_inicio.setText("INGRESAR");

        Btncancelar_inicio.setText("CANCELAR");

        Btnloguear_inicio.setText("LOGUEAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Txtusuario_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(TxtContrasenia_inicio)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btningresar_inicio)
                        .addGap(18, 18, 18)
                        .addComponent(Btncancelar_inicio)
                        .addGap(18, 18, 18)
                        .addComponent(Btnloguear_inicio)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Txtusuario_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtContrasenia_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btningresar_inicio)
                    .addComponent(Btncancelar_inicio)
                    .addComponent(Btnloguear_inicio))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btncancelar_inicio;
    private javax.swing.JButton Btningresar_inicio;
    private javax.swing.JButton Btnloguear_inicio;
    private javax.swing.JPasswordField TxtContrasenia_inicio;
    private javax.swing.JTextField Txtusuario_inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
