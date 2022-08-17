package MUEBLES.Vista;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Vista_usuario extends javax.swing.JFrame {

    public Vista_usuario() {
        initComponents();
    }

    public JButton getBtneliminar() {
        return Btneliminar;
    }

    public void setBtneliminar(JButton Btneliminar) {
        this.Btneliminar = Btneliminar;
    }

    public JButton getBtnguardar() {
        return Btnguardar;
    }

    public void setBtnguardar(JButton Btnguardar) {
        this.Btnguardar = Btnguardar;
    }

    public JButton getBtnmodificar() {
        return Btnmodificar;
    }

    public void setBtnmodificar(JButton Btnmodificar) {
        this.Btnmodificar = Btnmodificar;
    }

    public JTable getTablausuario() {
        return Tablausuario;
    }

    public void setTablausuario(JTable Tablausuario) {
        this.Tablausuario = Tablausuario;
    }

    public JTextField getTxtcedula() {
        return Txtcedula;
    }

    public void setTxtcedula(JTextField Txtcedula) {
        this.Txtcedula = Txtcedula;
    }

    public JTextField getTxtcontraseña() {
        return Txtcontraseña;
    }

    public void setTxtcontraseña(JTextField Txtcontraseña) {
        this.Txtcontraseña = Txtcontraseña;
    }

    public JTextField getTxtestado() {
        return Txtestado;
    }

    public void setTxtestado(JTextField Txtestado) {
        this.Txtestado = Txtestado;
    }

    public JTextField getTxtrol() {
        return Txtrol;
    }

    public void setTxtrol(JTextField Txtrol) {
        this.Txtrol = Txtrol;
    }

    public JTextField getTxtusuario() {
        return Txtusuario;
    }

    public void setTxtusuario(JTextField Txtusuario) {
        this.Txtusuario = Txtusuario;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Txtcedula = new javax.swing.JTextField();
        Txtusuario = new javax.swing.JTextField();
        Txtcontraseña = new javax.swing.JTextField();
        Txtrol = new javax.swing.JTextField();
        Txtestado = new javax.swing.JTextField();
        Btnguardar = new javax.swing.JButton();
        Btnmodificar = new javax.swing.JButton();
        Btneliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablausuario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("CEDULA:");

        jLabel2.setText("NOMBRE USUARIO:");

        jLabel3.setText("CONTRASEÑA:");

        jLabel4.setText("ROL:");

        jLabel5.setText("ESTADO:");

        Btnguardar.setText("GUARDAR");

        Btnmodificar.setText("MOSIFICAR");
        Btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnmodificarActionPerformed(evt);
            }
        });

        Btneliminar.setText("ELIMINAR");

        Tablausuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CEDULA", "USUARIO", "CONTRASEÑA", "ROL", "ESTADO"
            }
        ));
        jScrollPane1.setViewportView(Tablausuario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Txtestado)
                            .addComponent(Txtrol)
                            .addComponent(Txtcontraseña)
                            .addComponent(Txtusuario)
                            .addComponent(Txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btnguardar)
                            .addComponent(Btnmodificar)
                            .addComponent(Btneliminar))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Btnguardar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btnmodificar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btneliminar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Txtrol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnmodificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnmodificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btneliminar;
    private javax.swing.JButton Btnguardar;
    private javax.swing.JButton Btnmodificar;
    private javax.swing.JTable Tablausuario;
    private javax.swing.JTextField Txtcedula;
    private javax.swing.JTextField Txtcontraseña;
    private javax.swing.JTextField Txtestado;
    private javax.swing.JTextField Txtrol;
    private javax.swing.JTextField Txtusuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
