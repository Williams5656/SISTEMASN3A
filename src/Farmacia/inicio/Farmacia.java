/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.inicio;

import Farmacia.controlador.Cinicio;
import Farmacia.vista.Vinicio;

/**
 *
 * @author VICO5
 */
public class Farmacia {
    public static void main(String[] args) {
        Vinicio vista =new Vinicio();
        Cinicio inicio = new Cinicio(vista);
    }
}
