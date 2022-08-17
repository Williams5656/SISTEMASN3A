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

        setTitle("PERSONA");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 274, 549, 309));

        jLabel1.setText("Cedula:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 9, -1, -1));
        getContentPane().add(Txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 6, 232, -1));

        jLabel2.setText("Nombres:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 49, -1, -1));
        getContentPane().add(Txtnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 46, 232, -1));

        jLabel3.setText("Apellidos:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 89, -1, -1));
        getContentPane().add(Txtapellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 86, 232, -1));

        jLabel7.setText("Direccion:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 129, -1, -1));
        getContentPane().add(Txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 126, 232, -1));

        jLabel6.setText("Celular:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 169, -1, -1));
        getContentPane().add(Txtcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 166, 232, -1));
        getContentPane().add(Txtnacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 194, 232, -1));

        jLabel5.setText("Nacionalidad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 197, -1, -1));

        jLabel4.setText("Fecha de nacimineto:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 237, -1, -1));
        getContentPane().add(Txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 234, 232, -1));

        jimagen.setText("FOTO");
        jimagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(jimagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 6, 145, 148));

        Btguarda.setText("GUARDAR");
        getContentPane().add(Btguarda, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 325, -1, -1));

        Btmodifica.setText("MODIFICAR");
        getContentPane().add(Btmodifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 365, -1, -1));

        Bteliminar.setText("ELIMINAR");
        getContentPane().add(Bteliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 405, -1, -1));

        Btcargar.setText("CARGAR");
        Btcargar.setToolTipText("");
        getContentPane().add(Btcargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 166, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btcargar;
    private javax.swing.JButton Bteliminar;
    private javax.swing.JButton Btguarda;
    private javax.swing.JButton Btmodifica;
    private javax.swing.JTable Tabla_muebles_persona;
    private javax.swing.JTextField Txtapellidos;
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
