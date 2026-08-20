package controlador;

import entidades.Heroe;
import entidades.Personaje;
import vista.VistaJuego;
import vista.VistaPrincipal;

public class ControladorJuego {

    private VistaJuego vistaJuego;
    private ControladorTeclado teclado;
    private Personaje jugador;

    public ControladorJuego() {
        this.jugador = new Heroe(100, 5.0, 5, 5, 10.0f, 10.0f, 10, 10, "jose", 250, 5); // ejemplo de creación de un
                                                                                        // personaje

        this.teclado = new ControladorTeclado();

        this.vistaJuego = new VistaJuego(jugador, teclado);

        VistaPrincipal.setPanelContenedor(vistaJuego);

        vistaJuego.requestFocusInWindow();
    }
}
