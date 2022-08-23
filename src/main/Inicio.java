package main;

import controlador.*;
import vista.*;

public class Inicio {

    public static void main(String[] args) {
        V_Login vista = new V_Login();
        C_Login Inicio = new C_Login(vista);
    }

}
