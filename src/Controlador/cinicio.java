/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.usuarioBD;
import Modelo.usuarioMD;
import Vista.*;
import javax.swing.JOptionPane;

/**
 *
 * @author VICO5
 */
public class cinicio {

    public static v_inicio vista;
    private usuarioBD bdusuario = new usuarioBD();

    public cinicio(v_inicio vista) {
        this.vista = vista;

        vista.setVisible(true);
        vista.getBtn_ingresar().addActionListener(e -> ingresar());

    }
    public void ingresar(){
        usuarioMD usuarioMD =bdusuario.obtenerUsuario(vista.getTxt_usuario().getText());
        if(usuarioMD==null){
            JOptionPane.showMessageDialog(null, "No existe un usuario con ese nombre");
        }
        else{
            if(usuarioMD.getPassword().equals(vista.getTxt_contraseña().getText())){
                if(usuarioMD.getRol().equalsIgnoreCase(vista.getCombo_estados().getSelectedItem().toString())){
                    if(usuarioMD.getEstado().equalsIgnoreCase("Activo")){
                       vprincipal userp = new vprincipal();
                    cprincipal user = new cprincipal(userp); 
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "usuario inactivo");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Rol Incorrecto");
                }
             
            }
            else{
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
            }
        }
    }
}
