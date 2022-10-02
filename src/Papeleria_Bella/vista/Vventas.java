package Papeleria_Bella.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
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

    public JTable getTablaventas() {
        return tablaventas;
    }

    public void setTablaventas(JTable tablaventas) {
        this.tablaventas = tablaventas;
    }

    public JButton getBtn_AgregarProducto() {
        return Btn_AgregarProducto;
    }

    public void setBtn_AgregarProducto(JButton Btn_AgregarProducto) {
        this.Btn_AgregarProducto = Btn_AgregarProducto;
    }

    public JLabel getLabelTotal() {
        return LabelTotal;
    }

    public void setLabelTotal(JLabel LabelTotal) {
        this.LabelTotal = LabelTotal;
    }

    public JSpinner getTxtCantidad() {
        return TxtCantidad;
    }

    public void setTxtCantidad(JSpinner TxtCantidad) {
        this.TxtCantidad = TxtCantidad;
    }

    public JButton getButtonbuscarnombreproducto() {
        return buttonbuscarnombreproducto;
    }

    public void setButtonbuscarnombreproducto(JButton buttonbuscarnombreproducto) {
        this.buttonbuscarnombreproducto = buttonbuscarnombreproducto;
    }

    public JButton getButtoneliminar() {
        return buttoneliminar;
    }

    public void setButtoneliminar(JButton buttoneliminar) {
        this.buttoneliminar = buttoneliminar;
    }

    public JButton getButtonguardar() {
        return buttonguardar;
    }

    public void setButtonguardar(JButton buttonguardar) {
        this.buttonguardar = buttonguardar;
    }

    public JButton getButtonimprimir() {
        return buttonimprimir;
    }

    public void setButtonimprimir(JButton buttonimprimir) {
        this.buttonimprimir = buttonimprimir;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLabeliva() {
        return labeliva;
    }

    public void setLabeliva(JLabel labeliva) {
        this.labeliva = labeliva;
    }

    public JLabel getLabelValorUnitario() {
        return LabelValorUnitario;
    }

    public void setLabelValorUnitario(JLabel LabelValorUnitario) {
        this.LabelValorUnitario = LabelValorUnitario;
    }

    public JComboBox<String> getCmbEstado() {
        return CmbEstado;
    }

    public void setCmbEstado(JComboBox<String> CmbEstado) {
        this.CmbEstado = CmbEstado;
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
        txtbuscarcedula = new javax.swing.JTextField();
        LabelSerieFactura = new javax.swing.JLabel();
        labelnombres = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventas = new javax.swing.JTable();
        buttonbuscarnombreproducto = new javax.swing.JButton();
        buttonguardar = new javax.swing.JButton();
        buttoneliminar = new javax.swing.JButton();
        buttonimprimir = new javax.swing.JButton();
        Btn_BuscarCedula = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        TxtCantidad = new javax.swing.JSpinner();
        LabelValorUnitario = new javax.swing.JLabel();
        LabelFecha = new javax.swing.JLabel();
        Btn_AgregarProducto = new javax.swing.JButton();
        LabelTotal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CmbEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Small", 3, 24)); // NOI18N
        jLabel1.setText("Ventas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 120, 40));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("Cédula:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("IVA:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("Fecha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 70, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setText("Cantidad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel6.setText("Nombre Producto:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 140, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setText("Valor Unitario:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 120, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setText("Nombre:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel10.setText("Nro. Factura:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));
        getContentPane().add(labeliva, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 110, 22));
        getContentPane().add(TxtBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 130, -1));
        getContentPane().add(txtbuscarcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 140, -1));
        getContentPane().add(LabelSerieFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 110, 30));
        getContentPane().add(labelnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 170, 22));

        tablaventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdVenta", "Codigo Producto", "Articulo", "Cantidad", "Precio", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaventas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 570, 260));

        buttonbuscarnombreproducto.setBackground(new java.awt.Color(232, 255, 255));
        buttonbuscarnombreproducto.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonbuscarnombreproducto.setForeground(new java.awt.Color(55, 107, 160));
        buttonbuscarnombreproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_1.png"))); // NOI18N
        getContentPane().add(buttonbuscarnombreproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 50, 30));

        buttonguardar.setBackground(new java.awt.Color(232, 255, 255));
        buttonguardar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonguardar.setForeground(new java.awt.Color(55, 107, 160));
        buttonguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download.png"))); // NOI18N
        buttonguardar.setText("Guardar");
        getContentPane().add(buttonguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 130, 40));

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
        getContentPane().add(Btn_BuscarCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 50, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel11.setText("Estado:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 90, 40));
        getContentPane().add(TxtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 130, -1));
        getContentPane().add(LabelValorUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 130, 30));
        getContentPane().add(LabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 140, 30));

        Btn_AgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconoAgregar.png"))); // NOI18N
        getContentPane().add(Btn_AgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 70, 40));
        getContentPane().add(LabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 150, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel12.setText("Total:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 50, 30));

        CmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(CmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 150, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_AgregarProducto;
    private javax.swing.JButton Btn_BuscarCedula;
    private javax.swing.JComboBox<String> CmbEstado;
    private javax.swing.JLabel LabelFecha;
    private javax.swing.JLabel LabelSerieFactura;
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JLabel LabelValorUnitario;
    private javax.swing.JTextField TxtBuscarProducto;
    private javax.swing.JSpinner TxtCantidad;
    private javax.swing.JButton buttonbuscarnombreproducto;
    private javax.swing.JButton buttoneliminar;
    private javax.swing.JButton buttonguardar;
    private javax.swing.JButton buttonimprimir;
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
    private javax.swing.JLabel labeliva;
    private javax.swing.JLabel labelnombres;
    private javax.swing.JTable tablaventas;
    private javax.swing.JTextField txtbuscarcedula;
    // End of variables declaration//GEN-END:variables
}
