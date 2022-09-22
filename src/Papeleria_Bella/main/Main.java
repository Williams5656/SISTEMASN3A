 //Clase Main
package Papeleria_Bella.main;

import Papeleria_Bella.controlador.*;
import Papeleria_Bella.vista.*;
 
public class Main {
    public static void main(String[] args) {
        Vinicio vista = new  Vinicio();
        Cinicio main = new Cinicio(vista);
    }
    
}       
