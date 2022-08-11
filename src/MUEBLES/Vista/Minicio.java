package MUEBLES.Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
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

    public JComboBox<String> getCobrol_inicio() {
        return Cobrol_inicio;
    }

    public void setCobrol_inicio(JComboBox<String> Cobrol_inicio) {
        this.Cobrol_inicio = Cobrol_inicio;
    }

    public JTextField getTxtContrasenia_inicio() {
        return TxtContrasenia_inicio;
    }

    public void setTxtContrasenia_inicio(JTextField TxtContrasenia_inicio) {
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
        jLabel3 = new javax.swing.JLabel();
        Btningresar_inicio = new javax.swing.JButton();
        Btncancelar_inicio = new javax.swing.JButton();
        Btnloguear_inicio = new javax.swing.JButton();
        Txtusuario_inicio = new javax.swing.JTextField();
        TxtContrasenia_inicio = new javax.swing.JTextField();
        Cobrol_inicio = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("USUARIO:");

        jLabel2.setText("CONTRASEÑA:");

        jLabel3.setText("ROL:");

        Btningresar_inicio.setText("INGRESAR");

        Btncancelar_inicio.setText("CANCELAR");

        Btnloguear_inicio.setText("LOGUEAR");

        Cobrol_inicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maquinas", "Lijado", "Lacado", "Tapizado", "Empacado", "Bodega", "Despachos", "Entregas" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Btningresar_inicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(Btncancelar_inicio)
                .addGap(63, 63, 63)
                .addComponent(Btnloguear_inicio)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Txtusuario_inicio)
                    .addComponent(TxtContrasenia_inicio)
                    .addComponent(Cobrol_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Txtusuario_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtContrasenia_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Cobrol_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btningresar_inicio)
                    .addComponent(Btncancelar_inicio)
                    .addComponent(Btnloguear_inicio))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btncancelar_inicio;
    private javax.swing.JButton Btningresar_inicio;
    private javax.swing.JButton Btnloguear_inicio;
    private javax.swing.JComboBox<String> Cobrol_inicio;
    private javax.swing.JTextField TxtContrasenia_inicio;
    private javax.swing.JTextField Txtusuario_inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
