package controlador;

import modelo.Direccion;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorTeclado implements KeyListener {

    // Getters para consultar el estado de movimiento

    private Direccion direccionCaminar;
    private Direccion direccionDisparar;

    // lo que permite que el controlador pueda recibir eventos de teclado

    // MOVIMIENTO
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W)
            direccionCaminar = Direccion.ARRIBA;
        if (key == KeyEvent.VK_S)
            direccionCaminar = Direccion.ABAJO;
        if (key == KeyEvent.VK_A)
            direccionCaminar = Direccion.IZQUIERDA;
        if (key == KeyEvent.VK_D)
            direccionCaminar = Direccion.DERECHA;

        // DISPARO

        if (key == KeyEvent.VK_UP)
            direccionDisparar = Direccion.ARRIBA;
        if (key == KeyEvent.VK_DOWN)
            direccionDisparar = Direccion.ABAJO;
        if (key == KeyEvent.VK_LEFT)
            direccionDisparar = Direccion.IZQUIERDA;
        if (key == KeyEvent.VK_RIGHT)
            direccionDisparar = Direccion.IZQUIERDA;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}