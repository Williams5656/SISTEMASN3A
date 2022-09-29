package Papeleria_Bella.vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Vventas extends javax.swing.JFrame {

    public Vventas() {
        initComponents();
    }

    public JLabel getLabelFecha() {
        return LabelFecha;
    }

    public void setLabelFecha(JLabel LabelFecha) {
        this.LabelFecha = LabelFecha;
    }

    public JLabel getLabelSerieFactura() {
        return LabelSerieFactura;
    }

    public void setLabelSerieFactura(JLabel LabelSerieFactura) {
        this.LabelSerieFactura = LabelSerieFactura;
    }

    public JTextField getTxtBuscarProducto() {
        return TxtBuscarProducto;
    }

    public void setTxtBuscarProducto(JTextField TxtBuscarProducto) {
        this.TxtBuscarProducto = TxtBuscarProducto;
    }

    public JTextField getTxtbuscarcedula() {
        return txtbuscarcedula;
    }

    public JButton getBtn_BuscarCedula() {
        return Btn_BuscarCedula;
    }

    public void setBtn_BuscarCedula(JButton Btn_BuscarCedula) {
        this.Btn_BuscarCedula = Btn_BuscarCedula;
    }

    public JLabel getLabelnombres() {
        return labelnombres;
    }

    public void setLabelnombres(JLabel labelnombres) {
        this.labelnombres = labelnombres;
    }

    public void setTxtbuscarcedula(JTextField txtbuscarcedula) {
        this.txtbuscarcedula = txtbuscarcedula;
    }

    public JButton getButtonbuscarcedula() {
        return Btn_BuscarCedula;
    }

    public void setButtonbuscarcedula(JButton buttonbuscarcedula) {
        this.Btn_BuscarCedula = buttonbuscarcedula;
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labeliva = new javax.swing.JLabel();
        TxtBuscarProducto = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        txtbuscarcedula = new javax.swing.JTextField();
        LabelSerieFactura = new javax.swing.JLabel();
        labelnombres = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventas = new javax.swing.JTable();
        buttonbuscarnombreproducto = new javax.swing.JButton();
        buttonnuevo = new javax.swing.JButton();
        buttonguardar = new javax.swing.JButton();
        buttonmodificar = new javax.swing.JButton();
        buttoneliminar = new javax.swing.JButton();
        buttonimprimir = new javax.swing.JButton();
        Btn_BuscarCedula = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        LabelFecha = new javax.swing.JLabel();
        Btn_AgregarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Small", 3, 24)); // NOI18N
        jLabel1.setText("Ventas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 90, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("Cédula:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("IVA:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("Fecha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setText("Cantidad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel6.setText("Nombre Producto:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 140, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setText("Valor Unitario:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setText("Nombre:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel10.setText("Nro. Factura:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));
        getContentPane().add(labeliva, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 110, 22));
        getContentPane().add(TxtBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 110, -1));
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 110, -1));
        getContentPane().add(txtbuscarcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 130, -1));
        getContentPane().add(LabelSerieFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 110, 30));
        getContentPane().add(labelnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 150, 22));

        tablaventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "numero", "codigo", "articulo", "cantidad", "precio unitario", "total"
            }
        ));
        jScrollPane1.setViewportView(tablaventas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 570, 260));

        buttonbuscarnombreproducto.setBackground(new java.awt.Color(232, 255, 255));
        buttonbuscarnombreproducto.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonbuscarnombreproducto.setForeground(new java.awt.Color(55, 107, 160));
        buttonbuscarnombreproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_1.png"))); // NOI18N
        getContentPane().add(buttonbuscarnombreproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 50, 30));

        buttonnuevo.setBackground(new java.awt.Color(232, 255, 255));
        buttonnuevo.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonnuevo.setForeground(new java.awt.Color(55, 107, 160));
        buttonnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add(3).png"))); // NOI18N
        buttonnuevo.setText("Nuevo");
        getContentPane().add(buttonnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 130, 40));

        buttonguardar.setBackground(new java.awt.Color(232, 255, 255));
        buttonguardar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonguardar.setForeground(new java.awt.Color(55, 107, 160));
        buttonguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download.png"))); // NOI18N
        buttonguardar.setText("Guardar");
        getContentPane().add(buttonguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 130, 40));

        buttonmodificar.setBackground(new java.awt.Color(232, 255, 255));
        buttonmodificar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonmodificar.setForeground(new java.awt.Color(55, 107, 160));
        buttonmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        buttonmodificar.setText("Modificar");
        getContentPane().add(buttonmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, 130, 40));

        buttoneliminar.setBackground(new java.awt.Color(232, 255, 255));
        buttoneliminar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttoneliminar.setForeground(new java.awt.Color(55, 107, 160));
        buttoneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/garbage-bin(1).png"))); // NOI18N
        buttoneliminar.setText("Eliminar");
        getContentPane().add(buttoneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, 130, 40));

        buttonimprimir.setBackground(new java.awt.Color(232, 255, 255));
        buttonimprimir.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/printer (5)_1.png"))); // NOI18N
        getContentPane().add(buttonimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 420, 50, 40));

        Btn_BuscarCedula.setBackground(new java.awt.Color(232, 255, 255));
        Btn_BuscarCedula.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Btn_BuscarCedula.setForeground(new java.awt.Color(55, 107, 160));
        Btn_BuscarCedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_1.png"))); // NOI18N
        getContentPane().add(Btn_BuscarCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 50, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel11.setText("Total:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 130, -1));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 130, 30));
        getContentPane().add(LabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 140, 30));

        Btn_AgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconoAgregar.png"))); // NOI18N
        getContentPane().add(Btn_AgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 70, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_AgregarProducto;
    private javax.swing.JButton Btn_BuscarCedula;
    private javax.swing.JLabel LabelFecha;
    private javax.swing.JLabel LabelSerieFactura;
    private javax.swing.JTextField TxtBuscarProducto;
    private javax.swing.JButton buttonbuscarnombreproducto;
    private javax.swing.JButton buttoneliminar;
    private javax.swing.JButton buttonguardar;
    private javax.swing.JButton buttonimprimir;
    private javax.swing.JButton buttonmodificar;
    private javax.swing.JButton buttonnuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel labeliva;
    private javax.swing.JLabel labelnombres;
    private javax.swing.JTable tablaventas;
    private javax.swing.JTextField txtbuscarcedula;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
