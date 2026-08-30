package controlador;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import modelo.ModeloOpciones;
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
        

        // Cuando abro las opciones se pone el valor guradado en el modeloOpciones
        this.panelOpciones.getSliderVolumen().setValue(ModeloOpciones.getInstance().getVolumen());

        // Cuando cambia el volumen actualiza modeloOpciones
        this.panelOpciones.getSliderVolumen().addChangeListener(e -> {
            ModeloOpciones.getInstance().setVolumen(this.panelOpciones.getSliderVolumen().getValue());
        });





        dialogo.setVisible(true); // ESTO VA A LO ULTIMO SI O SI
    }

}
