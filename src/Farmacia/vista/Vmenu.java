/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.vista;

import java.awt.Dimension;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *
 * @author A
 */
public class Vmenu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Vmenu() {
        initComponents();
    }

    public JCheckBoxMenuItem getBtn_cliente() {
        return btn_cliente;
    }

    public void setBtn_cliente(JCheckBoxMenuItem btn_cliente) {
        this.btn_cliente = btn_cliente;
    }

    public JCheckBoxMenuItem getBtn_factura() {
        return btn_factura;
    }

    public void setBtn_factura(JCheckBoxMenuItem btn_factura) {
        this.btn_factura = btn_factura;
    }

    public JCheckBoxMenuItem getBtn_farmaceutico() {
        return btn_farmaceutico;
    }

    public void setBtn_farmaceutico(JCheckBoxMenuItem btn_farmaceutico) {
        this.btn_farmaceutico = btn_farmaceutico;
    }

    public JCheckBoxMenuItem getBtn_medicamento() {
        return btn_medicamento;
    }

    public void setBtn_medicamento(JCheckBoxMenuItem btn_medicamento) {
        this.btn_medicamento = btn_medicamento;
    }

    public JCheckBoxMenuItem getBtn_pedido() {
        return btn_pedido;
    }

    public void setBtn_pedido(JCheckBoxMenuItem btn_pedido) {
        this.btn_pedido = btn_pedido;
    }

    public JCheckBoxMenuItem getBtn_proveedor() {
        return btn_proveedor;
    }

    public void setBtn_proveedor(JCheckBoxMenuItem btn_proveedor) {
        this.btn_proveedor = btn_proveedor;
    }

    public JCheckBoxMenuItem getBtn_usuario() {
        return btn_usuario;
    }

    public void setBtn_usuario(JCheckBoxMenuItem btn_usuario) {
        this.btn_usuario = btn_usuario;
    }

    public JDesktopPane getjDesktopPane1() {
        return jDesktopPane1;
    }

    public void setjDesktopPane1(JDesktopPane jDesktopPane1) {
        this.jDesktopPane1 = jDesktopPane1;
    }

    public JMenu getjMenu1() {
        return jMenu1;
    }

    public void setjMenu1(JMenu jMenu1) {
        this.jMenu1 = jMenu1;
    }

    public JMenu getjMenu3() {
        return jMenu3;
    }

    public void setjMenu3(JMenu jMenu3) {
        this.jMenu3 = jMenu3;
    }

    public JMenu getjMenu4() {
        return jMenu4;
    }

    public void setjMenu4(JMenu jMenu4) {
        this.jMenu4 = jMenu4;
    }

    public JMenu getjMenu5() {
        return jMenu5;
    }

    public void setjMenu5(JMenu jMenu5) {
        this.jMenu5 = jMenu5;
    }

    public JMenu getjMenu6() {
        return jMenu6;
    }

    public void setjMenu6(JMenu jMenu6) {
        this.jMenu6 = jMenu6;
    }

    public JMenu getjMenu7() {
        return jMenu7;
    }

    public void setjMenu7(JMenu jMenu7) {
        this.jMenu7 = jMenu7;
    }

    public JMenu getjMenu8() {
        return jMenu8;
    }

    public void setjMenu8(JMenu jMenu8) {
        this.jMenu8 = jMenu8;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btn_usuario = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();
        btn_cliente = new javax.swing.JCheckBoxMenuItem();
        jMenu4 = new javax.swing.JMenu();
        btn_factura = new javax.swing.JCheckBoxMenuItem();
        jMenu5 = new javax.swing.JMenu();
        btn_farmaceutico = new javax.swing.JCheckBoxMenuItem();
        jMenu6 = new javax.swing.JMenu();
        btn_medicamento = new javax.swing.JCheckBoxMenuItem();
        jMenu7 = new javax.swing.JMenu();
        btn_pedido = new javax.swing.JCheckBoxMenuItem();
        jMenu8 = new javax.swing.JMenu();
        btn_proveedor = new javax.swing.JCheckBoxMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        jMenu1.setText("Usuario");

        btn_usuario.setSelected(true);
        btn_usuario.setText("Usuario");
        btn_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usuarioActionPerformed(evt);
            }
        });
        jMenu1.add(btn_usuario);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Cliente");

        btn_cliente.setSelected(true);
        btn_cliente.setText("Cliente");
        btn_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clienteActionPerformed(evt);
            }
        });
        jMenu3.add(btn_cliente);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Factura");

        btn_factura.setSelected(true);
        btn_factura.setText("Factura");
        btn_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_facturaActionPerformed(evt);
            }
        });
        jMenu4.add(btn_factura);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Farmaceutico");

        btn_farmaceutico.setSelected(true);
        btn_farmaceutico.setText("Farmaceutico");
        btn_farmaceutico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_farmaceuticoActionPerformed(evt);
            }
        });
        jMenu5.add(btn_farmaceutico);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Medicamento");

        btn_medicamento.setSelected(true);
        btn_medicamento.setText("Medicamento");
        btn_medicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_medicamentoActionPerformed(evt);
            }
        });
        jMenu6.add(btn_medicamento);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Pedido");

        btn_pedido.setSelected(true);
        btn_pedido.setText("Pedido");
        jMenu7.add(btn_pedido);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Proveedor");

        btn_proveedor.setSelected(true);
        btn_proveedor.setText("Proveedor");
        btn_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_proveedorActionPerformed(evt);
            }
        });
        jMenu8.add(btn_proveedor);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuarioActionPerformed
       Vista_Persona es = new Vista_Persona();
       jDesktopPane1.add(es);
       Dimension desktopSize = jDesktopPane1.getSize();
       Dimension FrameSize = es.getSize();
       es.setLocation((desktopSize.width - FrameSize.width)/2,
               (desktopSize.height- FrameSize.height)/2);
       es.show();
       es.setVisible(true);
    }//GEN-LAST:event_btn_usuarioActionPerformed

    private void btn_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_proveedorActionPerformed
       Vproveedor es = new Vproveedor();
       jDesktopPane1.add(es);
       Dimension desktopSize = jDesktopPane1.getSize();
       Dimension FrameSize = es.getSize();
       es.setLocation((desktopSize.width - FrameSize.width)/2,
               (desktopSize.height- FrameSize.height)/2);
       es.show();
       es.setVisible(true);
    }//GEN-LAST:event_btn_proveedorActionPerformed

    private void btn_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clienteActionPerformed
       Vcliente es = new Vcliente();
       jDesktopPane1.add(es);
       Dimension desktopSize = jDesktopPane1.getSize();
       Dimension FrameSize = es.getSize();
       es.setLocation((desktopSize.width - FrameSize.width)/2,
               (desktopSize.height- FrameSize.height)/2);
       es.show();
       es.setVisible(true);
    }//GEN-LAST:event_btn_clienteActionPerformed

    private void btn_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_facturaActionPerformed
       Vfactura es = new Vfactura();
       jDesktopPane1.add(es);
       Dimension desktopSize = jDesktopPane1.getSize();
       Dimension FrameSize = es.getSize();
       es.setLocation((desktopSize.width - FrameSize.width)/2,
               (desktopSize.height- FrameSize.height)/2);
       es.show();
       es.setVisible(true);
    }//GEN-LAST:event_btn_facturaActionPerformed

    private void btn_medicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_medicamentoActionPerformed
       Vmedicamento es = new Vmedicamento();
       jDesktopPane1.add(es);
       Dimension desktopSize = jDesktopPane1.getSize();
       Dimension FrameSize = es.getSize();
       es.setLocation((desktopSize.width - FrameSize.width)/2,
               (desktopSize.height- FrameSize.height)/2);
       es.show();
       es.setVisible(true);
    }//GEN-LAST:event_btn_medicamentoActionPerformed

    private void btn_farmaceuticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_farmaceuticoActionPerformed
       Vfarmaceutico es = new Vfarmaceutico();
       jDesktopPane1.add(es);
       Dimension desktopSize = jDesktopPane1.getSize();
       Dimension FrameSize = es.getSize();
       es.setLocation((desktopSize.width - FrameSize.width)/2,
               (desktopSize.height- FrameSize.height)/2);
       es.show();
       es.setVisible(true);
    }//GEN-LAST:event_btn_farmaceuticoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vmenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem btn_cliente;
    private javax.swing.JCheckBoxMenuItem btn_factura;
    private javax.swing.JCheckBoxMenuItem btn_farmaceutico;
    private javax.swing.JCheckBoxMenuItem btn_medicamento;
    private javax.swing.JCheckBoxMenuItem btn_pedido;
    private javax.swing.JCheckBoxMenuItem btn_proveedor;
    private javax.swing.JCheckBoxMenuItem btn_usuario;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
