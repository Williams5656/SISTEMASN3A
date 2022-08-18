/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.inicio;
import Farmacia.controlador.*;
import Farmacia.modelo.*;
import Farmacia.vista.*;

/**
 *
 * @author VICO5
 */
public class main {
     public static void main(String[] args) {
       v_principal Vista = new v_principal();
          c_principal Inicio = new c_principal(Vista);
    }
    
}
