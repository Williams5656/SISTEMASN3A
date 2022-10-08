package controlador;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conectar;
import modelo.ConsultorioBD;
import modelo.ConsultorioMD;
import modelo.RolBD;
import modelo.RolMD;
import modelo.ServicioBD;
import modelo.ServicioMD;
import modelo.TipoJuicioBD;
import modelo.TipoJuicioMD;
import vista.V_Servicios;

public class C_Servicio {

    public static V_Servicios vistaservicios;
    private final ServicioBD bdservicios = new ServicioBD();
    SimpleDateFormat fe = new SimpleDateFormat("yyyy-MM-dd");

    public C_Servicio(V_Servicios vistaservicios) {
        this.vistaservicios = vistaservicios;
        lista();
        GenerarCodServicio();
        vistaservicios.setVisible(true);
        vistaservicios.getBtnguardarp().setEnabled(false);
        vistaservicios.getBtnmodificar().setEnabled(false);
        vistaservicios.getCmbConsultorio().setModel(bdservicios.Consultorio());
        vistaservicios.getCbtipojuicio().setModel(bdservicios.TipoJuicio());
        vistaservicios.getBtnguardarp().addActionListener(x -> guardar());
        vistaservicios.getBtnmodificar().addActionListener(x -> modificar());
        vistaservicios.getBtneliminar().addActionListener(x -> eliminar());
        vistaservicios.getBtnnuevo().addActionListener(x -> nuevo());
        vistaservicios.getTxtBuscarJuicio().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarServicio();
            }
        });
        vistaservicios.getTableServicio().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });

    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaservicios.getTableServicio().getModel();
        List<ServicioMD> lista = bdservicios.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vistaservicios.getTableServicio().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        ConsultorioBD bdconsultorio = new ConsultorioBD();
        TipoJuicioBD bdjuicio = new TipoJuicioBD();
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            List<ConsultorioMD> listajuicio = bdconsultorio.buscardatos(lista.get(i).getConsultorio());
            List<TipoJuicioMD> listaConsultorio = bdjuicio.buscardatosporcodigo(lista.get(i).getTipo());
            vistaservicios.getTableServicio().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistaservicios.getTableServicio().setValueAt(lista.get(i).getCed_Cliente(), i, 1);
            vistaservicios.getTableServicio().setValueAt(listajuicio.get(0).getNombre(), i, 2);
            vistaservicios.getTableServicio().setValueAt(lista.get(i).getFecha(), i, 3);
            vistaservicios.getTableServicio().setValueAt(listaConsultorio.get(0).getNombre(), i, 4);
            vistaservicios.getTableServicio().setValueAt(lista.get(i).getEstado(), i, 5);

        }
    }

    public void guardar() {
        ConsultorioBD bdconsultorio = new ConsultorioBD();
        TipoJuicioBD bdjuicio = new TipoJuicioBD();
        String nombrerol = vistaservicios.getCmbConsultorio().getSelectedItem().toString();
        String nombretipojuicio = vistaservicios.getCbtipojuicio().getSelectedItem().toString();
        String codrol = "";
        String codtipojuicio = "";
        List<TipoJuicioMD> listajuicio = bdjuicio.mostrardatos();
        for (int i = 0; i < listajuicio.size(); i++) {

            if (nombretipojuicio.equals(listajuicio.get(i).getNombre())) {
                codtipojuicio = listajuicio.get(i).getCodigo();
            }
        }

        List<ConsultorioMD> listaconsultorio = bdconsultorio.mostrardatos();
        for (int i = 0; i < listaconsultorio.size(); i++) {

            if (nombrerol.equals(listaconsultorio.get(i).getNombre())) {
                codrol = listaconsultorio.get(i).getCodigo();
            }
        }
        bdservicios.setCodigo(vistaservicios.getLabelCodServicio().getText());
        bdservicios.setCed_Cliente(vistaservicios.getTxtBuscarcliente().getText());
        bdservicios.setTipo(codtipojuicio);
        bdservicios.setFecha(fe.format(vistaservicios.getTxtFecha().getDate()));
        bdservicios.setConsultorio(codrol);
        bdservicios.setEstado(vistaservicios.getCmbEstadoJuicio().getSelectedItem().toString());

        if (bdservicios.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    public void Buscarcliente(String cedula) {
        if (vistaservicios.getTxtBuscarcliente().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene el campo para realizar la busqueda", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            Conectar conectar = new Conectar();
            String sql = "Select nombres,apellidos from persona\n"
                    + "Where cedula=(Select cedula from clientes Where \"cedula\"='" + cedula + "')";
            ResultSet rs = conectar.query(sql);
            try {
                while (rs.next()) {
                    vistaservicios.getLabelnombrescliente().setText(rs.getString("nombres") + " " + rs.getString("apellidos"));

                }
            } catch (SQLException ex) {
                Logger.getLogger(C_Servicio.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERROR: " + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void modificar() {
        RolBD bdrol = new RolBD();
        TipoJuicioBD bdjuicio = new TipoJuicioBD();
        String nombrerol = vistaservicios.getCmbConsultorio().getSelectedItem().toString();
        String nombretipojuicio = vistaservicios.getCbtipojuicio().getSelectedItem().toString();
        String codrol = "";
        String codtipojuicio = "";
        List<TipoJuicioMD> listajuicio = bdjuicio.mostrardatos();
        for (int i = 0; i < listajuicio.size(); i++) {

            if (nombretipojuicio.equals(listajuicio.get(i).getNombre())) {
                codtipojuicio = listajuicio.get(i).getCodigo();
            }
        }

        List<RolMD> listarol = bdrol.mostrardatos();
        for (int i = 0; i < listarol.size(); i++) {

            if (nombrerol.equals(listarol.get(i).getNombre())) {
                codrol = listarol.get(i).getCodigo();
            }
        }
        bdservicios.setCodigo(vistaservicios.getLabelCodServicio().getText());
        bdservicios.setCed_Cliente(vistaservicios.getTxtBuscarcliente().getText());
        bdservicios.setTipo(codtipojuicio);
        bdservicios.setFecha(fe.format(vistaservicios.getTxtFecha().getDate()));
        bdservicios.setConsultorio(codrol);
        bdservicios.setEstado(vistaservicios.getCmbEstadoJuicio().getSelectedItem().toString());

        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdservicios.modificar(vistaservicios.getLabelCodServicio().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {
        vistaservicios.getBtnguardarp().setEnabled(false);
        vistaservicios.getBtnmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaservicios.getTableServicio().getModel();
        String cedula = (String) modelo.getValueAt(vistaservicios.getTableServicio().getSelectedRow(), 0);
        List<ServicioMD> lista = bdservicios.obtenerdatos(cedula);
        bdservicios.setCodigo(lista.get(0).getCodigo());
        vistaservicios.getLabelCodServicio().setText(bdservicios.getCodigo());
        bdservicios.setCed_Cliente(lista.get(0).getCed_Cliente());
        vistaservicios.getTxtBuscarcliente().setText(bdservicios.getCed_Cliente());
        bdservicios.setFecha(lista.get(0).getFecha());
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = null;
        try {
            fecha = format.parse(bdservicios.getFecha());
            vistaservicios.getTxtFecha().setDate(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No existe fecha de nacimiento en esta persona", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, e);
        }
        bdservicios.setEstado(lista.get(0).getEstado());
        vistaservicios.getCmbEstadoJuicio().setSelectedItem(bdservicios.getEstado());
    }

    public void GenerarCodServicio() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistaservicios.getLabelCodServicio().setText("SRV" + buffer.toString());
    }

    public void eliminar() {
        bdservicios.setCodigo(vistaservicios.getLabelCodServicio().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdservicios.eliminar(vistaservicios.getLabelCodServicio().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        vistaservicios.getTxtBuscarcliente().setText("");
        vistaservicios.getBtnguardarp().setEnabled(true);
        vistaservicios.getBtnmodificar().setEnabled(true);
        GenerarCodServicio();
    }

    public void BuscarServicio() {
        if (vistaservicios.getTxtBuscarJuicio().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vistaservicios.getTableServicio().getModel();

            List<ServicioMD> lista = bdservicios.buscardatos(vistaservicios.getTxtBuscarJuicio().getText());
            int columnas = modelo.getColumnCount();

            for (int j = vistaservicios.getTableServicio().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }
            ConsultorioBD bdconsultorio = new ConsultorioBD();
            TipoJuicioBD bdjuicio = new TipoJuicioBD();

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                modelo.addRow(new Object[columnas]);
                List<ConsultorioMD> listajuicio = bdconsultorio.buscardatos(lista.get(i).getConsultorio());
                List<TipoJuicioMD> listaConsultorio = bdjuicio.buscardatosporcodigo(lista.get(i).getTipo());
                vistaservicios.getTableServicio().setValueAt(lista.get(i).getCodigo(), i, 0);
                vistaservicios.getTableServicio().setValueAt(lista.get(i).getCed_Cliente(), i, 1);
                vistaservicios.getTableServicio().setValueAt(listajuicio.get(0).getNombre(), i, 2);
                vistaservicios.getTableServicio().setValueAt(lista.get(i).getFecha(), i, 3);
                vistaservicios.getTableServicio().setValueAt(listaConsultorio.get(0).getNombre(), i, 4);
                vistaservicios.getTableServicio().setValueAt(lista.get(i).getEstado(), i, 5);
            }
        }
    }
}
