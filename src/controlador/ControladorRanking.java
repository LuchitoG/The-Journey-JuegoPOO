package controlador;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import vista.PanelRanking;

public class ControladorRanking {

    private PanelRanking panelRanking;
    public JFrame framePrincipal;

    public ControladorRanking(PanelRanking panelRanking){ 

        this.panelRanking = panelRanking;
       
        // todo esto es para crear la ventana
        framePrincipal = (JFrame) SwingUtilities.getWindowAncestor(this.panelRanking);
        JDialog dialogo = new JDialog(framePrincipal , "Ranking", true);
        dialogo.setSize(1250, 800);

        dialogo.add(panelRanking);
        dialogo.setLocationRelativeTo(null);
        dialogo.setResizable(false);
        dialogo.setVisible(true);
    }

}
