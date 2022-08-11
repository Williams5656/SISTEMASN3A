/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Papeleria_Bella.controlador;
import Papeleria_Bella.controlador.*;
import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
public class Cprincipal {
    public static Vprincipal vista;
    
    public Cprincipal(Vprincipal vista) {
        this.vista=vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setExtendedState(MAXIMIZED_BOTH);
        vista.getItempersona().addActionListener(e-> persona ());
        vista.getItemusuario().addActionListener(e-> usuario());

    }
    
    private void persona() {
        Vpersona p= new Vpersona();
        Cpersona cper=new Cpersona(p);
    }
    private void usuario() {
        Vusuario vus= new Vusuario();
        Cusuario cuser=new Cusuario(vus);
    }
   
}
