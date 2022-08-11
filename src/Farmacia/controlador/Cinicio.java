/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.controlador;

import Farmacia.modelo.UsuarioBD;
import Farmacia.modelo.UsuarioMD;
import Farmacia.vista.Vinicio;
import Farmacia.vista.Vmenu;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A
 */
public class Cinicio {
     private static Vinicio vista1;

    public Cinicio(Vinicio vista1) {
        this.vista1 = vista1;
        vista1.setVisible(true);
        vista1.setLocationRelativeTo(null);
        vista1.setResizable(false);
        vista1.getBtningresar().addActionListener(e -> ingresar());
    }
    
//    private void salir() {
//        System.exit(0);
//    }
    
    private void ingresar(){
        Vmenu vista = new Vmenu();
        Cprincipal cp = new Cprincipal(vista);
    }
}

 
//        this.vista = vista;
//        vista.setVisible(true);
//        vista.setLocationRelativeTo(null);
//        vista.getLbldatos().setVisible(false);
//        vista.getBtningresar().addActionListener(e -> {
//            try {
//                ingresar();
//            } catch (SQLException ex) {
//                Logger.getLogger(Cinicio.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//    }
//
//    public void ingresar() throws SQLException {
//        UsuarioBD dbp = new UsuarioBD();
//        List<UsuarioMD> lista = dbp.mostrardatos();
//        for (int i = 0; i < lista.size(); i++) {
//            if (vista.getTxtusuario().getText().equals(lista.get(i).getNombreU()) && vista.getTxtclave().getText().equals(lista.get(i).getClave()) && lista.get(i).getEstado().equals("Activo")) {
//                Vmenu vistamenu = new Vmenu();
//                Cprincipal menu = new Cprincipal(vistamenu);
//                vista.setVisible(false);
//                vista.getLbldatos().setVisible(false);
//                vistamenu.setVisible(true);
//            } else {
//                vista.getLbldatos().setVisible(true);
//            }
//        }
//
//    }
//
//}