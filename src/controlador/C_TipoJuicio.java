package controlador;

import vista.V_RegistroJuicio;

public class C_TipoJuicio {
public static V_RegistroJuicio vistajuicio;
public C_TipoJuicio(V_RegistroJuicio vistajuicio){
    this.vistajuicio=vistajuicio;
    vistajuicio.setVisible(true);
}
}
