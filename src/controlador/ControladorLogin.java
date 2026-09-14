package controlador;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import vista.PanelJuego;
import vista.PanelLogin;

public class ControladorLogin {

    private PanelLogin panelLogin;
    public JFrame framePrincipal;

    private PanelJuego paneljuego;
    private ControladorJuego controladorJuego;
    
    public ControladorLogin(PanelLogin panelLogin) {

        this.panelLogin = panelLogin;
        
        // todo esto es para crear la ventana
        framePrincipal = (JFrame) SwingUtilities.getWindowAncestor(this.panelLogin);
        JDialog dialogo = new JDialog(framePrincipal , "Login", true);
        dialogo.setSize(500, 320);

        dialogo.add(panelLogin);
        dialogo.setLocationRelativeTo(null);
        dialogo.setResizable(false);


        this.panelLogin.getBotonJugar().addActionListener(e -> {
            System.out.println("Boton jugar");
            dialogo.dispose();
            
            paneljuego = new PanelJuego();
            controladorJuego = new ControladorJuego(paneljuego);
            //new ControladorJuego();
        }
        );


        dialogo.setVisible(true); // si o si va a lo ultimo
        
        
    }
}
