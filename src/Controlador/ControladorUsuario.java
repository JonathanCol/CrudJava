package Controlador;

import Modelo.ConsultaUsuario;
import Modelo.Usuario;
import Vista.VistaU;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorUsuario implements ActionListener {

    private Usuario usu;
    private VistaU frmUsu;
    private ConsultaUsuario usuC;

    public ControladorUsuario(Usuario usu, VistaU frmUsu, ConsultaUsuario usuC) {
        this.usu = usu;
        this.frmUsu = frmUsu;
        this.usuC = usuC;
        this.frmUsu.btn_create.addActionListener(this);
        this.frmUsu.btn_clean.addActionListener(this);
        this.frmUsu.btn_edit.addActionListener(this);
        this.frmUsu.btn_search.addActionListener(this);
        this.frmUsu.btn_delete.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Boton Crear
        if (e.getSource() == frmUsu.btn_create) {
            usu.setNombre(frmUsu.txt_nombre.getText());
            usu.setCorreo(frmUsu.txt_correo.getText());
            usu.setTelefono(Integer.parseInt(frmUsu.txt_telefono.getText()));
            if (usuC.crear(usu)) {
                JOptionPane.showMessageDialog(null, "Usuario creado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear usuario");
                limpiar();
            }
        }
        // Boton Editar
        if (e.getSource() == frmUsu.btn_edit) {
            usu.setId(Integer.parseInt(frmUsu.txt_id.getText()));
            usu.setNombre(frmUsu.txt_nombre.getText());
            usu.setCorreo(frmUsu.txt_correo.getText());
            usu.setTelefono(Integer.parseInt(frmUsu.txt_telefono.getText()));
            if (usuC.editar(usu)) {
                JOptionPane.showMessageDialog(null, "Usuario Editado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al editar usuario");
                limpiar();
            }

        }

        //Boton Buscar
        if (e.getSource() == frmUsu.btn_search) {
            usu.setId(Integer.parseInt(frmUsu.txt_id.getText()));
            if (usuC.buscar(usu)) {
                frmUsu.txt_id.setText(String.valueOf(usu.getId()));
                frmUsu.txt_nombre.setText(usu.getNombre());
                frmUsu.txt_correo.setText(usu.getCorreo());
                frmUsu.txt_telefono.setText(String.valueOf(usu.getTelefono()));
            } else {
                JOptionPane.showMessageDialog(null, "Error al buscar usuario");
                limpiar();
            }
        }

        //Boton Eliminar 
        if (e.getSource() == frmUsu.btn_delete) {
            usu.setId(Integer.parseInt(frmUsu.txt_id.getText()));
            if (usuC.eliminar(usu)) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario");
                limpiar();
            }
        }
        // Boton Limpiar
        if (e.getSource() == frmUsu.btn_clean) {
            limpiar();
        }
    
    

}
        public void limpiar() {
        frmUsu.txt_id.setText(null);
        frmUsu.txt_nombre.setText(null);
        frmUsu.txt_correo.setText(null);
        frmUsu.txt_telefono.setText(null);
    }
}
