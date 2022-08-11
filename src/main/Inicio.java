
package main;

import controlador.C_Login;
import vista.V_Login;

public class Inicio {

    public static void main(String[] args) {
        V_Login vista = new V_Login();
        C_Login Inicio = new C_Login(vista);
    }
    
}
