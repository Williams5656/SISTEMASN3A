package MUEBLES.Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Vista_persona_muebles extends javax.swing.JFrame {

    public Vista_persona_muebles() {
        initComponents();
    }

    public JButton getBtcargar() {
        return Btcargar;
    }

    public void setBtcargar(JButton Btcargar) {
        this.Btcargar = Btcargar;
    }

    public JButton getBteliminar() {
        return Bteliminar;
    }

    public void setBteliminar(JButton Bteliminar) {
        this.Bteliminar = Bteliminar;
    }

    public JButton getBtguarda() {
        return Btguarda;
    }

    public void setBtguarda(JButton Btguarda) {
        this.Btguarda = Btguarda;
    }

    public JButton getBtmodifica() {
        return Btmodifica;
    }

    public void setBtmodifica(JButton Btmodifica) {
        this.Btmodifica = Btmodifica;
    }

    public JTable getTabla_muebles_persona() {
        return Tabla_muebles_persona;
    }

    public void setTabla_muebles_persona(JTable Tabla_muebles_persona) {
        this.Tabla_muebles_persona = Tabla_muebles_persona;
    }

    public JTextField getTxtapellidos() {
        return Txtapellidos;
    }

    public void setTxtapellidos(JTextField Txtapellidos) {
        this.Txtapellidos = Txtapellidos;
    }

    public JTextField getTxtcedula() {
        return Txtcedula;
    }

    public void setTxtcedula(JTextField Txtcedula) {
        this.Txtcedula = Txtcedula;
    }

    public JTextField getTxtcelular() {
        return Txtcelular;
    }

    public void setTxtcelular(JTextField Txtcelular) {
        this.Txtcelular = Txtcelular;
    }

    public JTextField getTxtdireccion() {
        return Txtdireccion;
    }

    public void setTxtdireccion(JTextField Txtdireccion) {
        this.Txtdireccion = Txtdireccion;
    }

    public JTextField getTxtfecha() {
        return Txtfecha;
    }

    public void setTxtfecha(JTextField Txtfecha) {
        this.Txtfecha = Txtfecha;
    }

    public JTextField getTxtnacionalidad() {
        return Txtnacionalidad;
    }

    public void setTxtnacionalidad(JTextField Txtnacionalidad) {
        this.Txtnacionalidad = Txtnacionalidad;
    }

    public JTextField getTxtnombres() {
        return Txtnombres;
    }

    public void setTxtnombres(JTextField Txtnombres) {
        this.Txtnombres = Txtnombres;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getJimagen() {
        return jimagen;
    }

    public void setJimagen(JLabel jimagen) {
        this.jimagen = jimagen;
    }

    public JButton getBtnbuscar() {
        return Btnbuscar;
    }

    public void setBtnbuscar(JButton Btnbuscar) {
        this.Btnbuscar = Btnbuscar;
    }

    public JTextField getTxtbuscar() {
        return Txtbuscar;
    }

    public void setTxtbuscar(JTextField Txtbuscar) {
        this.Txtbuscar = Txtbuscar;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_muebles_persona = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Txtcedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Txtnombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Txtapellidos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Txtdireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Txtcelular = new javax.swing.JTextField();
        Txtnacionalidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Txtfecha = new javax.swing.JTextField();
        jimagen = new javax.swing.JLabel();
        Btguarda = new javax.swing.JButton();
        Btmodifica = new javax.swing.JButton();
        Bteliminar = new javax.swing.JButton();
        Btcargar = new javax.swing.JButton();
        Btnbuscar = new javax.swing.JButton();
        Txtbuscar = new javax.swing.JTextField();

        setTitle("PERSONA");
        setResizable(false);

        Tabla_muebles_persona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CEDULA", "NOMBRES", "APELLIDOS", "DIRECCION", "CELULAR", "NACIONALIDAD", "FECHA DE NACIMIENTO", "FOTO"
            }
        ));
        jScrollPane1.setViewportView(Tabla_muebles_persona);

        jLabel1.setText("Cedula:");

        jLabel2.setText("Nombres:");

        jLabel3.setText("Apellidos:");

        jLabel7.setText("Direccion:");

        jLabel6.setText("Celular:");

        jLabel5.setText("Nacionalidad:");

        jLabel4.setText("Fecha de nacimineto:");

        jimagen.setText("FOTO");
        jimagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        Btguarda.setText("GUARDAR");

        Btmodifica.setText("MODIFICAR");

        Bteliminar.setText("ELIMINAR");

        Btcargar.setText("CARGAR");
        Btcargar.setToolTipText("");

        Btnbuscar.setText("BUSCAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel3))
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(Txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(Txtnacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(Txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(Btcargar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btguarda)
                            .addComponent(Btmodifica)
                            .addComponent(Bteliminar))))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btnbuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(Btcargar)
                        .addGap(193, 193, 193)
                        .addComponent(Btguarda)
                        .addGap(18, 18, 18)
                        .addComponent(Btmodifica)
                        .addGap(18, 18, 18)
                        .addComponent(Bteliminar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6))
                            .addComponent(Txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txtnacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btnbuscar)
                            .addComponent(Txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btcargar;
    private javax.swing.JButton Bteliminar;
    private javax.swing.JButton Btguarda;
    private javax.swing.JButton Btmodifica;
    private javax.swing.JButton Btnbuscar;
    private javax.swing.JTable Tabla_muebles_persona;
    private javax.swing.JTextField Txtapellidos;
    private javax.swing.JTextField Txtbuscar;
    private javax.swing.JTextField Txtcedula;
    private javax.swing.JTextField Txtcelular;
    private javax.swing.JTextField Txtdireccion;
    private javax.swing.JTextField Txtfecha;
    private javax.swing.JTextField Txtnacionalidad;
    private javax.swing.JTextField Txtnombres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jimagen;
    // End of variables declaration//GEN-END:variables
}
