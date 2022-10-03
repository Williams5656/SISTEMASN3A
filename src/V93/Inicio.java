package V93;

import V93Controlador.CLogin;
import V93Vista.VistaLogin;

public class Inicio {

    public static void main(String[] args) {
        VistaLogin vlogin = new VistaLogin();
        CLogin clogin = new CLogin(vlogin);
    }

}
