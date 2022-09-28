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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author VICO5
 */
public class vproducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form vproducto
     */
    public vproducto() {
        initComponents();
    }

    public JButton getBtn_eliminar() {
        return btn_eliminar;
    }

    public void setBtn_eliminar(JButton btn_eliminar) {
        this.btn_eliminar = btn_eliminar;
    }

    public JButton getBtn_foto() {
        return btn_foto;
    }

    public void setBtn_foto(JButton btn_foto) {
        this.btn_foto = btn_foto;
    }

    public JButton getBtn_guardar() {
        return btn_guardar;
    }

    public void setBtn_guardar(JButton btn_guardar) {
        this.btn_guardar = btn_guardar;
    }

    public JButton getBtn_modifcar() {
        return btn_modifcar;
    }

    public void setBtn_modifcar(JButton btn_modifcar) {
        this.btn_modifcar = btn_modifcar;
    }

    public JButton getBtn_nuevo() {
        return btn_nuevo;
    }

    public void setBtn_nuevo(JButton btn_nuevo) {
        this.btn_nuevo = btn_nuevo;
    }

    public JComboBox<String> getCombo_lab() {
        return combo_cantidad;
    }

    public void setCombo_lab(JComboBox<String> combo_lab) {
        this.combo_cantidad = combo_lab;
    }

    public JComboBox<String> getCombo_presentacion() {
        return combo_presentacion;
    }

    public void setCombo_presentacion(JComboBox<String> combo_presentacion) {
        this.combo_presentacion = combo_presentacion;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
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

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JLabel getLabel_foto() {
        return label_foto;
    }

    public void setLabel_foto(JLabel label_foto) {
        this.label_foto = label_foto;
    }

    
    public JTable getTabla_productos() {
        return tabla_productos;
    }

    public void setTabla_productos(JTable tabla_productos) {
        this.tabla_productos = tabla_productos;
    }

    public JTextArea getTex_descripcion() {
        return tex_descripcion;
    }

    public void setTex_descripcion(JTextArea tex_descripcion) {
        this.tex_descripcion = tex_descripcion;
    }

    public JTextField getTxt_buscar() {
        return txt_buscar;
    }

    public void setTxt_buscar(JTextField txt_buscar) {
        this.txt_buscar = txt_buscar;
    }

    public JDateChooser getTxt_calendari() {
        return txt_calendari;
    }

    public void setTxt_calendari(JDateChooser txt_calendari) {
        this.txt_calendari = txt_calendari;
    }

    public JDateChooser getTxt_calendarv() {
        return txt_calendarv;
    }

    public void setTxt_calendarv(JDateChooser txt_calendarv) {
        this.txt_calendarv = txt_calendarv;
    }

    public JTextField getTxt_codigo() {
        return txt_codigo;
    }

    public void setTxt_codigo(JTextField txt_codigo) {
        this.txt_codigo = txt_codigo;
    }

    public JTextField getTxt_nombreproducto() {
        return txt_nombreproducto;
    }

    public void setTxt_nombreproducto(JTextField txt_nombreproducto) {
        this.txt_nombreproducto = txt_nombreproducto;
    }

    public JTextField getTxt_pvp() {
        return txt_pvp;
    }

    public void setTxt_pvp(JTextField txt_pvp) {
        this.txt_pvp = txt_pvp;
    }

    public JComboBox<String> getCombo_cantidad() {
        return combo_cantidad;
    }

    public void setCombo_cantidad(JComboBox<String> combo_cantidad) {
        this.combo_cantidad = combo_cantidad;
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
        btn_modifcar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_foto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_productos = new javax.swing.JTable();
        label_foto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        txt_codigo = new javax.swing.JTextField();
        txt_nombreproducto = new javax.swing.JTextField();
        txt_pvp = new javax.swing.JTextField();
        txt_calendarv = new com.toedter.calendar.JDateChooser();
        txt_calendari = new com.toedter.calendar.JDateChooser();
        combo_presentacion = new javax.swing.JComboBox<>();
        combo_cantidad = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tex_descripcion = new javax.swing.JTextArea();
        combo_lab = new javax.swing.JComboBox<>();
        Btnimprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("INGRESO DE PRODUCTOS\n");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_nuevo.setText("NUEVO");
        getContentPane().add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 21, -1, -1));

        btn_guardar.setText("GUARDAR");
        getContentPane().add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        btn_modifcar.setText("MODIFICAR");
        getContentPane().add(btn_modifcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        btn_eliminar.setText("ELIMINAR");
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        btn_foto.setText("SUBIR FOTO");
        btn_foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fotoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, -1, -1));

        tabla_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "codigo", "nombres", "presentacion", "laboratorio", "cantidad", "precio_venta", "fecha_inicio", "fecha_vencimiento", "descripcion", "foto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Byte.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_productos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 930, 160));

        label_foto.setText("FOTO");
        getContentPane().add(label_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 110, 120));

        jLabel2.setText("CODIGO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel3.setText("NOMBRE DEL PRODCUTO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel4.setText("PRESENTACION");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel5.setText("LABORATORIO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel6.setText("CANTIDAD");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel7.setText("PRECION VENTA AL PUBLICO");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, 20));

        jLabel8.setText("FECHA DE INGRESO");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, 20));

        jLabel9.setText("FECHA DE VENCIMIENTO");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, 20));

        jLabel10.setText("DESCRIPCION");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, 20));
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 170, -1));
        getContentPane().add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 30, -1));
        getContentPane().add(txt_nombreproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, -1));
        getContentPane().add(txt_pvp, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 60, -1));
        getContentPane().add(txt_calendarv, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 240, -1));
        getContentPane().add(txt_calendari, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 250, -1));

        combo_presentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Frasco", "Caja", "Tabletas ", "Sobres", " " }));
        getContentPane().add(combo_presentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 160, -1));

        combo_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_cantidadActionPerformed(evt);
            }
        });
        getContentPane().add(combo_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 160, -1));

        tex_descripcion.setColumns(20);
        tex_descripcion.setRows(5);
        jScrollPane2.setViewportView(tex_descripcion);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 240, 70));

        combo_lab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        getContentPane().add(combo_lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 160, -1));

        Btnimprimir.setText("Imprimir");
        getContentPane().add(Btnimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_fotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_fotoActionPerformed

    private void combo_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_cantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnimprimir;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_foto;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modifcar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> combo_cantidad;
    private javax.swing.JComboBox<String> combo_lab;
    private javax.swing.JComboBox<String> combo_presentacion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_foto;
    private javax.swing.JTable tabla_productos;
    private javax.swing.JTextArea tex_descripcion;
    private javax.swing.JTextField txt_buscar;
    private com.toedter.calendar.JDateChooser txt_calendari;
    private com.toedter.calendar.JDateChooser txt_calendarv;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_nombreproducto;
    private javax.swing.JTextField txt_pvp;
    // End of variables declaration//GEN-END:variables
}
