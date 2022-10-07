package controlador;

import vista.V_Servicios;

public class C_Servicio {

    public static V_Servicios vistaservicios;

    public C_Servicio(V_Servicios vistaservicios) {
        this.vistaservicios = vistaservicios;
        vistaservicios.setVisible(true);
    }
}
