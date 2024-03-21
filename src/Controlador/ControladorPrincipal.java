
package Controlador;

import Vista.VistaP;
import Vista.VistaU;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorPrincipal implements ActionListener {
    private VistaU frmUsu;
    private VistaP frmPri;
    
    public ControladorPrincipal(VistaU frmUsu, VistaP frmPri){
        this.frmPri = frmPri;
        this.frmUsu = frmUsu;
        this.frmPri.menu_usuario.addActionListener(this);
        this.frmPri.menu_salir.addActionListener(this);
    }
    
    public void iniciar(){
        frmUsu.setTitle("Usuarios");
        frmPri.setTitle("Principal");
        frmUsu.setLocationRelativeTo(null);
        frmPri.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == frmPri.menu_usuario){
           frmUsu.setVisible(true);
           frmPri.dispose();
       }
       if(e.getSource() == frmPri.menu_salir){
           System.exit(0);
       }
    }
    
}
