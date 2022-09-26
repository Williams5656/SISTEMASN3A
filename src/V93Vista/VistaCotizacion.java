package V93Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VistaCotizacion extends javax.swing.JFrame {

    public VistaCotizacion() {
        initComponents();
    }

    public JLabel getLabelTotalaPagar() {
        return LabelTotalaPagar;
    }

    public void setLabelTotalaPagar(JLabel LabelTotalaPagar) {
        this.LabelTotalaPagar = LabelTotalaPagar;
    }

    public JLabel getLabelVendedorFactura() {
        return LabelVendedorFactura;
    }

    public void setLabelVendedorFactura(JLabel LabelVendedorFactura) {
        this.LabelVendedorFactura = LabelVendedorFactura;
    }

    public JTable getTableFactura() {
        return TableFactura;
    }

    public void setTableFactura(JTable TableFactura) {
        this.TableFactura = TableFactura;
    }

    public JButton getBtnEliminarFactura() {
        return btnEliminarFactura;
    }

    public void setBtnEliminarFactura(JButton btnEliminarFactura) {
        this.btnEliminarFactura = btnEliminarFactura;
    }

    public JButton getBtnGenerarFactura() {
        return btnGenerarFactura;
    }

    public void setBtnGenerarFactura(JButton btnGenerarFactura) {
        this.btnGenerarFactura = btnGenerarFactura;
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

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTextField getTxtCantidadFactura() {
        return txtCantidadFactura;
    }

    public void setTxtCantidadFactura(JTextField txtCantidadFactura) {
        this.txtCantidadFactura = txtCantidadFactura;
    }

    public JTextField getTxtCedulaClienteFactura() {
        return txtCedulaClienteFactura;
    }

    public void setTxtCedulaClienteFactura(JTextField txtCedulaClienteFactura) {
        this.txtCedulaClienteFactura = txtCedulaClienteFactura;
    }

    public JTextField getTxtCodigoProFactura() {
        return txtCodigoProFactura;
    }

    public void setTxtCodigoProFactura(JTextField txtCodigoProFactura) {
        this.txtCodigoProFactura = txtCodigoProFactura;
    }

    public JTextField getTxtDescripcionProFactura() {
        return txtDescripcionProFactura;
    }

    public void setTxtDescripcionProFactura(JTextField txtDescripcionProFactura) {
        this.txtDescripcionProFactura = txtDescripcionProFactura;
    }

    public JTextField getTxtNombreClienteFactura() {
        return txtNombreClienteFactura;
    }

    public void setTxtNombreClienteFactura(JTextField txtNombreClienteFactura) {
        this.txtNombreClienteFactura = txtNombreClienteFactura;
    }

    public JTextField getTxtPrecioFactura() {
        return txtPrecioFactura;
    }

    public void setTxtPrecioFactura(JTextField txtPrecioFactura) {
        this.txtPrecioFactura = txtPrecioFactura;
    }

    public JTextField getTxtStockFactura() {
        return txtStockFactura;
    }

    public void setTxtStockFactura(JTextField txtStockFactura) {
        this.txtStockFactura = txtStockFactura;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnEliminarFactura = new javax.swing.JButton();
        txtCodigoProFactura = new javax.swing.JTextField();
        txtDescripcionProFactura = new javax.swing.JTextField();
        txtCantidadFactura = new javax.swing.JTextField();
        txtPrecioFactura = new javax.swing.JTextField();
        txtStockFactura = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableFactura = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnGenerarFactura = new javax.swing.JButton();
        txtCedulaClienteFactura = new javax.swing.JTextField();
        txtNombreClienteFactura = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        LabelTotalaPagar = new javax.swing.JLabel();
        LabelVendedorFactura = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("CODIGO:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 84, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("DESCRIPCION:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 84, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("CANTIDAD:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 84, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("PRECIO:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 84, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("STOCK DISPONIBLE:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 84, -1, -1));

        btnEliminarFactura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/eliminar.png"))); // NOI18N
        btnEliminarFactura.setText("ELIMINAR");
        jPanel1.add(btnEliminarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 77, -1, -1));
        jPanel1.add(txtCodigoProFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 112, 90, -1));
        jPanel1.add(txtDescripcionProFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 112, 136, -1));
        jPanel1.add(txtCantidadFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 112, 88, -1));

        txtPrecioFactura.setEditable(false);
        jPanel1.add(txtPrecioFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 112, 85, -1));
        jPanel1.add(txtStockFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 112, 122, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Nventa.png"))); // NOI18N
        jLabel6.setText("COTIZACION");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 11, 190, -1));

        TableFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(TableFactura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 138, 826, 206));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("CEDULA:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 379, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("NOMBRE:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 379, -1, -1));

        btnGenerarFactura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGenerarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/print.png"))); // NOI18N
        btnGenerarFactura.setText("Cotizar");
        jPanel1.add(btnGenerarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 362, -1, -1));
        jPanel1.add(txtCedulaClienteFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 417, 131, -1));
        jPanel1.add(txtNombreClienteFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 417, 161, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/money.png"))); // NOI18N
        jLabel9.setText("TOTAL A PAGAR");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 387, -1, -1));

        LabelTotalaPagar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelTotalaPagar.setText("---------------------");
        jPanel1.add(LabelTotalaPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 440, 180, -1));

        LabelVendedorFactura.setText("Eduardo Astudillo");
        jPanel1.add(LabelVendedorFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 140, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTotalaPagar;
    private javax.swing.JLabel LabelVendedorFactura;
    private javax.swing.JTable TableFactura;
    private javax.swing.JButton btnEliminarFactura;
    private javax.swing.JButton btnGenerarFactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCantidadFactura;
    private javax.swing.JTextField txtCedulaClienteFactura;
    private javax.swing.JTextField txtCodigoProFactura;
    private javax.swing.JTextField txtDescripcionProFactura;
    private javax.swing.JTextField txtNombreClienteFactura;
    private javax.swing.JTextField txtPrecioFactura;
    private javax.swing.JTextField txtStockFactura;
    // End of variables declaration//GEN-END:variables
}
