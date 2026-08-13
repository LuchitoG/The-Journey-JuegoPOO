package controlador;

import vista.VistaPrincipal;

public class ControladorVistaPrincipal {

    public ControladorVistaPrincipal() {

        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        vistaPrincipal.setVisible(true);

    // esto esta aca temporal porque no hay menu principal todavia pero cuando lo haya esto se mueve al controlador del menu principal
        new ControladorJuego(); 
    }
}
