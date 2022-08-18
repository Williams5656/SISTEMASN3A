package vista;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class V_Principal extends javax.swing.JFrame {

    public V_Principal() {
        initComponents();
    }

    public JMenuItem getBtn_nuevopersona() {
        return Btn_nuevopersona;
    }

    public void setBtn_nuevopersona(JMenuItem Btn_nuevopersona) {
        this.Btn_nuevopersona = Btn_nuevopersona;
    }

    public JDesktopPane getEscritorio() {
        return Escritorio;
    }

    public void setEscritorio(JDesktopPane Escritorio) {
        this.Escritorio = Escritorio;
    }

    public JMenuItem getBtn_NuevoUsuario() {
        return Btn_NuevoUsuario;
    }

    public void setBtn_NuevoUsuario(JMenuItem Btn_NuevoUsuario) {
        this.Btn_NuevoUsuario = Btn_NuevoUsuario;
    }
    

    public JMenu getPersona() {
        return Persona;
    }

    public void setPersona(JMenu Persona) {
        this.Persona = Persona;
    }

    public JMenuItem getBtn_nuevorol() {
        return btn_nuevorol;
    }

    public void setBtn_nuevorol(JMenuItem btn_nuevorol) {
        this.btn_nuevorol = btn_nuevorol;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JMenu getRol() {
        return rol;
    }

    public void setRol(JMenu rol) {
        this.rol = rol;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Persona = new javax.swing.JMenu();
        Btn_nuevopersona = new javax.swing.JMenuItem();
        rol = new javax.swing.JMenu();
        btn_nuevorol = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        Btn_NuevoUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        Persona.setText("Persona");

        Btn_nuevopersona.setText("Nuevo");
        Persona.add(Btn_nuevopersona);

        jMenuBar1.add(Persona);

        rol.setText("Rol");

        btn_nuevorol.setText("Nuevo");
        rol.add(btn_nuevorol);

        jMenuBar1.add(rol);

        jMenu1.setText("Usuario");

        Btn_NuevoUsuario.setText("Nuevo");
        jMenu1.add(Btn_NuevoUsuario);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Btn_NuevoUsuario;
    private javax.swing.JMenuItem Btn_nuevopersona;
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenu Persona;
    private javax.swing.JMenuItem btn_nuevorol;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu rol;
    // End of variables declaration//GEN-END:variables
}
