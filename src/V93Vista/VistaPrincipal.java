/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package V93Vista;

import javax.swing.JMenuItem;

/**
 *
 * @author Usuario
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
        
        
        
        
    }

    public JMenuItem getNuevoCliente() {
        return NuevoCliente;
    }

    public void setNuevoCliente(JMenuItem NuevoCliente) {
        this.NuevoCliente = NuevoCliente;
    }

    public JMenuItem getNuevoProducto() {
        return NuevoProducto;
    }

    public void setNuevoProducto(JMenuItem NuevoProducto) {
        this.NuevoProducto = NuevoProducto;
    }

    public JMenuItem getNuevoProveedor() {
        return NuevoProveedor;
    }

    public void setNuevoProveedor(JMenuItem NuevoProveedor) {
        this.NuevoProveedor = NuevoProveedor;
    }

    public JMenuItem getNuevoRol() {
        return NuevoRol;
    }

    public void setNuevoRol(JMenuItem NuevoRol) {
        this.NuevoRol = NuevoRol;
    }

    public JMenuItem getNuevoUsuario() {
        return nuevoUsuario;
    }

    public void setNuevoUsuario(JMenuItem nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }

    public JMenuItem getNuevoPersona() {
        return nuevoPersona;
    }

    public void setNuevoPersona(JMenuItem nuevoPersona) {
        this.nuevoPersona = nuevoPersona;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        nuevoPersona = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        nuevoUsuario = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        NuevoRol = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        NuevoProveedor = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        NuevoProducto = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        NuevoCliente = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        jMenu1.setText("PERSONA");

        nuevoPersona.setText("NuevoPersona");
        jMenu1.add(nuevoPersona);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("USUARIO");

        nuevoUsuario.setText("NuevoUsuario");
        jMenu2.add(nuevoUsuario);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("ROL");

        NuevoRol.setText("NUEVO ROL");
        jMenu3.add(NuevoRol);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("PROVEEDOR");

        NuevoProveedor.setText("NuevoProveedor");
        jMenu4.add(NuevoProveedor);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("PRODUCTO");

        NuevoProducto.setText("NuevoProducto");
        jMenu5.add(NuevoProducto);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("CLIENTE");

        NuevoCliente.setText("NuevoCliente");
        jMenu6.add(NuevoCliente);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VistaPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem NuevoCliente;
    private javax.swing.JMenuItem NuevoProducto;
    private javax.swing.JMenuItem NuevoProveedor;
    private javax.swing.JMenuItem NuevoRol;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem nuevoPersona;
    private javax.swing.JMenuItem nuevoUsuario;
    // End of variables declaration//GEN-END:variables
}
