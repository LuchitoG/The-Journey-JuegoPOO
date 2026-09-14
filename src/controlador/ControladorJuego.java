package controlador;

import modelo.ModeloJuego;
import vista.PanelJuego;
import vista.VistaPrincipal;

public class ControladorJuego implements Runnable {

    private ModeloJuego modeloJuego;
    private PanelJuego panelJuego;
    private boolean corriendo;

    public ControladorJuego() {

        this.modeloJuego = new ModeloJuego();
        this.panelJuego = new PanelJuego(modeloJuego);
        VistaPrincipal.setPanelContenedor(panelJuego);

        // Arranca el gameloop
        iniciarJuego();
    } 

    private void iniciarJuego() {
        corriendo = true;
        Thread hiloJuego = new Thread(this); // this llama al metodo run() de abajo
        hiloJuego.start();
    }

    @Override
    public void run() {
        long tiempoAnterior = System.nanoTime();
        double ticksPorSegundo = 60.0; // 60fps
        double nsPorTick = 1000000000 / ticksPorSegundo;
        double delta = 0;

        // ESTE ES EL GAMELOOP
        while (corriendo) {
            long tiempoActual = System.nanoTime();
            delta += (tiempoActual - tiempoAnterior) / nsPorTick;
            tiempoAnterior = tiempoActual;

            if (delta >= 1) {
                // El de actualizar por ahora esta vacio
                modeloJuego.actualizar(); 
                
                // Mandar a redibujar la pantalla (llama al paintComponent)
                panelJuego.repaint(); 
                
                delta--;
            }
        }
    }
}