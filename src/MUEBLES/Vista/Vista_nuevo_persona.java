package MUEBLES.Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Vista_nuevo_persona extends javax.swing.JFrame {

    public Vista_nuevo_persona() {
        initComponents();
    }

    public JButton getBtnguardar_persona() {
        return Btnguardar_persona;
    }

    public void setBtnguardar_persona(JButton Btnguardar_persona) {
        this.Btnguardar_persona = Btnguardar_persona;
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

    public JButton getBtncargar() {
        return Btncargar;
    }

    public void setBtncargar(JButton Btncargar) {
        this.Btncargar = Btncargar;
    }


    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JButton getBtnregresar() {
        return Btnregresar;
    }

    public void setBtnregresar(JButton Btnregresar) {
        this.Btnregresar = Btnregresar;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel5 = new javax.swing.JLabel();
        Txtnacionalidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Txtfecha = new javax.swing.JTextField();
        Btnguardar_persona = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Btncargar = new javax.swing.JButton();
        Btnregresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Cedula:");

        jLabel2.setText("Nombres:");

        jLabel3.setText("Apellidos:");

        jLabel7.setText("Direccion:");

        jLabel6.setText("Celular:");

        jLabel5.setText("Nacionalidad:");

        jLabel4.setText("Fecha de nacimineto:");

        Btnguardar_persona.setText("GUARDAR");

        jLabel8.setText("FOTO");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        Btncargar.setText("CARGAR");

        Btnregresar.setText("REGRESAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(Txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(Txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(Txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(Txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(Txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel5))
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Txtnacionalidad)
                                    .addComponent(Txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btnguardar_persona)
                            .addComponent(Btncargar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btnregresar))
                        .addGap(84, 84, 84))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1))
                            .addComponent(Txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2))
                            .addComponent(Txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(Txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7))
                            .addComponent(Txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(Txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btncargar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(Txtnacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btnguardar_persona))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Btnregresar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btncargar;
    private javax.swing.JButton Btnguardar_persona;
    private javax.swing.JButton Btnregresar;
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
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
