package controlador;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.V_Usuario;

public class C_Usuario {

    boolean mostrar = false;
    public static V_Usuario vistausuario;
    public UsuarioBD bdusuario = new UsuarioBD();
    public RolBD bdrol = new RolBD();
    public PersonaBD bdpersona = new PersonaBD();
    String NombreRol = "";

    public C_Usuario(V_Usuario vistaUsuario) {
        this.vistausuario = vistaUsuario;
        vistaUsuario.setVisible(true);

        GenerarCodUsuario();
        vistaUsuario.getBtnguardarp().setEnabled(false);
        vistaUsuario.getBtnmodificar().setEnabled(false);
        vistaUsuario.getCmbRol().setModel(bdusuario.NombreROL());
        vistaUsuario.getBtnBuscarPersona().addActionListener(x -> BuscarPersona());
        vistaUsuario.getBtnguardarp().addActionListener(e -> guardar());
        vistaUsuario.getBtnmodificar().addActionListener(e -> modificar());
        vistaUsuario.getBtnnuevo().addActionListener(e -> nuevo());
        vistaUsuario.getBtneliminar().addActionListener(e -> eliminar());
        vistaUsuario.getBtnimprimir().addActionListener(e -> Imprimir());
        vistaUsuario.getTxtCedula().addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCedulaFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaFocusLost(evt);
            }
        });
        vistaUsuario.getCheckBoxEstado().addActionListener((java.awt.event.ActionEvent evt) -> {
            CheckBoxEstadoActionPerformed(evt);
        });
        vistaUsuario.getTableUsuario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
        lista();
    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistausuario.getTableUsuario().getModel();
        List<UsuarioMD> lista = bdusuario.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vistausuario.getTableUsuario().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            List<RolMD> lisarol = bdrol.buscardatosporcodigo(lista.get(i).getRol());
            vistausuario.getTableUsuario().setValueAt(lista.get(i).getCodUsuario(), i, 0);
            vistausuario.getTableUsuario().setValueAt(lista.get(i).getCedula(), i, 1);
            vistausuario.getTableUsuario().setValueAt(lista.get(i).getUsuario(), i, 2);
            vistausuario.getTableUsuario().setValueAt(lisarol.get(0).getNombre(), i, 3);
            vistausuario.getTableUsuario().setValueAt(lista.get(i).getEstado(), i, 4);

        }
    }

    public void guardar() {
        String Codroles = "";
        List<RolMD> listarol = bdrol.buscardatospornombre(vistausuario.getCmbRol().getSelectedItem().toString());
        for (int i = 0; i < listarol.size(); i++) {
            Codroles = listarol.get(i).getCodigo();

        }
        bdusuario.setCodUsuario(vistausuario.getLabelCodigoUsuario().getText());
        bdusuario.setCedula(vistausuario.getTxtCedula().getText());
        bdusuario.setUsuario(vistausuario.getTxtUsuario().getText());
        bdusuario.setClave(vistausuario.getJPassClave().getText());
        bdusuario.setRol(Codroles);
        bdusuario.setEstado(vistausuario.getLabelEstado().getText());

        if (bdusuario.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    public void modificar() {
        String Codroles = "";
        List<RolMD> listarol = bdrol.buscardatospornombre(vistausuario.getCmbRol().getSelectedItem().toString());
        for (int i = 0; i < listarol.size(); i++) {
            Codroles = listarol.get(i).getCodigo();

        }
        vistausuario.getTxtCedula().setEditable(false);
        bdusuario.setCodUsuario(vistausuario.getLabelCodigoUsuario().getText());
        bdusuario.setCedula(vistausuario.getTxtCedula().getText());
        bdusuario.setUsuario(vistausuario.getTxtUsuario().getText());
        bdusuario.setClave(vistausuario.getJPassClave().getText());
        bdusuario.setRol(Codroles);
        bdusuario.setEstado(vistausuario.getLabelEstado().getText());

        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdusuario.modificar(vistausuario.getLabelCodigoUsuario().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {
        List<UsuarioMD> listb = bdusuario.mostrardatos();
        vistausuario.getBtnguardarp().setEnabled(false);
        vistausuario.getBtnmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistausuario.getTableUsuario().getModel();
        String cedula = (String) modelo.getValueAt(vistausuario.getTableUsuario().getSelectedRow(), 0);
        List<UsuarioMD> lista = bdusuario.obtenerdatos(cedula);
        bdusuario.setCodUsuario(lista.get(0).getCodUsuario());
        vistausuario.getLabelCodigoUsuario().setText(bdusuario.getCodUsuario());
        bdusuario.setCedula(lista.get(0).getCedula());
        vistausuario.getTxtCedula().setText(bdusuario.getCedula());
        bdusuario.setUsuario(lista.get(0).getUsuario());
        vistausuario.getTxtUsuario().setText(bdusuario.getUsuario());
        bdusuario.setClave(lista.get(0).getClave());
        vistausuario.getJPassClave().setText(bdusuario.getClave());
        bdusuario.setEstado(lista.get(0).getEstado());
        vistausuario.getLabelEstado().setText(bdusuario.getEstado());
        for (int i = 0; i < listb.size(); i++) {
            List<RolMD> lisarol = bdrol.buscardatospornombre(lista.get(0).getRol());
            bdusuario.setRol(lisarol.get(0).getCodigo());
            vistausuario.getCmbRol().setSelectedItem(lisarol.get(0).getNombre());
        }
    }

    public void eliminar() {
        bdusuario.setCedula(vistausuario.getLabelCodigoUsuario().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdusuario.eliminar(vistausuario.getLabelCodigoUsuario().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        vistausuario.getTxtCedula().setText("");
        vistausuario.getTxtUsuario().setText("");
        vistausuario.getBtnguardarp().setEnabled(true);
        vistausuario.getBtnmodificar().setEnabled(false);
        GenerarCodUsuario();
    }

    private void txtCedulaFocusGained(java.awt.event.FocusEvent evt) {
        vistausuario.getTxtCedula().setText("");
        vistausuario.getTxtCedula().setForeground(Color.BLACK);

    }

    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {
        if (vistausuario.getTxtCedula().getText().isEmpty()) {
            vistausuario.getTxtCedula().setText("Ingrese el número de Cédula");
            vistausuario.getTxtCedula().setForeground(Color.GRAY);
        }
    }

    public void BuscarPersona() {
        String PersonaNombres = "";
        String PersonaApellidos = "";
        if (vistausuario.getTxtCedula().equals("")) {
            JOptionPane.showMessageDialog(null, "No deje el campo vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            List<PersonaMD> lista = bdpersona.buscardatos(vistausuario.getTxtCedula().getText());
            for (int i = 0; i < lista.size(); i++) {
                PersonaNombres = lista.get(i).getNombres();
                PersonaApellidos = lista.get(i).getApellidos();
            }
            vistausuario.getLabelNombresPersona().setText(PersonaNombres + " " + PersonaApellidos);
        }
    }

    private void CheckBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {
        if (mostrar) {
            vistausuario.getLabelEstado().setText("Activo");
            mostrar = false;

        } else {
            vistausuario.getLabelEstado().setText("Inactivo");
            mostrar = true;
        }
    }

    public void GenerarCodUsuario() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistausuario.getLabelCodigoUsuario().setText("USRO" + buffer.toString());
    }

    

    private void Imprimir() {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija una opcion para imprimir: \n 1. Imprimir Todo \n 2. Imprimir con un parametro \n 3.Imprimir con dos parametros"));
        try {
            switch (opcion) {
                case 1:
                    ImprimirTodo();
                    break;
                case 2:
                    ImprimirunParametro();
                    break;
                case 3:
                    ImprimirDosParametros();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No elijio una opcion correcta", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese solo números", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void ImprimirTodo() {
        Conectar con = new Conectar();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/usuario.jasper"));

            Map<String, Object> map = new HashMap<String, Object>();
            JasperPrint ja = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
            JasperViewer jv = new JasperViewer(ja, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(C_Usuario.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void ImprimirunParametro() {
        Conectar con = new Conectar();
        try {
            String cedula = JOptionPane.showInputDialog("Escriba la cedula del usuario");
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/usuario1.jasper"));

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("ucedula", cedula);

            JasperPrint ja = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
            JasperViewer jv = new JasperViewer(ja, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(C_Usuario.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void ImprimirDosParametros() {
        Conectar con = new Conectar();
        try {
            String cedula = JOptionPane.showInputDialog("Escriba la cedula del usuario");
            int nombre = Integer.parseInt(JOptionPane.showInputDialog("Escriba el nombre del usuario"));
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/usuario2.jasper"));

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("ucedula", cedula);
            map.put("nusuario", nombre);
            JasperPrint ja = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
            JasperViewer jv = new JasperViewer(ja, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(C_Usuario.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
