package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelo.*;
import vista.V_Usuario;

public class C_Usuario {
      public static V_Usuario vistarol;
    public UsuarioBD bdrol = new UsuarioBD();

 public C_Usuario(V_Usuario vistaUsuario) {
        this.vistarol = vistaUsuario;
        vistaUsuario.setVisible(true);
   
                }
}
