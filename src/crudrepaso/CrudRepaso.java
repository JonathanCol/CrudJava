
package crudrepaso;

import Controlador.ControladorPrincipal;
import Controlador.ControladorUsuario;
import Modelo.ConexionBD;
import Modelo.ConsultaUsuario;
import Modelo.Usuario;
import Vista.VistaP;
import Vista.VistaU;

public class CrudRepaso {
    public static void main(String[] args) {
        Usuario usu = new Usuario();
        ConsultaUsuario usuC = new ConsultaUsuario();
        VistaU frmU = new VistaU();
        ControladorUsuario ctrlUsu = new ControladorUsuario(usu, frmU, usuC);
        VistaP frmPri = new VistaP();
        ControladorPrincipal ctrlPri = new ControladorPrincipal(frmU, frmPri);
        ctrlPri.iniciar();
        frmPri.setVisible(true);

    }
    
}
