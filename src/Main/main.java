/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controlador.cprincipal;
import Vista.vprincipal;

/**
 *
 * @author VICO5
 */
public class main {
    public static void main(String[] args) {
        vprincipal vista = new vprincipal();
        cprincipal inicio = new cprincipal(vista);
    }
    
    
}
