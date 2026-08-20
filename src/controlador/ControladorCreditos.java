package controlador;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import vista.PanelCreditos;

public class ControladorCreditos {

    private PanelCreditos panelCreditos;
    public JFrame framePrincipal;
    
    public ControladorCreditos(PanelCreditos panelCreditos) {

        this.panelCreditos = panelCreditos;
        
        // todo esto es para crear la ventana
        framePrincipal = (JFrame) SwingUtilities.getWindowAncestor(this.panelCreditos);
        JDialog dialogo = new JDialog(framePrincipal , "Creditos", true);
        dialogo.setSize(1250, 800);

        dialogo.add(panelCreditos);
        dialogo.setLocationRelativeTo(null);
        dialogo.setResizable(false);
        dialogo.setVisible(true);
    }
}
