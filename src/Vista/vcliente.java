/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author A
 */
public class vcliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form vcliente
     */
    public vcliente() {
        initComponents();
    }

    public JButton getBtn_buscar() {
        return btn_buscar;
    }

    public void setBtn_buscar(JButton btn_buscar) {
        this.btn_buscar = btn_buscar;
    }

    public JButton getBtn_eliminar() {
        return btn_eliminar;
    }

    public void setBtn_eliminar(JButton btn_eliminar) {
        this.btn_eliminar = btn_eliminar;
    }

    public JButton getBtn_guardar() {
        return btn_guardar;
    }

    public void setBtn_guardar(JButton btn_guardar) {
        this.btn_guardar = btn_guardar;
    }

    public JButton getBtn_modificar() {
        return btn_modificar;
    }

    public void setBtn_modificar(JButton btn_modificar) {
        this.btn_modificar = btn_modificar;
    }

    public JButton getBtn_nuevo() {
        return btn_nuevo;
    }

    public void setBtn_nuevo(JButton btn_nuevo) {
        this.btn_nuevo = btn_nuevo;
    }

    public JComboBox<String> getCombo_cedula() {
        return combo_cedula;
    }

    public void setCombo_cedula(JComboBox<String> combo_cedula) {
        this.combo_cedula = combo_cedula;
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

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLabelfoto() {
        return labelfoto;
    }

    public void setLabelfoto(JLabel labelfoto) {
        this.labelfoto = labelfoto;
    }

    public JTable getTabla_cliente() {
        return tabla_cliente;
    }

    public void setTabla_cliente(JTable tabla_cliente) {
        this.tabla_cliente = tabla_cliente;
    }

    public JTextField getTxt_alergias() {
        return txt_alergias;
    }

    public void setTxt_alergias(JTextField txt_alergias) {
        this.txt_alergias = txt_alergias;
    }

    public JTextField getTxt_buscar() {
        return txt_buscar;
    }

    public void setTxt_buscar(JTextField txt_buscar) {
        this.txt_buscar = txt_buscar;
    }

    

    public JTextField getTxt_direccion() {
        return txt_direccion;
    }

    public void setTxt_direccion(JTextField txt_direccion) {
        this.txt_direccion = txt_direccion;
    }

    public JTextField getTxt_enfermedades() {
        return txt_enfermedades;
    }

    public void setTxt_enfermedades(JTextField txt_enfermedades) {
        this.txt_enfermedades = txt_enfermedades;
    }

    public JTextField getTxt_nombre_persona() {
        return txt_nombre_persona;
    }

    public void setTxt_nombre_persona(JTextField txt_nombre_persona) {
        this.txt_nombre_persona = txt_nombre_persona;
    }

    public JTextField getTxt_telefono() {
        return txt_telefono;
    }

    public void setTxt_telefono(JTextField txt_telefono) {
        this.txt_telefono = txt_telefono;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JTextField getTxt_codigo() {
        return txt_codigo;
    }

    public void setTxt_codigo(JTextField txt_codigo) {
        this.txt_codigo = txt_codigo;
    }

    public JButton getBtnimprimir() {
        return Btnimprimir;
    }

    public void setBtnimprimir(JButton Btnimprimir) {
        this.Btnimprimir = Btnimprimir;
    }

    
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        txt_alergias = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelfoto = new javax.swing.JLabel();
        txt_nombre_persona = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_cliente = new javax.swing.JTable();
        combo_cedula = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        txt_buscar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_enfermedades = new javax.swing.JTextField();
        txt_codigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Btnimprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REGISTRO DE CLIENTES");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_nuevo.setText("NUEVO");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 29, -1, -1));

        btn_guardar.setText("GUARDAR");
        getContentPane().add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        btn_modificar.setText("MODIFICAR");
        getContentPane().add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        btn_eliminar.setText("ELIMINAR");
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 29, -1, -1));

        btn_buscar.setText("BUSCAR");
        getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        txt_alergias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_alergiasActionPerformed(evt);
            }
        });
        getContentPane().add(txt_alergias, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 230, -1));

        jLabel1.setText("CEDULA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel2.setText("NOMBRES Y APELLIDOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel3.setText("FOTO DEL CLIENTE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel4.setText("TELEFONO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        labelfoto.setText("foto");
        getContentPane().add(labelfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 130, 90));
        getContentPane().add(txt_nombre_persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 130, -1));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, -1));

        tabla_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "codigo", "cedula", "nombres", "telefono", "alergias", "enfermedades", "direccion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_cliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 560, 180));

        getContentPane().add(combo_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 130, -1));

        jLabel6.setText("ENFERMEDADES");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, -1));

        jLabel7.setText("ALERGIAS DEL CLIUENTE:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 230, -1));

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 80, -1));

        jLabel5.setText("DIRECCCION");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, -1));

        txt_enfermedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enfermedadesActionPerformed(evt);
            }
        });
        getContentPane().add(txt_enfermedades, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 230, -1));
        getContentPane().add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 70, 60));

        jLabel8.setText("CODIGO");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        Btnimprimir.setText("Imprimir");
        Btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnimprimirActionPerformed(evt);
            }
        });
        getContentPane().add(Btnimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void txt_alergiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alergiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_alergiasActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void txt_enfermedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enfermedadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enfermedadesActionPerformed

    private void BtnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnimprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnimprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnimprimir;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> combo_cedula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelfoto;
    private javax.swing.JTable tabla_cliente;
    private javax.swing.JTextField txt_alergias;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_enfermedades;
    private javax.swing.JTextField txt_nombre_persona;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
