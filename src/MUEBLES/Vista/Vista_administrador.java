package MUEBLES.Vista;

import javax.swing.JMenuItem;


public class Vista_administrador extends javax.swing.JFrame {

    
    public Vista_administrador() {
        initComponents();
    }

    public JMenuItem getItm_revisarprod3() {
        return Itm_revisarprod3;
    }

    public void setItm_revisarprod3(JMenuItem Itm_revisarprod3) {
        this.Itm_revisarprod3 = Itm_revisarprod3;
    }

    public JMenuItem getItm_ingresarprod() {
        return itm_ingresarprod;
    }

    public void setItm_ingresarprod(JMenuItem itm_ingresarprod) {
        this.itm_ingresarprod = itm_ingresarprod;
    }

    public JMenuItem getItm_regresar() {
        return itm_regresar;
    }

    public void setItm_regresar(JMenuItem itm_regresar) {
        this.itm_regresar = itm_regresar;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itm_ingresarprod = new javax.swing.JMenuItem();
        Itm_revisarprod3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itm_regresar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRADOR");
        setResizable(false);

        jMenu1.setText("MENU");

        itm_ingresarprod.setText("Ingresar");
        jMenu1.add(itm_ingresarprod);

        Itm_revisarprod3.setText("Revisar");
        jMenu1.add(Itm_revisarprod3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("REGRESAR");

        itm_regresar.setText("Regresar");
        jMenu2.add(itm_regresar);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Itm_revisarprod3;
    private javax.swing.JMenuItem itm_ingresarprod;
    private javax.swing.JMenuItem itm_regresar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
