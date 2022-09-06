package Farmacia.controlador;

import Farmacia.modelo.UsuarioBD;
import Farmacia.modelo.UsuarioMD;
import Farmacia.vista.Vmenu;
import Farmacia.vista.v_inicio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author A
 */
public class Con_inicio {
    private static v_inicio vista;

    public Con_inicio(v_inicio vista) {
        
//       this.vista1 = vista1;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        vista.getBtn_ingresar().addActionListener(e -> ingresar());
    
    }
    
//    private void salir() {
//        System.exit(0);
//    }
    
    private void ingresar(){
        Vmenu vista = new Vmenu();
        Con_menu cp = new Con_menu(vista);
    }
}

 
// private void ingresar() throws SQLException {
//        UsuarioBD dbp = new UsuarioBD();
//        List<UsuarioMD> lista = dbp.mostrardatos();
//        for (int i = 0; i < lista.size(); i++) {
//            if (vista.getTxt_usuario().getText().equals(lista.get(i).getNombreUsuario()) && vista.getTxt_contraseña().getText().equals(lista.get(i).getContrasenia())&&lista.get(i).getEstado().equals("Activo")) {
//                String[] v = dbp.persona(lista.get(i).getCedula());
//                Vmenu vistamenu = new Vmenu();
////                Con_menu menu = new Con_menu(vistamenu,v[0],v[1]);
//                vista.setVisible(false);
//                vista.getLblcomp().setVisible(false);
//                vistamenu.setVisible(true);
//            }else{
//                vista.getLblcomp().setVisible(true);
//            }
//        }
////        validarRol();
//    }
// }
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