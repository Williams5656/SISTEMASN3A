package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultorioBD;
import modelo.ConsultorioMD;
import vista.V_Consultorio;

public class C_Consultorio {

    public static V_Consultorio vistaconsultorio;
    private final ConsultorioBD bdconsultorio = new ConsultorioBD();

    public C_Consultorio(V_Consultorio vista) {
        C_Consultorio.vistaconsultorio = vista;
        vista.setVisible(true);
        vista.getBtnguardarp().setEnabled(false);
        vista.getBtnmodificar().setEnabled(false);
        lista();
        GenerarCodConsultorio();

        vista.getBtn_CargarFondo().addActionListener(x -> obtieneImagen());
        vista.getBtnguardarp().addActionListener(x -> guardar());
        vista.getBtnmodificar().addActionListener(x -> modificar());
        vista.getBtneliminar().addActionListener(x -> eliminar());
        vista.getBtnnuevo().addActionListener(x -> nuevo());

        vista.getTableConsultorio().addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtBuscarConsultorioFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtBuscarConsultorioFocusLost(evt);
            }
        });
        vista.getTxtBuscarConsultorio().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarConsultorio();
            }
        });
        vista.getTableConsultorio().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
    }

    private void obtieneImagen() {
        vistaconsultorio.getLabelFondo().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vistaconsultorio.getLabelFondo().getWidth(), vistaconsultorio.getLabelFondo().getHeight(), Image.SCALE_DEFAULT);
                vistaconsultorio.getLabelFondo().setIcon(new ImageIcon(icono));
                vistaconsultorio.getLabelFondo().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(C_Consultorio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaconsultorio.getTableConsultorio().getModel();
        List<ConsultorioMD> lista = bdconsultorio.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vistaconsultorio.getTableConsultorio().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistaconsultorio.getTableConsultorio().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistaconsultorio.getTableConsultorio().setValueAt(lista.get(i).getNombre(), i, 1);
            vistaconsultorio.getTableConsultorio().setValueAt(lista.get(i).getDireccion(), i, 2);
            vistaconsultorio.getTableConsultorio().setValueAt(lista.get(i).getTelefono(), i, 3);
            vistaconsultorio.getTableConsultorio().setValueAt(lista.get(i).getLema(), i, 4);

        }
    }

    public void guardar() {
        bdconsultorio.setCodigo(vistaconsultorio.getLabelCodigoConsultorio().getText());
        bdconsultorio.setNombre(vistaconsultorio.getTxtNombreConsultorio().getText());
        bdconsultorio.setDireccion(vistaconsultorio.getTxtDireccionConsultorio().getText());
        bdconsultorio.setTelefono(vistaconsultorio.getTxttelefonoConsultorio().getText());
        ImageIcon ic = (ImageIcon) vistaconsultorio.getLabelFondo().getIcon();
        bdconsultorio.setFondo(ic.getImage());
        bdconsultorio.setLema(vistaconsultorio.getTxtLema().getText());

        if (bdconsultorio.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    public void modificar() {
        bdconsultorio.setCodigo(vistaconsultorio.getLabelCodigoConsultorio().getText());
        bdconsultorio.setNombre(vistaconsultorio.getTxtNombreConsultorio().getText());
        bdconsultorio.setDireccion(vistaconsultorio.getTxtDireccionConsultorio().getText());
        bdconsultorio.setTelefono(vistaconsultorio.getTxttelefonoConsultorio().getText());
        ImageIcon ic = (ImageIcon) vistaconsultorio.getLabelFondo().getIcon();
        bdconsultorio.setFondo(ic.getImage());
        bdconsultorio.setLema(vistaconsultorio.getTxtLema().getText());

        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdconsultorio.modificar(vistaconsultorio.getLabelCodigoConsultorio().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {
        vistaconsultorio.getBtnguardarp().setEnabled(false);
        vistaconsultorio.getBtnmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaconsultorio.getTableConsultorio().getModel();
        String cedula = (String) modelo.getValueAt(vistaconsultorio.getTableConsultorio().getSelectedRow(), 0);
        List<ConsultorioMD> lista = bdconsultorio.obtenerdatos(cedula);
        bdconsultorio.setCodigo(lista.get(0).getCodigo());
        vistaconsultorio.getLabelCodigoConsultorio().setText(bdconsultorio.getCodigo());
        bdconsultorio.setNombre(lista.get(0).getNombre());
        vistaconsultorio.getTxtNombreConsultorio().setText(bdconsultorio.getNombre());
        bdconsultorio.setDireccion(lista.get(0).getDireccion());
        vistaconsultorio.getTxtDireccionConsultorio().setText(bdconsultorio.getDireccion());
        bdconsultorio.setTelefono(lista.get(0).getTelefono());
        vistaconsultorio.getTxttelefonoConsultorio().setText(bdconsultorio.getTelefono());
        bdconsultorio.setLema(lista.get(0).getLema());
        vistaconsultorio.getTxtLema().setText(bdconsultorio.getLema());
        Image img = lista.get(0).getFondo();
        if (img != null) {
            Image newimg = img.getScaledInstance(vistaconsultorio.getLabelFondo().getWidth(), vistaconsultorio.getLabelFondo().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vistaconsultorio.getLabelFondo().setIcon(icon);
        } else {
            vistaconsultorio.getLabelFondo().setIcon(null);
        }
    }

    public void GenerarCodConsultorio() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistaconsultorio.getLabelCodigoConsultorio().setText("CSLT" + buffer.toString());
    }

    public void eliminar() {
        bdconsultorio.setCodigo(vistaconsultorio.getLabelCodigoConsultorio().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdconsultorio.Eliminar(vistaconsultorio.getLabelCodigoConsultorio().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        GenerarCodConsultorio();
        vistaconsultorio.getTxtNombreConsultorio().setText("");
        vistaconsultorio.getBtnguardarp().setEnabled(true);
        vistaconsultorio.getBtnmodificar().setEnabled(true);
    }

    private void TxtBuscarConsultorioFocusGained(java.awt.event.FocusEvent evt) {
        vistaconsultorio.getTxtBuscarConsultorio().setText("");
        vistaconsultorio.getTxtBuscarConsultorio().setForeground(Color.BLACK);

    }

    private void TxtBuscarConsultorioFocusLost(java.awt.event.FocusEvent evt) {
        if (vistaconsultorio.getTxtBuscarConsultorio().getText().isEmpty()) {
            vistaconsultorio.getTxtBuscarConsultorio().setText("Ingrese el nombre del consultorio");
            vistaconsultorio.getTxtBuscarConsultorio().setForeground(Color.GRAY);
        }
    }

    public void BuscarConsultorio() {
        if (vistaconsultorio.getTxtBuscarConsultorio().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vistaconsultorio.getTableConsultorio().getModel();

            List<ConsultorioMD> lista = bdconsultorio.buscardatos(vistaconsultorio.getTxtBuscarConsultorio().getText());
            int columnas = modelo.getColumnCount();

            for (int j = vistaconsultorio.getTableConsultorio().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);

                vistaconsultorio.getTableConsultorio().setValueAt(lista.get(i).getCodigo(), i, 0);
                vistaconsultorio.getTableConsultorio().setValueAt(lista.get(i).getNombre(), i, 1);
                vistaconsultorio.getTableConsultorio().setValueAt(lista.get(i).getDireccion(), i, 2);
                vistaconsultorio.getTableConsultorio().setValueAt(lista.get(i).getTelefono(), i, 3);
                vistaconsultorio.getTableConsultorio().setValueAt(lista.get(i).getLema(), i, 4);
            }
        }
    }
}
