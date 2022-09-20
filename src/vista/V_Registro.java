package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class V_Registro extends javax.swing.JInternalFrame {

    public V_Registro() {
        initComponents();
    }

    public JButton getBtnBuscarCedula() {
        return BtnBuscarCedula;
    }

    public void setBtnBuscarCedula(JButton BtnBuscarCedula) {
        this.BtnBuscarCedula = BtnBuscarCedula;
    }

    public JComboBox<String> getCmbEstadoJuicio() {
        return CmbEstadoJuicio;
    }

    public JTextField getTxtBuscarJuicio() {
        return TxtBuscarJuicio;
    }

    public void setTxtBuscarJuicio(JTextField TxtBuscarJuicio) {
        this.TxtBuscarJuicio = TxtBuscarJuicio;
    }

    public void setCmbEstadoJuicio(JComboBox<String> CmbEstadoJuicio) {
        this.CmbEstadoJuicio = CmbEstadoJuicio;
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

    public JComboBox<String> getCbtipojuicio() {
        return cbtipojuicio;
    }

    public void setCbtipojuicio(JComboBox<String> cbtipojuicio) {
        this.cbtipojuicio = cbtipojuicio;
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

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLabelcliente() {
        return labelcliente;
    }

    public void setLabelcliente(JLabel labelcliente) {
        this.labelcliente = labelcliente;
    }

    public JLabel getNumjuicio() {
        return numjuicio;
    }

    public void setNumjuicio(JLabel numjuicio) {
        this.numjuicio = numjuicio;
    }

    public JTable getTablajuicio() {
        return tablajuicio;
    }

    public void setTablajuicio(JTable tablajuicio) {
        this.tablajuicio = tablajuicio;
    }

    public JTextField getTxtcliente() {
        return txtcliente;
    }

    public void setTxtcliente(JTextField txtcliente) {
        this.txtcliente = txtcliente;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnguardarp = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        numjuicio = new javax.swing.JLabel();
        cbtipojuicio = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablajuicio = new javax.swing.JTable();
        BtnBuscarCedula = new javax.swing.JButton();
        labelcliente = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CmbEstadoJuicio = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        TxtBuscarJuicio = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("JUICIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 180, 40));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevapersona.png"))); // NOI18N
        btnnuevo.setText("NUEVO");
        getContentPane().add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 170, 40));

        btnguardarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar-archivo.png"))); // NOI18N
        btnguardarp.setText("GUARDAR");
        getContentPane().add(btnguardarp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 180, 40));

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lapiz.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        getContentPane().add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 140, 40));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminarusuario.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 120, 40));

        jLabel2.setText("CLIENTE:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 90, 30));
        getContentPane().add(txtcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 180, 30));

        jLabel3.setText("NRO DE JUICIO:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 120, 30));

        jLabel4.setText("TIPO DE JUICIO:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 120, 30));
        getContentPane().add(numjuicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 110, 30));

        cbtipojuicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Civil", "Penal", "Contensioso-Administrativo", "Laboral", "Niñez y Adolescencia", "Fragrancia", "Intrafamiliar" }));
        getContentPane().add(cbtipojuicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 200, 30));

        tablajuicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NRO DE JUICIO", "CLIENTE", "TIPO DE JUICIO", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablajuicio);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, 110));

        BtnBuscarCedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        getContentPane().add(BtnBuscarCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 60, 30));
        getContentPane().add(labelcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 190, 30));

        jLabel5.setText("NOMBRES:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, -1, 30));

        jLabel6.setText("ESTADO:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 60, 30));

        CmbEstadoJuicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En Curso", "Finalizado" }));
        getContentPane().add(CmbEstadoJuicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 150, 30));

        jLabel7.setText("BUSCAR:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 60, 30));

        TxtBuscarJuicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtBuscarJuicioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtBuscarJuicioFocusLost(evt);
            }
        });
        TxtBuscarJuicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarJuicioKeyReleased(evt);
            }
        });
        getContentPane().add(TxtBuscarJuicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 150, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtBuscarJuicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarJuicioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBuscarJuicioKeyReleased

    private void TxtBuscarJuicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtBuscarJuicioFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBuscarJuicioFocusGained

    private void TxtBuscarJuicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtBuscarJuicioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBuscarJuicioFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscarCedula;
    private javax.swing.JComboBox<String> CmbEstadoJuicio;
    private javax.swing.JTextField TxtBuscarJuicio;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardarp;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cbtipojuicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelcliente;
    private javax.swing.JLabel numjuicio;
    private javax.swing.JTable tablajuicio;
    private javax.swing.JTextField txtcliente;
    // End of variables declaration//GEN-END:variables
}
