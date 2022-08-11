package ABG_System.vista;

import javax.swing.*;
import java.awt.*;

public class V_Principal extends javax.swing.JFrame {

    public V_Principal() {
        initComponents();
    }

    public JDesktopPane getEscritorio() {
        return Escritorio;
    }

    public void setEscritorio(JDesktopPane Escritorio) {
        this.Escritorio = Escritorio;
    }

    public JMenuItem getBtncliente() {
        return btncliente;
    }

    public void setBtncliente(JMenuItem btncliente) {
        this.btncliente = btncliente;
    }

    public JMenuItem getBtnpersona() {
        return btnpersona;
    }

    public void setBtnpersona(JMenuItem btnpersona) {
        this.btnpersona = btnpersona;
    }

    public JMenuItem getBtnrol() {
        return btnrol;
    }

    public void setBtnrol(JMenuItem btnrol) {
        this.btnrol = btnrol;
    }

    public JMenuItem getBtnusuario() {
        return btnusuario;
    }

    public void setBtnusuario(JMenuItem btnusuario) {
        this.btnusuario = btnusuario;
    }

    public JMenu getCliente() {
        return cliente;
    }

    public void setCliente(JMenu cliente) {
        this.cliente = cliente;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JMenu getPersona() {
        return persona;
    }

    public void setPersona(JMenu persona) {
        this.persona = persona;
    }

    public JMenu getRol() {
        return rol;
    }

    public void setRol(JMenu rol) {
        this.rol = rol;
    }

    public JMenu getUsuario() {
        return usuario;
    }

    public void setUsuario(JMenu usuario) {
        this.usuario = usuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/ABG_System/controlador/FondoEscritorio.jpg"));
        Image image = icon.getImage();
        Escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        persona = new javax.swing.JMenu();
        btnpersona = new javax.swing.JMenuItem();
        usuario = new javax.swing.JMenu();
        btnusuario = new javax.swing.JMenuItem();
        cliente = new javax.swing.JMenu();
        btncliente = new javax.swing.JMenuItem();
        rol = new javax.swing.JMenu();
        btnrol = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Escritorio.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        persona.setText("PERSONA");

        btnpersona.setText("Nuevo");
        persona.add(btnpersona);

        jMenuBar1.add(persona);

        usuario.setText("USUARIO");

        btnusuario.setText("Nuevo");
        usuario.add(btnusuario);

        jMenuBar1.add(usuario);

        cliente.setText("CLIENTE");

        btncliente.setText("Nuevo");
        cliente.add(btncliente);

        jMenuBar1.add(cliente);

        rol.setText("ROL");

        btnrol.setText("Nuevo");
        rol.add(btnrol);

        jMenuBar1.add(rol);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem btncliente;
    private javax.swing.JMenuItem btnpersona;
    private javax.swing.JMenuItem btnrol;
    private javax.swing.JMenuItem btnusuario;
    private javax.swing.JMenu cliente;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu persona;
    private javax.swing.JMenu rol;
    private javax.swing.JMenu usuario;
    // End of variables declaration//GEN-END:variables
}
