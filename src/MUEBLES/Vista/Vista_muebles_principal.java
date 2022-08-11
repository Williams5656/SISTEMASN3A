package MUEBLES.Vista;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Vista_muebles_principal extends javax.swing.JFrame {

    public Vista_muebles_principal() {
        initComponents();
    }

    public JDesktopPane getDesk_escritorio_muebles() {
        return Desk_escritorio_muebles;
    }

    public void setDesk_escritorio_muebles(JDesktopPane Desk_escritorio_muebles) {
        this.Desk_escritorio_muebles = Desk_escritorio_muebles;
    }

    public JMenuItem getItmPersona() {
        return ItmPersona;
    }

    public void setItmPersona(JMenuItem ItmPersona) {
        this.ItmPersona = ItmPersona;
    }

    public JMenuItem getItmRegresar() {
        return ItmRegresar;
    }

    public void setItmRegresar(JMenuItem ItmRegresar) {
        this.ItmRegresar = ItmRegresar;
    }

    public JMenuItem getItmUsuario() {
        return ItmUsuario;
    }

    public void setItmUsuario(JMenuItem ItmUsuario) {
        this.ItmUsuario = ItmUsuario;
    }

    public JMenu getjMenu1() {
        return jMenu1;
    }

    public void setjMenu1(JMenu jMenu1) {
        this.jMenu1 = jMenu1;
    }

    public JMenu getjMenu2() {
        return jMenu2;
    }

    public void setjMenu2(JMenu jMenu2) {
        this.jMenu2 = jMenu2;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Desk_escritorio_muebles = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        ItmPersona = new javax.swing.JMenuItem();
        ItmUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        ItmRegresar = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout Desk_escritorio_mueblesLayout = new javax.swing.GroupLayout(Desk_escritorio_muebles);
        Desk_escritorio_muebles.setLayout(Desk_escritorio_mueblesLayout);
        Desk_escritorio_mueblesLayout.setHorizontalGroup(
            Desk_escritorio_mueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );
        Desk_escritorio_mueblesLayout.setVerticalGroup(
            Desk_escritorio_mueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        jMenu1.setText("ROLES");

        ItmPersona.setText("Persona");
        jMenu1.add(ItmPersona);

        ItmUsuario.setText("Usuario");
        jMenu1.add(ItmUsuario);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("REGRESAR");

        ItmRegresar.setText("Regresar");
        jMenu2.add(ItmRegresar);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desk_escritorio_muebles)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desk_escritorio_muebles)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desk_escritorio_muebles;
    private javax.swing.JMenuItem ItmPersona;
    private javax.swing.JMenuItem ItmRegresar;
    private javax.swing.JMenuItem ItmUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
