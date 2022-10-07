package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class V_Servicios extends javax.swing.JInternalFrame {

    public V_Servicios() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnguardarp = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        txtBuscarcliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        LabelCodServicio = new javax.swing.JLabel();
        cbtipojuicio = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableServicio = new javax.swing.JTable();
        BtnBuscarCedula = new javax.swing.JButton();
        labelnombrescliente = new javax.swing.JLabel();
        CmbEstadoJuicio = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        TxtBuscarJuicio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbConsultorio = new javax.swing.JComboBox<>();
        Btn_Imprimir = new javax.swing.JButton();
        TxtFecha = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(211, 236, 233));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Servicios.png"))); // NOI18N
        jLabel1.setText("SERVICIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 250, -1));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevapersona.png"))); // NOI18N
        btnnuevo.setText("NUEVO");
        getContentPane().add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 140, 30));

        btnguardarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar-archivo.png"))); // NOI18N
        btnguardarp.setText("GUARDAR");
        getContentPane().add(btnguardarp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 150, 30));

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lapiz.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        getContentPane().add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 160, 30));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminarusuario.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 150, 30));
        getContentPane().add(txtBuscarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 180, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 17)); // NOI18N
        jLabel3.setText("CLIENTE:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 90, 30));
        getContentPane().add(LabelCodServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 140, 30));

        getContentPane().add(cbtipojuicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 180, 30));

        TableServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "CLIENTE", "TIPO", "FECHA", "CONSULTORIO", "ESTADO"
            }
        ));
        jScrollPane1.setViewportView(TableServicio);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 670, 120));

        BtnBuscarCedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        getContentPane().add(BtnBuscarCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 60, 30));
        getContentPane().add(labelnombrescliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 190, 30));

        CmbEstadoJuicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En Curso", "Finalizado" }));
        getContentPane().add(CmbEstadoJuicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 150, 30));

        jLabel7.setText("BUSCAR:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 100, 30));
        getContentPane().add(TxtBuscarJuicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 200, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 17)); // NOI18N
        jLabel8.setText("FECHA:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 80, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 17)); // NOI18N
        jLabel9.setText("CODIGO:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 90, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 17)); // NOI18N
        jLabel11.setText("NOMBRES:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 90, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 17)); // NOI18N
        jLabel12.setText("TIPO:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 70, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 17)); // NOI18N
        jLabel13.setText("CONSULTORIO:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 130, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 17)); // NOI18N
        jLabel14.setText("ESTADO:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 90, 30));

        getContentPane().add(cmbConsultorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 190, -1));

        Btn_Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        Btn_Imprimir.setText("Imprimir");
        getContentPane().add(Btn_Imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 150, 40));
        getContentPane().add(TxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 190, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscarCedula;
    private javax.swing.JButton Btn_Imprimir;
    private javax.swing.JComboBox<String> CmbEstadoJuicio;
    private javax.swing.JLabel LabelCodServicio;
    private javax.swing.JTable TableServicio;
    private javax.swing.JTextField TxtBuscarJuicio;
    private com.toedter.calendar.JDateChooser TxtFecha;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardarp;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cbtipojuicio;
    private javax.swing.JComboBox<String> cmbConsultorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelnombrescliente;
    private javax.swing.JTextField txtBuscarcliente;
    // End of variables declaration//GEN-END:variables
}
