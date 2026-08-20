package controlador;

import vista.PanelMenu;
import vista.VistaPrincipal;

public class ControladorMenu {
    
    private PanelMenu panelMenu;

    public ControladorMenu(PanelMenu panelMenu) {
        this.panelMenu = panelMenu;
        this.panelMenu.getBotonJugar().addActionListener(e -> new ControladorJuego());
        VistaPrincipal.setPanelContenedor(panelMenu);
    }

}
