/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controlador.cinicio;
import Vista.v_inicio;

/**
 *
 * @author VICO5
 */
public class main {
    public static void main(String[] args) {
        v_inicio vista = new v_inicio();
        cinicio inicio = new cinicio(vista);
    }
    
    
}
