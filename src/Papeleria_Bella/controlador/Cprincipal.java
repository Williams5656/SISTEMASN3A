package Papeleria_Bella.controlador;

import Papeleria_Bella.controlador.*;
import static Papeleria_Bella.controlador.Cproductos.vistapr;
import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class Cprincipal {

    public static Vprincipal vista;
    String tUsuario = "usuario:";
    String pClave = "clave:";
    UsuarioBD lg = new UsuarioBD();
    UsuarioMD us = new UsuarioMD();
    int bloqueo = 3;
    int a = 0;
    boolean mostrar;

    public Cprincipal(Vprincipal vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setExtendedState(MAXIMIZED_BOTH);
        vista.getItempersona().addActionListener(e -> persona());
        vista.getItemusuario().addActionListener(e -> usuario());
        vista.getItemroles().addActionListener(e -> roles());
        vista.getItemempresa().addActionListener(e -> info());
        vista.getItemproductos().addActionListener(e -> productos());
        vista.getItemproveedores().addActionListener(e -> proveedores());
        vista.getItemclientes().addActionListener(e -> clientes());
        vista.getItemstock().addActionListener(e -> stock());
        vista.getItemventas().addActionListener(e -> ventas());
        vista.getItemcotizacion().addActionListener(e -> cotizacion());
        vista.getItemreportes().addActionListener(e -> reportes());

    }

    private void persona() {
        Vpersona1 p = new Vpersona1();
        Cpersona cper = new Cpersona(p);
    }

    private void usuario() {
        Vusuario vus = new Vusuario();
        Cusuario cuser = new Cusuario(vus);
    }

    private void roles() {
        Vrol p = new Vrol();
        Crol cper = new Crol(p);
    }

    private void info() {
        Vdatos p = new Vdatos();
        Cdatos cper = new Cdatos(p);
    }

    private void productos() {
        Vproductos p = new Vproductos();
        Cproductos cper = new Cproductos(p);
    }

    private void proveedores() {
        Vproveedores p = new Vproveedores();
        Cproveedores cper = new Cproveedores(p);
    }

    private void clientes() {
        Vclientes p = new Vclientes();
        Cclientes cper = new Cclientes(p);
    }

    private void stock() {
        Vstock p = new Vstock();
        Cstock cper = new Cstock(p);
    }

    private void ventas() {
//        Vventas p= new Vventas();
//        Cventas cper=new Cventas(p);
    }

    private void cotizacion() {
        Vcotizacion p = new Vcotizacion();
        Ccotizacion cper = new Ccotizacion(p);
    }

    private void reportes() {
        Vreportes p = new Vreportes();
        Creportes cper = new Creportes(p);
    }

}
