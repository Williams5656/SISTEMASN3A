package controlador;

import vista.V_Persona;

public class C_Persona {
    
    public static V_Persona vistapersona;
    
 public C_Persona(V_Persona vistapersona) {
        this.vistapersona = vistapersona;
        vistapersona.setVisible(true);
        
        
    }
}
