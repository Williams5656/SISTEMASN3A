package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class V_GesClient extends javax.swing.JInternalFrame {

    public V_GesClient() {
        initComponents();
    }

    public JTable getTableCliente() {
        return TableCliente;
    }

    public void setTableCliente(JTable TableCliente) {
        this.TableCliente = TableCliente;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLabelCodigo() {
        return LabelCodigo;
    }

    public JComboBox<String> getCmbTrabajo() {
        return CmbTrabajo;
    }

    public void setCmbTrabajo(JComboBox<String> CmbTrabajo) {
        this.CmbTrabajo = CmbTrabajo;
    }

    public JTextField getTxtProfesion() {
        return TxtProfesion;
    }

    public void setTxtProfesion(JTextField TxtProfesion) {
        this.TxtProfesion = TxtProfesion;
    }

    public void setLabelCodigo(JLabel LabelCodigo) {
        this.LabelCodigo = LabelCodigo;
    }

    public JButton getBtnBuscarCedula() {
        return BtnBuscarCedula;
    }

    public void setBtnBuscarCedula(JButton BtnBuscarCedula) {
        this.BtnBuscarCedula = BtnBuscarCedula;
    }

    public JLabel getLabelCedula() {
        return LabelCedula;
    }

    public void setLabelCedula(JLabel LabelCedula) {
        this.LabelCedula = LabelCedula;
    }

    public JLabel getLabelNombres() {
        return LabelNombres;
    }

    public void setLabelNombres(JLabel LabelNombres) {
        this.LabelNombres = LabelNombres;
    }

    public JLabel getLabelTINombres() {
        return LabelTINombres;
    }

    public void setLabelTINombres(JLabel LabelTINombres) {
        this.LabelTINombres = LabelTINombres;
    }

    public JLabel getLabelTelefono() {
        return LabelTelefono;
    }

    public void setLabelTelefono(JLabel LabelTelefono) {
        this.LabelTelefono = LabelTelefono;
    }

    public JLabel getLabelTiTelefono() {
        return LabelTiTelefono;
    }

    public void setLabelTiTelefono(JLabel LabelTiTelefono) {
        this.LabelTiTelefono = LabelTiTelefono;
    }

    public JTextField getTxtBuscarCedula() {
        return TxtBuscarCedula;
    }

    public void setTxtBuscarCedula(JTextField TxtBuscarCedula) {
        this.TxtBuscarCedula = TxtBuscarCedula;
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

    public JComboBox<String> getCmbEstadoCliente() {
        return cmbEstadoCliente;
    }

    public void setCmbEstadoCliente(JComboBox<String> cmbEstadoCliente) {
        this.cmbEstadoCliente = cmbEstadoCliente;
    }

    public JTextField getTxtBuscarCliente() {
        return TxtBuscarCliente;
    }

    public void setTxtBuscarCliente(JTextField TxtBuscarCliente) {
        this.TxtBuscarCliente = TxtBuscarCliente;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnguardarp = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        LabelCedula = new javax.swing.JLabel();
        TxtBuscarCedula = new javax.swing.JTextField();
        BtnBuscarCedula = new javax.swing.JButton();
        LabelTINombres = new javax.swing.JLabel();
        LabelNombres = new javax.swing.JLabel();
        LabelTiTelefono = new javax.swing.JLabel();
        LabelTelefono = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LabelCodigo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCliente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmbEstadoCliente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        TxtBuscarCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtProfesion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CmbTrabajo = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("CLIENTES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 140, -1));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevapersona.png"))); // NOI18N
        btnnuevo.setText("NUEVO");
        jPanel1.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 140, 40));

        btnguardarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar-archivo.png"))); // NOI18N
        btnguardarp.setText("GUARDAR");
        jPanel1.add(btnguardarp, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 140, 40));

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lapiz.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        jPanel1.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 140, 40));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminarusuario.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        jPanel1.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 130, 40));

        LabelCedula.setText("CEDULA:");
        jPanel1.add(LabelCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 70, 30));
        jPanel1.add(TxtBuscarCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 160, 30));

        BtnBuscarCedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        jPanel1.add(BtnBuscarCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 50, 50));

        LabelTINombres.setText("NOMBRES:");
        jPanel1.add(LabelTINombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 70, 30));
        jPanel1.add(LabelNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 230, 30));

        LabelTiTelefono.setText("TELEFONO:");
        jPanel1.add(LabelTiTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 70, 30));
        jPanel1.add(LabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 160, 30));

        jLabel7.setText("CODIGO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 60, 30));
        jPanel1.add(LabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 160, 30));

        TableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CODIGO", "CEDULA", "ESTADO"
            }
        ));
        jScrollPane1.setViewportView(TableCliente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 640, 100));

        jLabel2.setText("ESTADO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 70, 30));

        cmbEstadoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel1.add(cmbEstadoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 150, 30));

        jLabel3.setText("BUSCAR:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 70, 30));
        jPanel1.add(TxtBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 150, 30));

        jLabel4.setText("PROFESION:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 80, 30));
        jPanel1.add(TxtProfesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 150, 30));

        jLabel5.setText("TRABAJO:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 60, 30));

        CmbTrabajo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiempo Completo", "Medio Tiempo", "2 Hora al dia" }));
        jPanel1.add(CmbTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 160, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscarCedula;
    private javax.swing.JComboBox<String> CmbTrabajo;
    private javax.swing.JLabel LabelCedula;
    private javax.swing.JLabel LabelCodigo;
    private javax.swing.JLabel LabelNombres;
    private javax.swing.JLabel LabelTINombres;
    private javax.swing.JLabel LabelTelefono;
    private javax.swing.JLabel LabelTiTelefono;
    private javax.swing.JTable TableCliente;
    private javax.swing.JTextField TxtBuscarCedula;
    private javax.swing.JTextField TxtBuscarCliente;
    private javax.swing.JTextField TxtProfesion;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardarp;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cmbEstadoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
