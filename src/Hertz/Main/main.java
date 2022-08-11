
package Hertz.Main;

import Hertz.Vista.*;
import Hertz.Controlador.*;

public class main {
    public static void main(String[] args) {
        
        VPrincipal vista = new VPrincipal();
        CPrincipal inicio = new CPrincipal(vista);
    }
    
}
