/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Papeleria_Bella.vista;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author hp
 */
public class Vprincipal extends javax.swing.JFrame {
 public Vprincipal() {
        initComponents();
    }

    public JMenuItem getItemroles() {
        return itemroles;
    }

    public void setItemroles(JMenuItem itemroles) {
        this.itemroles = itemroles;
    }

    public JMenuItem getItemempresa() {
        return itemempresa;
    }

    public void setItemempresa(JMenuItem itemempresa) {
        this.itemempresa = itemempresa;
    }

    public JMenu getIteminformacion() {
        return iteminformacion;
    }

    public void setIteminformacion(JMenu iteminformacion) {
        this.iteminformacion = iteminformacion;
    }

    public JMenuItem getItemproveedores() {
        return itemproveedores;
    }

    public void setItemproveedores(JMenuItem itemproveedores) {
        this.itemproveedores = itemproveedores;
    }

    
    
 

    public JMenuItem getItempersona() {
        return itempersona;
    }

    public void setItempersona(JMenuItem itempersona) {
        this.itempersona = itempersona;
    }

    public JMenuItem getItemusuario() {
        return itemusuario;
    }

    public void setItemusuario(JMenuItem itemusuario) {
        this.itemusuario = itemusuario;
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

    public JMenuItem getItemproductos() {
        return itemproductos;
    }

    public void setItemproductos(JMenuItem itemproductos) {
        this.itemproductos = itemproductos;
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
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        itempersona = new javax.swing.JMenuItem();
        itemusuario = new javax.swing.JMenuItem();
        itemroles = new javax.swing.JMenuItem();
        itemproductos = new javax.swing.JMenuItem();
        itemproveedores = new javax.swing.JMenuItem();
        iteminformacion = new javax.swing.JMenu();
        itemempresa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(231, 244, 244));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 714, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(162, 205, 205));
        jMenuBar1.add(jMenu2);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-crear-nuevo-16(1).png"))); // NOI18N
        jMenu1.setText("Nuevo");
        jMenu1.setFont(new java.awt.Font("Rockwell Condensed", 0, 18)); // NOI18N

        itempersona.setBackground(new java.awt.Color(220, 240, 240));
        itempersona.setFont(new java.awt.Font("Rockwell Condensed", 0, 18)); // NOI18N
        itempersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-persona-de-sexo-masculino-16.png"))); // NOI18N
        itempersona.setText("Persona");
        jMenu1.add(itempersona);

        itemusuario.setBackground(new java.awt.Color(220, 240, 240));
        itemusuario.setFont(new java.awt.Font("Rockwell Condensed", 0, 18)); // NOI18N
        itemusuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-tipo-de-piel-del-cliente-7-16.png"))); // NOI18N
        itemusuario.setText("Usuario");
        jMenu1.add(itemusuario);

        itemroles.setBackground(new java.awt.Color(220, 240, 240));
        itemroles.setFont(new java.awt.Font("Rockwell Condensed", 0, 18)); // NOI18N
        itemroles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-tipo-de-máscara-de-cuenta-de-usuario-7-16.png"))); // NOI18N
        itemroles.setText("Roles");
        jMenu1.add(itemroles);

        itemproductos.setBackground(new java.awt.Color(220, 240, 240));
        itemproductos.setFont(new java.awt.Font("Rockwell Condensed", 0, 18)); // NOI18N
        itemproductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caja-de-entrega.png"))); // NOI18N
        itemproductos.setText("Productos");
        itemproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemproductosActionPerformed(evt);
            }
        });
        jMenu1.add(itemproductos);

        itemproveedores.setBackground(new java.awt.Color(220, 240, 240));
        itemproveedores.setFont(new java.awt.Font("Rockwell Condensed", 0, 18)); // NOI18N
        itemproveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inventario.png"))); // NOI18N
        itemproveedores.setText("Proveedores");
        itemproveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemproveedoresActionPerformed(evt);
            }
        });
        jMenu1.add(itemproveedores);

        jMenuBar1.add(jMenu1);

        iteminformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-crear-nuevo-16(1).png"))); // NOI18N
        iteminformacion.setText("Informacion");
        iteminformacion.setFont(new java.awt.Font("Rockwell Condensed", 0, 18)); // NOI18N

        itemempresa.setBackground(new java.awt.Color(220, 240, 240));
        itemempresa.setFont(new java.awt.Font("Rockwell Condensed", 0, 18)); // NOI18N
        itemempresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-tipo-de-máscara-de-cuenta-de-usuario-7-16.png"))); // NOI18N
        itemempresa.setText("Empresa");
        iteminformacion.add(itemempresa);

        jMenuBar1.add(iteminformacion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemproductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemproductosActionPerformed

    private void itemproveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemproveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemproveedoresActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemempresa;
    private javax.swing.JMenu iteminformacion;
    private javax.swing.JMenuItem itempersona;
    private javax.swing.JMenuItem itemproductos;
    private javax.swing.JMenuItem itemproveedores;
    private javax.swing.JMenuItem itemroles;
    private javax.swing.JMenuItem itemusuario;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
