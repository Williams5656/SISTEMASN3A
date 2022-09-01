
package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class V_Consorcio extends javax.swing.JInternalFrame {

    public V_Consorcio() {
        initComponents();
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

    public JComboBox<String> getCbtipo() {
        return cbtipo;
    }

    public void setCbtipo(JComboBox<String> cbtipo) {
        this.cbtipo = cbtipo;
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

    

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getTablaconsorcio() {
        return tablaconsorcio;
    }

    public void setTablaconsorcio(JTable tablaconsorcio) {
        this.tablaconsorcio = tablaconsorcio;
    }

    public JTextField getTxtcodconsorcio() {
        return txtcodconsorcio;
    }

    public void setTxtcodconsorcio(JTextField txtcodconsorcio) {
        this.txtcodconsorcio = txtcodconsorcio;
    }

    public JTextField getTxtnomconsorcio() {
        return txtnomconsorcio;
    }

    public void setTxtnomconsorcio(JTextField txtnomconsorcio) {
        this.txtnomconsorcio = txtnomconsorcio;
    }

    public JTextField getTxtriesgo() {
        return txtriesgo;
    }

    public void setTxtriesgo(JTextField txtriesgo) {
        this.txtriesgo = txtriesgo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcodconsorcio = new javax.swing.JTextField();
        txtnomconsorcio = new javax.swing.JTextField();
        txtriesgo = new javax.swing.JTextField();
        cbtipo = new javax.swing.JComboBox<>();
        btnnuevo = new javax.swing.JButton();
        btnguardarp = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaconsorcio = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("CODIGO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 120, 30));

        jLabel3.setText("NOMBRE:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 110, 30));

        jLabel4.setText("TIPO:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 100, 30));

        jLabel5.setText("RIESGO:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 100, 30));
        getContentPane().add(txtcodconsorcio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 220, 30));
        getContentPane().add(txtnomconsorcio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 220, 30));
        getContentPane().add(txtriesgo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 220, 30));

        getContentPane().add(cbtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 220, 30));

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
        jLabel1.setText("CONSORCIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 180, 40));

        tablaconsorcio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "TIPO", "RIESGO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaconsorcio);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 540, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardarp;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cbtipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaconsorcio;
    private javax.swing.JTextField txtcodconsorcio;
    private javax.swing.JTextField txtnomconsorcio;
    private javax.swing.JTextField txtriesgo;
    // End of variables declaration//GEN-END:variables
}
