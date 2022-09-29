package Papeleria_Bella.controlador;

import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import static Papeleria_Bella.modelo.VentasBD.vistav;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cventas {

    public static Vventas vistav;
    private VentasBD bventas = new VentasBD();
    final double iva = 0.12;

    public Cventas(Vventas vistav) {
        this.vistav = vistav;
        vistav.setVisible(true);
        vistav.setLocationRelativeTo(null);
        GenerarSerie();
        vistav.getLabelFecha().setText("" + LocalDate.now());
        vistav.getBtn_BuscarCedula().addActionListener(x -> BuscarCliente(vistav.getTxtbuscarcedula().getText()));

    }

    public void BuscarCliente(String cedula) {

        if (vistav.getTxtbuscarcedula().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene el campo para realizar la busqueda", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            Conexion conectar = new Conexion();
            String sql = "Select nombres,apellidos from persona\n"
                    + "Where cedula=(Select cedula from clientes Where \"cedula\"='" + cedula + "')";
            ResultSet rs = conectar.query(sql);
            try {
                while (rs.next()) {
                    vistav.getLabelnombres().setText(rs.getString("nombres") + " " + rs.getString("apellidos"));

                }
            } catch (SQLException ex) {
                Logger.getLogger(VentasBD.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERROR: " + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void GenerarSerie() {
        String serie = bventas.NroSerieVentas();
        if (serie == null) {
            vistav.getLabelSerieFactura().setText("000001");
        } else {
            int aumento = Integer.parseInt(serie);
            aumento = aumento + 1;
            vistav.getLabelSerieFactura().setText("00000" + aumento);
        }
    }
}
