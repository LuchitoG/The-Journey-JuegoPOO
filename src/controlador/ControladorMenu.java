package controlador;

import vista.PanelMenu;
import vista.VistaPrincipal;

public class ControladorMenu {
    
    private PanelMenu panelMenu;

    public ControladorMenu(PanelMenu panelMenu) {
        this.panelMenu = panelMenu;
        VistaPrincipal.setPanelContenedor(panelMenu);
    }

}
