package main;

import controlador.*;
import vista.*;

public class Inicio {

    public static void main(String[] args) {
        V_Principal vista= new V_Principal();
        C_Principal Inicio = new C_Principal(vista);
    }

}
