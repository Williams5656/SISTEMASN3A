package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class V_RegistroJuicio extends javax.swing.JInternalFrame {

    public V_RegistroJuicio() {
        initComponents();
    }

    public JTextField getTxtBuscarJuicio() {
        return TxtBuscarJuicio;
    }

    public void setTxtBuscarJuicio(JTextField TxtBuscarJuicio) {
        this.TxtBuscarJuicio = TxtBuscarJuicio;
    }

    public JButton getBtnImprimir() {
        return BtnImprimir;
    }

    public void setBtnImprimir(JButton BtnImprimir) {
        this.BtnImprimir = BtnImprimir;
    }

    public JLabel getCodigoJuicio() {
        return CodigoJuicio;
    }

    public void setCodigoJuicio(JLabel CodigoJuicio) {
        this.CodigoJuicio = CodigoJuicio;
    }

    public JTable getTableJuicio() {
        return TableJuicio;
    }

    public void setTableJuicio(JTable TableJuicio) {
        this.TableJuicio = TableJuicio;
    }

    public JTextArea getTxtDescripcion() {
        return TxtDescripcion;
    }

    public void setTxtDescripcion(JTextArea TxtDescripcion) {
        this.TxtDescripcion = TxtDescripcion;
    }

    public JTextField getTxtNombre() {
        return TxtNombre;
    }

    public void setTxtNombre(JTextField TxtNombre) {
        this.TxtNombre = TxtNombre;
    }

    public JTextField getTxtPrecio() {
        return TxtPrecio;
    }

    public void setTxtPrecio(JTextField TxtPrecio) {
        this.TxtPrecio = TxtPrecio;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnguardarp = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        CodigoJuicio = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableJuicio = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        BtnImprimir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtDescripcion = new javax.swing.JTextArea();
        TxtBuscarJuicio = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(211, 236, 233));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/juicio.png"))); // NOI18N
        jLabel1.setText("JUICIOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 200, 70));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevapersona.png"))); // NOI18N
        btnnuevo.setText("NUEVO");
        jPanel1.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 160, 40));

        btnguardarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar-archivo.png"))); // NOI18N
        btnguardarp.setText("GUARDAR");
        jPanel1.add(btnguardarp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 160, 40));

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lapiz.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        jPanel1.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 170, 40));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminarusuario.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        jPanel1.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 150, 40));

        CodigoJuicio.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jPanel1.add(CodigoJuicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 170, 30));
        jPanel1.add(TxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 180, 30));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel5.setText("BUSCAR:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 100, 40));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel6.setText("NOMBRE:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 110, 30));
        jPanel1.add(TxtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 150, 30));

        TableJuicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "DESCRIPCION", "PRECIO"
            }
        ));
        jScrollPane1.setViewportView(TableJuicio);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 690, 110));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel7.setText("PRECIO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 100, 30));

        BtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        BtnImprimir.setText("Imprimir");
        jPanel1.add(BtnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 140, 40));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel3.setText("DESCRIPCION:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 140, 30));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel4.setText("CODIGO:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 100, 30));

        TxtDescripcion.setColumns(20);
        TxtDescripcion.setRows(5);
        jScrollPane2.setViewportView(TxtDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 320, 140));

        TxtBuscarJuicio.setFont(new java.awt.Font("Tahoma", 2, 15)); // NOI18N
        TxtBuscarJuicio.setForeground(new java.awt.Color(153, 153, 153));
        TxtBuscarJuicio.setText("Ingrese el número de Cédula");
        jPanel1.add(TxtBuscarJuicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 210, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnImprimir;
    private javax.swing.JLabel CodigoJuicio;
    private javax.swing.JTable TableJuicio;
    private javax.swing.JTextField TxtBuscarJuicio;
    private javax.swing.JTextArea TxtDescripcion;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardarp;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
