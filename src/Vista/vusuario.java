/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author VICO5
 */
public class vusuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form vusuario
     */
    public vusuario() {
        initComponents();
    }

    public JTextField getTxt_nombrepersona() {
        return txt_nombrepersona;
    }

    public void setTxt_nombrepersona(JTextField txt_nombrepersona) {
        this.txt_nombrepersona = txt_nombrepersona;
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

    public JComboBox<String> getCombo_estado() {
        return combo_estado;
    }

    public void setCombo_estado(JComboBox<String> combo_estado) {
        this.combo_estado = combo_estado;
    }

    public JComboBox<String> getCombo_rol() {
        return combo_rol;
    }

    public void setCombo_rol(JComboBox<String> combo_rol) {
        this.combo_rol = combo_rol;
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

    public JTable getTabla_usuarios() {
        return tabla_usuarios;
    }

    public void setTabla_usuarios(JTable tabla_usuarios) {
        this.tabla_usuarios = tabla_usuarios;
    }

    public JTextField getTxt_buscar() {
        return txt_buscar;
    }

    public void setTxt_buscar(JTextField txt_buscar) {
        this.txt_buscar = txt_buscar;
    }

   

    public JComboBox<String> getCombo_cedula() {
        return combo_cedula;
    }

    public void setCombo_cedula(JComboBox<String> combo_cedula) {
        this.combo_cedula = combo_cedula;
    }

    public JLabel getLabel_foto() {
        return label_foto;
    }

    public void setLabel_foto(JLabel label_foto) {
        this.label_foto = label_foto;
    }


    public JTextField getTxt_codigo() {
        return txt_codigo;
    }

    public void setTxt_codigo(JTextField txt_codigo) {
        this.txt_codigo = txt_codigo;
    }

    public JPasswordField getTxt_contraseña() {
        return txt_contraseña;
    }

    public void setTxt_contraseña(JPasswordField txt_contraseña) {
        this.txt_contraseña = txt_contraseña;
    }

    public JTextField getTxt_usuario() {
        return txt_usuario;
    }

    public void setTxt_usuario(JTextField txt_usuario) {
        this.txt_usuario = txt_usuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_buscar = new javax.swing.JTextField();
        txt_contraseña = new javax.swing.JPasswordField();
        combo_rol = new javax.swing.JComboBox<>();
        combo_estado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_usuarios = new javax.swing.JTable();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        txt_codigo = new javax.swing.JTextField();
        combo_cedula = new javax.swing.JComboBox<>();
        label_foto = new javax.swing.JLabel();
        txt_nombrepersona = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ESTADO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel2.setText("REGISTRO DE USUARIO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel3.setText("CODIGO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel4.setText("CEDULA");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel5.setText("USUARIO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel6.setText("CONTRASEÑA");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel7.setText("ROL");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));
        getContentPane().add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 170, -1));
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 140, -1));
        getContentPane().add(txt_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 170, -1));

        getContentPane().add(combo_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 170, -1));

        combo_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", " " }));
        getContentPane().add(combo_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 160, -1));

        tabla_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cedula", "Usuario", "Password", "Rol", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_usuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 560, 150));

        btn_nuevo.setText("nuevo");
        getContentPane().add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        btn_guardar.setText("guardar");
        getContentPane().add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        btn_modificar.setText("modificar");
        getContentPane().add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        btn_eliminar.setText("eliminar");
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));
        getContentPane().add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 40, -1));

        getContentPane().add(combo_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 170, -1));

        label_foto.setText("foto");
        getContentPane().add(label_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 110, 110));
        getContentPane().add(txt_nombrepersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> combo_cedula;
    private javax.swing.JComboBox<String> combo_estado;
    private javax.swing.JComboBox<String> combo_rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_foto;
    private javax.swing.JTable tabla_usuarios;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JPasswordField txt_contraseña;
    private javax.swing.JTextField txt_nombrepersona;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
