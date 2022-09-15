package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class V_Consultorio extends javax.swing.JInternalFrame {

    public V_Consultorio() {
        initComponents();
    }

    public JTextArea getTxtLema() {
        return TxtLema;
    }

    public void setTxtLema(JTextArea TxtLema) {
        this.TxtLema = TxtLema;
    }

    public JTextField getTxttelefonoConsultorio() {
        return TxttelefonoConsultorio;
    }

    public void setTxttelefonoConsultorio(JTextField TxttelefonoConsultorio) {
        this.TxttelefonoConsultorio = TxttelefonoConsultorio;
    }

    public JButton getBtn_CargarFondo() {
        return Btn_CargarFondo;
    }

    public void setBtn_CargarFondo(JButton Btn_CargarFondo) {
        this.Btn_CargarFondo = Btn_CargarFondo;
    }

    public JButton getBtn_QuitarFondo() {
        return Btn_QuitarFondo;
    }

    public void setBtn_QuitarFondo(JButton Btn_QuitarFondo) {
        this.Btn_QuitarFondo = Btn_QuitarFondo;
    }

    public JLabel getCodigoConsultorio() {
        return CodigoConsultorio;
    }

    public void setCodigoConsultorio(JLabel CodigoConsultorio) {
        this.CodigoConsultorio = CodigoConsultorio;
    }

    public JTable getTableConsultorio() {
        return TableConsultorio;
    }

    public void setTableConsultorio(JTable TableConsultorio) {
        this.TableConsultorio = TableConsultorio;
    }

    public JTextField getTxtDireccionConsultorio() {
        return TxtDireccionConsultorio;
    }

    public void setTxtDireccionConsultorio(JTextField TxtDireccionConsultorio) {
        this.TxtDireccionConsultorio = TxtDireccionConsultorio;
    }

    public JTextField getTxtNombreConsultorio() {
        return TxtNombreConsultorio;
    }

    public void setTxtNombreConsultorio(JTextField TxtNombreConsultorio) {
        this.TxtNombreConsultorio = TxtNombreConsultorio;
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

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtNombreConsultorio = new javax.swing.JTextField();
        TxtDireccionConsultorio = new javax.swing.JTextField();
        btnnuevo = new javax.swing.JButton();
        btnguardarp = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableConsultorio = new javax.swing.JTable();
        CodigoConsultorio = new javax.swing.JLabel();
        TxttelefonoConsultorio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        labelFondo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtLema = new javax.swing.JTextArea();
        Btn_CargarFondo = new javax.swing.JButton();
        Btn_QuitarFondo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("CODIGO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, 30));

        jLabel3.setText("NOMBRE:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 80, 30));

        jLabel4.setText("DIRECCION:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 100, 30));

        jLabel5.setText("TELEFONO:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 80, 30));
        getContentPane().add(TxtNombreConsultorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 160, 30));
        getContentPane().add(TxtDireccionConsultorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 160, 30));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevapersona.png"))); // NOI18N
        btnnuevo.setText("NUEVO");
        getContentPane().add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 170, 40));

        btnguardarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar-archivo.png"))); // NOI18N
        btnguardarp.setText("GUARDAR");
        getContentPane().add(btnguardarp, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 180, 40));

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lapiz.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        getContentPane().add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 190, 40));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminarusuario.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 180, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("CONSULTORIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 210, 40));

        TableConsultorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "DIRECCION", "TELEFONO", "FONDO", "LEMA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableConsultorio);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 630, 110));
        getContentPane().add(CodigoConsultorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 160, 30));
        getContentPane().add(TxttelefonoConsultorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 160, 30));

        jLabel7.setText("FONDO DE ESCRITORIO:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 150, 30));
        getContentPane().add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 220, 100));

        jLabel6.setText("LEMA:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 70, 30));

        TxtLema.setColumns(20);
        TxtLema.setRows(5);
        jScrollPane2.setViewportView(TxtLema);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 240, 100));

        Btn_CargarFondo.setText("Cargar Fondo");
        getContentPane().add(Btn_CargarFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 160, 110, 30));

        Btn_QuitarFondo.setText("Quitar Fondo");
        getContentPane().add(Btn_QuitarFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 110, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_CargarFondo;
    private javax.swing.JButton Btn_QuitarFondo;
    private javax.swing.JLabel CodigoConsultorio;
    private javax.swing.JTable TableConsultorio;
    private javax.swing.JTextField TxtDireccionConsultorio;
    private javax.swing.JTextArea TxtLema;
    private javax.swing.JTextField TxtNombreConsultorio;
    private javax.swing.JTextField TxttelefonoConsultorio;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardarp;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelFondo;
    // End of variables declaration//GEN-END:variables
}
