package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorTeclado implements KeyListener {

    private boolean arriba, abajo, izquierda, derecha;

    private boolean dispararArriba, dispararAbajo, dispararIzq, dispararDere;
    // Getters para consultar el estado de movimiento

    public boolean isArriba() {
        return arriba;
    }

    public boolean isAbajo() {
        return abajo;
    }

    public boolean isIzquierda() {
        return izquierda;
    }

    public boolean isDerecha() {
        return derecha;
    }

    public boolean isDispararArriba() {
        return dispararArriba;
    }

    public boolean isDispararAbajo() {
        return dispararAbajo;
    }

    public boolean isDispararIzq() {
        return dispararIzq;
    }

    public boolean isDispararDere() {
        return dispararDere;
    }

    // lo que permite que el controlador pueda recibir eventos de teclado

    // MOVIMIENTO
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W)
            arriba = true;
        if (key == KeyEvent.VK_S)
            abajo = true;
        if (key == KeyEvent.VK_A)
            izquierda = true;
        if (key == KeyEvent.VK_D)
            derecha = true;

        // DISPARO

        if (key == KeyEvent.VK_UP)
            dispararArriba = true;
        if (key == KeyEvent.VK_DOWN)
            dispararAbajo = true;
        if (key == KeyEvent.VK_LEFT)
            dispararIzq = true;
        if (key == KeyEvent.VK_RIGHT)
            dispararDere = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        // RELEASE DEL MOVIMIENTO
        if (key == KeyEvent.VK_W)
            arriba = false;
        if (key == KeyEvent.VK_S)
            abajo = false;
        if (key == KeyEvent.VK_A)
            izquierda = false;
        if (key == KeyEvent.VK_D)
            derecha = false;

        // RELEASE DEL DISPARO
        if (key == KeyEvent.VK_UP)
            dispararArriba = false;
        if (key == KeyEvent.VK_DOWN)
            dispararAbajo = false;
        if (key == KeyEvent.VK_LEFT)
            dispararIzq = false;
        if (key == KeyEvent.VK_RIGHT)
            dispararDere = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}