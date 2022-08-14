package MUEBLES.Vista;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Vista_persona_muebles extends javax.swing.JFrame {

    public Vista_persona_muebles() {
        initComponents();
    }

    public JButton getBtnbusqueda() {
        return Btnbusqueda;
    }

    public void setBtnbusqueda(JButton Btnbusqueda) {
        this.Btnbusqueda = Btnbusqueda;
    }

    public JButton getBtneliminar() {
        return Btneliminar;
    }

    public void setBtneliminar(JButton Btneliminar) {
        this.Btneliminar = Btneliminar;
    }

    public JButton getBtnmodificar() {
        return Btnmodificar;
    }

    public void setBtnmodificar(JButton Btnmodificar) {
        this.Btnmodificar = Btnmodificar;
    }

    public JButton getBtnnuevo() {
        return Btnnuevo;
    }

    public void setBtnnuevo(JButton Btnnuevo) {
        this.Btnnuevo = Btnnuevo;
    }

    public JTable getTabla_muebles_persona() {
        return Tabla_muebles_persona;
    }

    public void setTabla_muebles_persona(JTable Tabla_muebles_persona) {
        this.Tabla_muebles_persona = Tabla_muebles_persona;
    }

    public JTextField getTxtbusqueda() {
        return Txtbusqueda;
    }

    public void setTxtbusqueda(JTextField Txtbusqueda) {
        this.Txtbusqueda = Txtbusqueda;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btnnuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_muebles_persona = new javax.swing.JTable();
        Btnmodificar = new javax.swing.JButton();
        Btneliminar = new javax.swing.JButton();
        Txtbusqueda = new javax.swing.JTextField();
        Btnbusqueda = new javax.swing.JButton();

        setTitle("PERSONA");
        setResizable(false);

        Btnnuevo.setText("NUEVO");

        Tabla_muebles_persona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CEDULA", "NOMBRES", "APELLIDOS", "DIRECCION", "CELULAR", "NACIONALIDAD", "FECHA DE NACIMIENTO"
            }
        ));
        jScrollPane1.setViewportView(Tabla_muebles_persona);

        Btnmodificar.setText("MODIFICAR");

        Btneliminar.setText("ELIMINAR");

        Btnbusqueda.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btnmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(Txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btnbusqueda)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btnbusqueda))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(Btnnuevo)
                        .addGap(18, 18, 18)
                        .addComponent(Btnmodificar)
                        .addGap(18, 18, 18)
                        .addComponent(Btneliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnbusqueda;
    private javax.swing.JButton Btneliminar;
    private javax.swing.JButton Btnmodificar;
    private javax.swing.JButton Btnnuevo;
    private javax.swing.JTable Tabla_muebles_persona;
    private javax.swing.JTextField Txtbusqueda;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
