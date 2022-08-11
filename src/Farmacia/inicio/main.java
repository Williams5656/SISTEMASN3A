/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.inicio;

import Farmacia.controlador.Cinicio;
import Farmacia.vista.Vinicio;
import Farmacia.modelo.*;

/**
 *
 * @author VICO5
 */
public class main {
    public static void main(String[] args) {
        Vinicio vista1 =new Vinicio();
        Cinicio main = new Cinicio(vista1);
    }
}
