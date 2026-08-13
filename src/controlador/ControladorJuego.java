package controlador;

import entidades.Personaje;
import vista.VistaJuego;
import vista.VistaPrincipal;

public class ControladorJuego {

    private VistaJuego vistaJuego;
    private ControladorTeclado teclado;
    private Personaje jugador;

    public ControladorJuego() {
        this.jugador = new Personaje(100, 100, 10, 5, 1.0); // ejemplo de creación de un personaje
       
        this.teclado = new ControladorTeclado();

        this.vistaJuego = new VistaJuego(jugador, teclado);


    VistaPrincipal.setPanelContenedor(vistaJuego);
    

    vistaJuego.requestFocusInWindow(); 
    }
}
