package MUEBLES.Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Vista_usuario extends javax.swing.JFrame {

    public Vista_usuario() {
        initComponents();
    }

    public JButton getBtnguardar() {
        return Btnguardar;
    }

    public void setBtnguardar(JButton Btnguardar) {
        this.Btnguardar = Btnguardar;
    }

    public JButton getBtnbuscar() {
        return Btnbuscar;
    }

    public void setBtnbuscar(JButton Btnbuscar) {
        this.Btnbuscar = Btnbuscar;
    }

    public JButton getBtneliminar() {
        return Btneliminar;
    }

    public void setBtneliminar(JButton Btneliminar) {
        this.Btneliminar = Btneliminar;
    }

    public JButton getBtnmodificar() {
        return Btnmodificar;
    }

    public void setBtnmodificar(JButton Btnmodificar) {
        this.Btnmodificar = Btnmodificar;
    }

    public JComboBox<String> getCobcodigorol() {
        return Cobcodigorol;
    }

    public void setCobcodigorol(JComboBox<String> Cobcodigorol) {
        this.Cobcodigorol = Cobcodigorol;
    }

    public JComboBox<String> getCobestado() {
        return Cobestado;
    }

    public void setCobestado(JComboBox<String> Cobestado) {
        this.Cobestado = Cobestado;
    }

    public JTextField getTxtcedulapersona() {
        return Txtcedulapersona;
    }

    public void setTxtcedulapersona(JTextField Txtcedulapersona) {
        this.Txtcedulapersona = Txtcedulapersona;
    }

    public JTable getTablausuario() {
        return Tablausuario;
    }

    public void setTablausuario(JTable Tablausuario) {
        this.Tablausuario = Tablausuario;
    }

    public JTextField getTxtbuscar() {
        return Txtbuscar;
    }

    public void setTxtbuscar(JTextField Txtbuscar) {
        this.Txtbuscar = Txtbuscar;
    }

    public JTextField getTxtcodigousuario() {
        return Txtcodigousuario;
    }

    public void setTxtcodigousuario(JTextField Txtcodigousuario) {
        this.Txtcodigousuario = Txtcodigousuario;
    }

    public JTextField getTxtcontraseña() {
        return Txtcontraseña;
    }

    public void setTxtcontraseña(JTextField Txtcontraseña) {
        this.Txtcontraseña = Txtcontraseña;
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
        jLabel6 = new javax.swing.JLabel();
        Txtcodigousuario = new javax.swing.JTextField();
        Txtusuario = new javax.swing.JTextField();
        Cobcodigorol = new javax.swing.JComboBox<>();
        Cobestado = new javax.swing.JComboBox<>();
        Txtcontraseña = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablausuario = new javax.swing.JTable();
        Btnguardar = new javax.swing.JButton();
        Btnmodificar = new javax.swing.JButton();
        Btneliminar = new javax.swing.JButton();
        Txtbuscar = new javax.swing.JTextField();
        Btnbuscar = new javax.swing.JButton();
        Txtcedulapersona = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuario");
        setResizable(false);

        jLabel1.setText("CODIGO:");

        jLabel2.setText("CDL. PERSONA:");

        jLabel3.setText("NOMBRE DE USUARIO:");

        jLabel4.setText("CONTRASEÑA:");

        jLabel5.setText("ROL:");

        jLabel6.setText("ESTADO:");

        Cobestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INACTIVO", "ACTIVO" }));

        Tablausuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "CEDULA", "USUARIO", "CONTRASEÑA", "ROL", "ESTADO"
            }
        ));
        jScrollPane1.setViewportView(Tablausuario);

        Btnguardar.setText("GUARDAR");

        Btnmodificar.setText("MODIFICAR");

        Btneliminar.setText("ELIMINAR");

        Btnbuscar.setText("BUSCAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btnguardar)
                            .addComponent(Btnmodificar)
                            .addComponent(Btneliminar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Txtcodigousuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txtusuario)
                            .addComponent(Cobcodigorol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Cobestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Txtcontraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(Txtcedulapersona)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btnbuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Txtcodigousuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Txtcedulapersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Cobcodigorol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Cobestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btnbuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btnguardar)
                        .addGap(18, 18, 18)
                        .addComponent(Btnmodificar)
                        .addGap(18, 18, 18)
                        .addComponent(Btneliminar)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnbuscar;
    private javax.swing.JButton Btneliminar;
    private javax.swing.JButton Btnguardar;
    private javax.swing.JButton Btnmodificar;
    private javax.swing.JComboBox<String> Cobcodigorol;
    private javax.swing.JComboBox<String> Cobestado;
    private javax.swing.JTable Tablausuario;
    private javax.swing.JTextField Txtbuscar;
    private javax.swing.JTextField Txtcedulapersona;
    private javax.swing.JTextField Txtcodigousuario;
    private javax.swing.JTextField Txtcontraseña;
    private javax.swing.JTextField Txtusuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
