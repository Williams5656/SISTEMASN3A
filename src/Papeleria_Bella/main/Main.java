/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Papeleria_Bella.main;

import Papeleria_Bella.controlador.*;
import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;

public class Main {
    public static void main(String[] args) {
        Vinicio vista = new  Vinicio();
        Cinicio main = new Cinicio(vista);
    }
}
