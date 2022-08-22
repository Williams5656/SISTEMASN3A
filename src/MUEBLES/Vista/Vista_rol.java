package MUEBLES.Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Vista_rol extends javax.swing.JFrame {

    public Vista_rol() {
        initComponents();
    }

    public JButton getBtnbuscar() {
        return Btnbuscar;
    }

    public void setBtnbuscar(JButton Btnbuscar) {
        this.Btnbuscar = Btnbuscar;
    }

    public JButton getBtneliminar() {
        return Btneliminar;
    }

    public void setBtneliminar(JButton Btneliminar) {
        this.Btneliminar = Btneliminar;
    }

    public JButton getBtnguardar() {
        return Btnguardar;
    }

    public void setBtnguardar(JButton Btnguardar) {
        this.Btnguardar = Btnguardar;
    }

    public JButton getBtnmodificar() {
        return Btnmodificar;
    }

    public void setBtnmodificar(JButton Btnmodificar) {
        this.Btnmodificar = Btnmodificar;
    }

    public JComboBox<String> getCobestado() {
        return Cobestado;
    }

    public void setCobestado(JComboBox<String> Cobestado) {
        this.Cobestado = Cobestado;
    }

    public JTable getTablarol() {
        return Tablarol;
    }

    public void setTablarol(JTable Tablarol) {
        this.Tablarol = Tablarol;
    }

    public JTextArea getTxtArea_descripcion() {
        return TxtArea_descripcion;
    }

    public void setTxtArea_descripcion(JTextArea TxtArea_descripcion) {
        this.TxtArea_descripcion = TxtArea_descripcion;
    }

    public JTextField getTxtbuscar() {
        return Txtbuscar;
    }

    public void setTxtbuscar(JTextField Txtbuscar) {
        this.Txtbuscar = Txtbuscar;
    }

    public JTextField getTxtcodigo() {
        return Txtcodigo;
    }

    public void setTxtcodigo(JTextField Txtcodigo) {
        this.Txtcodigo = Txtcodigo;
    }

    public JTextField getTxtnombre() {
        return Txtnombre;
    }

    public void setTxtnombre(JTextField Txtnombre) {
        this.Txtnombre = Txtnombre;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tablarol = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Btnguardar = new javax.swing.JButton();
        Btnmodificar = new javax.swing.JButton();
        Btneliminar = new javax.swing.JButton();
        Txtbuscar = new javax.swing.JTextField();
        Btnbuscar = new javax.swing.JButton();
        Txtcodigo = new javax.swing.JTextField();
        Cobestado = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtArea_descripcion = new javax.swing.JTextArea();
        Txtnombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Tablarol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "DESCRIPCION", "ESTADO"
            }
        ));
        jScrollPane1.setViewportView(Tablarol);

        jLabel1.setText("CODIGO:");

        jLabel2.setText("NOMBRE:");

        jLabel3.setText("DESCRIPCION:");

        jLabel4.setText("ESTADO:");

        Btnguardar.setText("GUARDAR");

        Btnmodificar.setText("MODIFICAR");

        Btneliminar.setText("ELIMINAR");

        Btnbuscar.setText("BUSCAR");

        Cobestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "inactivo", "activo" }));
        Cobestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CobestadoActionPerformed(evt);
            }
        });

        TxtArea_descripcion.setColumns(20);
        TxtArea_descripcion.setRows(5);
        jScrollPane2.setViewportView(TxtArea_descripcion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(Btnbuscar)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btnguardar)
                            .addComponent(Btnmodificar)
                            .addComponent(Btneliminar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cobestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(Txtnombre))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(Cobestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txtbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btnbuscar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Btnguardar)
                        .addGap(18, 18, 18)
                        .addComponent(Btnmodificar)
                        .addGap(18, 18, 18)
                        .addComponent(Btneliminar)
                        .addGap(46, 46, 46)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CobestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CobestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CobestadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnbuscar;
    private javax.swing.JButton Btneliminar;
    private javax.swing.JButton Btnguardar;
    private javax.swing.JButton Btnmodificar;
    private javax.swing.JComboBox<String> Cobestado;
    private javax.swing.JTable Tablarol;
    private javax.swing.JTextArea TxtArea_descripcion;
    private javax.swing.JTextField Txtbuscar;
    private javax.swing.JTextField Txtcodigo;
    private javax.swing.JTextField Txtnombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
