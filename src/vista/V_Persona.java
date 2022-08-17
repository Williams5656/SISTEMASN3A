package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class V_Persona extends javax.swing.JInternalFrame {

    public V_Persona() {
        initComponents();
    }

    public JButton getBtn_CargarFoto() {
        return Btn_CargarFoto;
    }

    public void setBtn_CargarFoto(JButton Btn_CargarFoto) {
        this.Btn_CargarFoto = Btn_CargarFoto;
    }

    public JButton getBtn_QuitarFoto() {
        return Btn_QuitarFoto;
    }

    public void setBtn_QuitarFoto(JButton Btn_QuitarFoto) {
        this.Btn_QuitarFoto = Btn_QuitarFoto;
    }

    public JButton getBtneliminar() {
        return btneliminar;
    }

    public void setBtneliminar(JButton btneliminar) {
        this.btneliminar = btneliminar;
    }

    public JButton getBtnguardarp() {
        return btnguardarp;
    }

    public void setBtnguardarp(JButton btnguardarp) {
        this.btnguardarp = btnguardarp;
    }

    public JButton getBtnmodificar() {
        return btnmodificar;
    }

    public void setBtnmodificar(JButton btnmodificar) {
        this.btnmodificar = btnmodificar;
    }

    public JButton getBtnnuevo() {
        return btnnuevo;
    }

    public void setBtnnuevo(JButton btnnuevo) {
        this.btnnuevo = btnnuevo;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLabelBotones() {
        return labelBotones;
    }

    public void setLabelBotones(JLabel labelBotones) {
        this.labelBotones = labelBotones;
    }

    public JLabel getLabelFoto() {
        return labelFoto;
    }

    public void setLabelFoto(JLabel labelFoto) {
        this.labelFoto = labelFoto;
    }

    public JTable getTablapersona() {
        return tablapersona;
    }

    public void setTablapersona(JTable tablapersona) {
        this.tablapersona = tablapersona;
    }

    public JTextField getTxtapellido() {
        return txtapellido;
    }

    public void setTxtapellido(JTextField txtapellido) {
        this.txtapellido = txtapellido;
    }

    public JTextField getTxtcedula() {
        return txtcedula;
    }

    public void setTxtcedula(JTextField txtcedula) {
        this.txtcedula = txtcedula;
    }

    public JTextField getTxtcorreo() {
        return txtcorreo;
    }

    public void setTxtcorreo(JTextField txtcorreo) {
        this.txtcorreo = txtcorreo;
    }

    public JTextField getTxtnombre() {
        return txtnombre;
    }

    public void setTxtnombre(JTextField txtnombre) {
        this.txtnombre = txtnombre;
    }

    public JTextField getTxttelefono() {
        return txttelefono;
    }

    public void setTxttelefono(JTextField txttelefono) {
        this.txttelefono = txttelefono;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        btnnuevo = new javax.swing.JButton();
        btnguardarp = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablapersona = new javax.swing.JTable();
        labelFoto = new javax.swing.JLabel();
        Btn_CargarFoto = new javax.swing.JButton();
        Btn_QuitarFoto = new javax.swing.JButton();
        labelBotones = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(79, 213, 223));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("PERSONA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 180, 40));

        jLabel2.setText("CEDULA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 120, 30));

        jLabel3.setText("NOMBRES:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 120, 30));

        jLabel7.setText("TELEFONO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 110, 30));

        jLabel8.setText("APELLIDOS:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 130, 30));

        jLabel4.setText("CORREO ELECTRONICO:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 220, 30));
        jPanel1.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 220, 30));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 220, 30));
        jPanel1.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 220, 30));
        jPanel1.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 220, 30));
        jPanel1.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 220, 30));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevapersona.png"))); // NOI18N
        btnnuevo.setText("NUEVO");
        jPanel1.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 170, 40));

        btnguardarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar-archivo.png"))); // NOI18N
        btnguardarp.setText("GUARDAR");
        jPanel1.add(btnguardarp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 180, 40));

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lapiz.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        jPanel1.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 190, 40));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminarusuario.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        jPanel1.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 180, 50));

        tablapersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "CEDULA", "NOMBRES", "APELLIDOS", "TELEFONO", "CORREO", "FOTO"
            }
        ));
        jScrollPane1.setViewportView(tablapersona);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 960, 170));
        jPanel1.add(labelFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 130, 150));

        Btn_CargarFoto.setText("Cargar Foto");
        jPanel1.add(Btn_CargarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 150, 40));

        Btn_QuitarFoto.setText("Quitar Foto");
        jPanel1.add(Btn_QuitarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, 150, 40));
        jPanel1.add(labelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_CargarFoto;
    private javax.swing.JButton Btn_QuitarFoto;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardarp;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBotones;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JTable tablapersona;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
