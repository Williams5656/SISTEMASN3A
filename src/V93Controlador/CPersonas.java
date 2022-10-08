package V93Controlador;

import V93Vista.*;
import javax.swing.table.DefaultTableModel;
import V93Modelo.*;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class CPersonas {

    public static VistaPersona VistaP;

    private PersonaBD bdpersona = new PersonaBD();
    Eventos evts = new Eventos();

    public CPersonas(VistaPersona VistaP) {
        this.VistaP = VistaP;
        VistaP.setVisible(true);
        VistaP.setLocationRelativeTo(null);
        lista();
//        encontrar();
        VistaP.getBtnGuardarPersona().addActionListener(x -> guardar());
        VistaP.getBtnModificarPersona().addActionListener(e -> modificar());
        VistaP.getBtnNuevoPersona().addActionListener(e -> nuevo());
        VistaP.getBtnEliminarPersona().addActionListener(e -> eliminar());
        VistaP.getBtnImprimirPersona().addActionListener(e -> ImprimirPersona());

        VistaP.getBtnFoto().addActionListener(e -> obtieneImagen());
        VistaP.getBtnbuscarp().addActionListener(e -> buscar());
        VistaP.getTablePersona().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
        VistaP.getTxtCedulaPersona().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaPersonaKeyTyped(evt);
            }

        });
        VistaP.getTxtNombrePersona().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombrePersonaKeyTyped(evt);
            }

        });
        VistaP.getTxtCiudadPersona().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiudadPersonaKeyTyped(evt);
            }

        });
        VistaP.getTxtCelularPersona().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularPersonaKeyTyped(evt);
            }

        });
        VistaP.getBtnGuardarPersona().setEnabled(false);
        VistaP.getBtnModificarPersona().setEnabled(false);
        VistaP.getBtnEliminarPersona().setEnabled(false);

        VistaP.getTxtCedulaPersona().setEnabled(false);
        VistaP.getTxtNombrePersona().setEnabled(false);
        VistaP.getTxtDireccionPersona().setEnabled(false);
        VistaP.getTxtCelularPersona().setEnabled(false);
        VistaP.getTxtFechaNacimientoPersona().setEnabled(false);
        VistaP.getTxtCiudadPersona().setEnabled(false);
        VistaP.getBtnFoto().setEnabled(false);

    }

    private void txtCedulaPersonaKeyTyped(java.awt.event.KeyEvent evt) {
        evts.numberKeyPress(evt);
    }

    private void txtNombrePersonaKeyTyped(java.awt.event.KeyEvent evt) {
        evts.textKeyPress(evt);
    }

    private void txtCiudadPersonaKeyTyped(java.awt.event.KeyEvent evt) {
        evts.textKeyPress(evt);
    }

    private void txtCelularPersonaKeyTyped(java.awt.event.KeyEvent evt) {
        evts.numberKeyPress(evt);
    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaP.getTablePersona().getModel();
        List<PersonaMb> lista = bdpersona.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = VistaP.getTablePersona().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            VistaP.getTablePersona().setValueAt(lista.get(i).getCedula(), i, 0);
            VistaP.getTablePersona().setValueAt(lista.get(i).getNombre(), i, 1);
            VistaP.getTablePersona().setValueAt(lista.get(i).getDireccion(), i, 2);
            VistaP.getTablePersona().setValueAt(lista.get(i).getFecha_nacimiento(), i, 3);
            VistaP.getTablePersona().setValueAt(lista.get(i).getCiudad(), i, 4);
            VistaP.getTablePersona().setValueAt(lista.get(i).getCelular(), i, 5);

        }
    }

    private void ImprimirPersona() {
        Conectar con = new Conectar();
        try {

            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/persona.jasper"));

            Map<String, Object> map = new HashMap<String, Object>();

            JasperPrint ja = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
            JasperViewer jv = new JasperViewer(ja, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Cprincipal.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void guardar() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        bdpersona.setCedula(VistaP.getTxtCedulaPersona().getText());
        bdpersona.setNombre(VistaP.getTxtNombrePersona().getText());
        bdpersona.setDireccion(VistaP.getTxtDireccionPersona().getText());
        bdpersona.setFecha_nacimiento(f.format(VistaP.getTxtFechaNacimientoPersona().getDate()));
        bdpersona.setCiudad(VistaP.getTxtCiudadPersona().getText());
        bdpersona.setCelular(VistaP.getTxtCelularPersona().getText());

        ImageIcon ic = (ImageIcon) VistaP.getLbFoto().getIcon();
        bdpersona.setFoto(ic.getImage());

        if (bdpersona.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }
        VistaP.getTxtCedulaPersona().setText("");
        VistaP.getTxtNombrePersona().setText("");
        VistaP.getTxtDireccionPersona().setText("");
        VistaP.getTxtFechaNacimientoPersona().setCalendar(null);
        VistaP.getTxtCiudadPersona().setText("");
        VistaP.getTxtCelularPersona().setText("");
        VistaP.getTxtbuscarp().setText("");

    }

    private void obtieneImagen() {
        VistaP.getLbFoto().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(VistaP.getLbFoto().getWidth(), VistaP.getLbFoto().getHeight(), Image.SCALE_DEFAULT);
                VistaP.getLbFoto().setIcon(new ImageIcon(icono));
                VistaP.getLbFoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(CPersonas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void buscar() {
        if (VistaP.getTxtbuscarp().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) VistaP.getTablePersona().getModel();
            List<PersonaMb> lista = bdpersona.obtenerdatos(VistaP.getTxtbuscarp().getText());
            int columnas = modelo.getColumnCount();

            for (int j = VistaP.getTablePersona().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                VistaP.getTablePersona().setValueAt(lista.get(i).getCedula(), i, 0);
                VistaP.getTablePersona().setValueAt(lista.get(i).getNombre(), i, 1);
                VistaP.getTablePersona().setValueAt(lista.get(i).getDireccion(), i, 2);
                VistaP.getTablePersona().setValueAt(lista.get(i).getFecha_nacimiento(), i, 3);
                VistaP.getTablePersona().setValueAt(lista.get(i).getCiudad(), i, 4);
                VistaP.getTablePersona().setValueAt(lista.get(i).getCelular(), i, 5);
            }
        }

    }

    public void modificar() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        bdpersona.setCedula(VistaP.getTxtCedulaPersona().getText());
        bdpersona.setNombre(VistaP.getTxtNombrePersona().getText());
        bdpersona.setDireccion(VistaP.getTxtDireccionPersona().getText());
        bdpersona.setFecha_nacimiento(f.format(VistaP.getTxtFechaNacimientoPersona().getDate()));
        bdpersona.setCiudad(VistaP.getTxtCiudadPersona().getText());
        bdpersona.setCelular(VistaP.getTxtCelularPersona().getText());
        ImageIcon ic = (ImageIcon) VistaP.getLbFoto().getIcon();
        bdpersona.setFoto(ic.getImage());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdpersona.modificar(VistaP.getTxtCedulaPersona().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {
        VistaP.getBtnGuardarPersona().setEnabled(false);
        VistaP.getBtnModificarPersona().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaP.getTablePersona().getModel();
        String cedula = (String) modelo.getValueAt(VistaP.getTablePersona().getSelectedRow(), 0);
        List<PersonaMb> lista = bdpersona.obtenerdatos(cedula);
        bdpersona.setCedula(lista.get(0).getCedula());
        VistaP.getTxtCedulaPersona().setText(bdpersona.getCedula());
        bdpersona.setNombre(lista.get(0).getNombre());
        VistaP.getTxtNombrePersona().setText(bdpersona.getNombre());
        bdpersona.setDireccion(lista.get(0).getDireccion());
        VistaP.getTxtDireccionPersona().setText(bdpersona.getDireccion());
        bdpersona.setCiudad(lista.get(0).getCiudad());
        VistaP.getTxtCiudadPersona().setText(bdpersona.getCiudad());
        bdpersona.setCelular(lista.get(0).getCelular());
        VistaP.getTxtCelularPersona().setText(bdpersona.getCelular());
        bdpersona.setFecha_nacimiento(lista.get(0).getFecha_nacimiento());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = format.parse(bdpersona.getFecha_nacimiento());
            VistaP.getTxtFechaNacimientoPersona().setDate(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        Image img = lista.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(VistaP.getLbFoto().getWidth(), VistaP.getLbFoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            VistaP.getLbFoto().setIcon(icon);
        } else {
            VistaP.getLbFoto().setIcon(null);
        }

    }

    public void eliminar() {
        bdpersona.setCedula(VistaP.getTxtCedulaPersona().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdpersona.eliminar(VistaP.getTxtCedulaPersona().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        VistaP.getTxtCedulaPersona().setText("");
        VistaP.getTxtNombrePersona().setText("");
        VistaP.getTxtDireccionPersona().setText("");
        VistaP.getTxtFechaNacimientoPersona().setCalendar(null);
        VistaP.getTxtCiudadPersona().setText("");
        VistaP.getTxtCelularPersona().setText("");
        VistaP.getTxtbuscarp().setText("");

        VistaP.getBtnGuardarPersona().setEnabled(true);
        VistaP.getBtnModificarPersona().setEnabled(false);
        VistaP.getBtnEliminarPersona().setEnabled(true);

        VistaP.getTxtCedulaPersona().setEnabled(true);
        VistaP.getTxtNombrePersona().setEnabled(true);
        VistaP.getTxtDireccionPersona().setEnabled(true);
        VistaP.getTxtCelularPersona().setEnabled(true);
        VistaP.getTxtFechaNacimientoPersona().setEnabled(true);
        VistaP.getTxtCiudadPersona().setEnabled(true);
        VistaP.getBtnFoto().setEnabled(true);
    }
//    public void encontrar(){
//        
//        if(VistaP.getTxtCedulaPersona().getText().equals("")){
//            //limpiar();
//            lista();
//        }
//        else {
//
//            List<PersonaMb> lista = bdpersona.obtenerdatos(VistaP.getTxtCedulaPersona().getText()); 
//            for (int i = 0; i < lista.size(); i++)
//            {    
//                if(VistaP.getTxtCedulaPersona().getText().equals(lista.get(i).getCedula()))
//                { 
//                    JOptionPane.showMessageDialog(null, "EMPEADO REGISTRADO");
//
////                    bdEmpleado.setNombre(lista.get(0).getNombre());
////                    vista.getTxtNombre().setText(bdEmpleado.getNombre());
////
////                    bdEmpleado.setDireccion(lista.get(0).getDireccion());
////                    vista.getTxtDireccion().setText(bdEmpleado.getDireccion());
////
////                    bdEmpleado.setCelular(lista.get(0).getCelular());
////                    vista.getTxtCelular().setText(bdEmpleado.getCelular());
////
////                    bdEmpleado.setEmail(lista.get(0).getEmail());
////                    vista.getTxtEmail().setText(bdEmpleado.getEmail());
////
////                    bdEmpleado.setFechaNac(lista.get(0).getFechaNac());
////                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
////                    Date fecha = null;
////                    try {
////                        fecha = format.parse(bdEmpleado.getFechaNac());
////                        vista.getTxtCalendario().setDate(fecha);
////                    } catch (Exception e) {
////                        JOptionPane.showMessageDialog(null, e);
////                    }
////
////                    Image img = lista.get(0).getFoto();
////                    if (img != null) {
////                        Image newimg = img.getScaledInstance(vista.getLbFoto().getWidth(), vista.getLbFoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
////                        ImageIcon icon = new ImageIcon(newimg);
////                        vista.getLbFoto().setIcon(icon);
////                    } else {
////                        vista.getLbFoto().setIcon(null);
////                    }
////
////                    bdEmpleado.setEstado(lista.get(0).getEstado());
////                    vista.getCbEstado().setSelectedItem(bdEmpleado.getEstado());
////
////                    bdEmpleado.setPerfil(lista.get(0).getPerfil());
////                    vista.getCbPerfil().setSelectedItem(bdEmpleado.getPerfil());
////
////                    bdEmpleado.setCargo(lista.get(0).getCargo());
////                    vista.getCbCargo().setSelectedItem(bdEmpleado.getCargo());
//                }//Fin del if
//            }//Fin del for
//            
////            List<PersonaMD> listapersona = bdPersona.obtenerDatos(vista.getTxtCedula().getText()); 
////            for (int i = 0; i < listapersona.size(); i++)
////            {    
////                if(vista.getTxtCedula().getText().equals(listapersona.get(i).getCedula()))
////                { 
////                    bdPersona.setNombre(listapersona.get(0).getNombre());
////                    vista.getTxtNombre().setText(bdPersona.getNombre());
////
////                    bdPersona.setDireccion(listapersona.get(0).getDireccion());
////                    vista.getTxtDireccion().setText(bdPersona.getDireccion());
////
////                    bdPersona.setCelular(listapersona.get(0).getCelular());
////                    vista.getTxtCelular().setText(bdPersona.getCelular());
////
////                    bdPersona.setEmail(listapersona.get(0).getEmail());
////                    vista.getTxtEmail().setText(bdPersona.getEmail());
////
////                    bdPersona.setFechaNac(listapersona.get(0).getFechaNac());
////                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
////                    Date fecha = null;
////                    try {
////                        fecha = format.parse(bdPersona.getFechaNac());
////                        vista.getTxtCalendario().setDate(fecha);
////                    } catch (Exception e) {
////                        JOptionPane.showMessageDialog(null, e);
////                    }
////
////                    Image img = listapersona.get(0).getFoto();
////                    if (img != null) {
////                        Image newimg = img.getScaledInstance(vista.getLbFoto().getWidth(), vista.getLbFoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
////                        ImageIcon icon = new ImageIcon(newimg);
////                        vista.getLbFoto().setIcon(icon);
////                    } else {
////                        vista.getLbFoto().setIcon(null);
////                    }
////                }
////            }
////        }//Fin del else
//   }//Fin del metodo encontrar
//
//    }
}
