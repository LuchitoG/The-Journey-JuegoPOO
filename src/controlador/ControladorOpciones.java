package controlador;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import vista.PanelOpciones;

public class ControladorOpciones {

    private PanelOpciones panelOpciones;
    public JFrame framePrincipal;
    
    public ControladorOpciones(PanelOpciones panelOpciones) {

        this.panelOpciones = panelOpciones;
        
        // todo esto es para crear la ventana
        framePrincipal = (JFrame) SwingUtilities.getWindowAncestor(this.panelOpciones);
        JDialog dialogo = new JDialog(framePrincipal , "Opciones", true);
        dialogo.setSize(1250, 800);

        dialogo.add(panelOpciones);
        dialogo.setLocationRelativeTo(null);
        dialogo.setResizable(false);
        dialogo.setVisible(true);
    }

}
