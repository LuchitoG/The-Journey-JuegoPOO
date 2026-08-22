package controlador;

import entidades.Heroe;
import vista.VistaJuego;
import vista.VistaPrincipal;

public class ControladorJuego {

    private VistaJuego vistaJuego;
    private ControladorTeclado teclado;
    private Heroe jugador;

    public ControladorJuego() {
        // this.jugador = new Heroe("Carlos", 5.0, 5, 5, 10.0f, 10.0f, 10, 10, "jose",
        // // 250, 5); ejemplo de creación de un personaje
        this.jugador = new Heroe("Carlos", 5, 10, 10, 1, 0.0f, 0.0f, 40, 40, 10, 6);
        this.teclado = new ControladorTeclado();

        this.vistaJuego = new VistaJuego(jugador, teclado);

        VistaPrincipal.setPanelContenedor(vistaJuego);

        vistaJuego.requestFocusInWindow();
    }
}
