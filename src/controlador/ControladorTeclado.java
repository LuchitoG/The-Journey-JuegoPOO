package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorTeclado implements KeyListener {

    private boolean arriba, abajo, izquierda, derecha;

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

    // lo que permite que el controlador pueda recibir eventos de teclado

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) arriba = true;
        if (key == KeyEvent.VK_S) abajo = true;
        if (key == KeyEvent.VK_A) izquierda = true;
        if (key == KeyEvent.VK_D) derecha = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) arriba = false;
        if (key == KeyEvent.VK_S) abajo = false;
        if (key == KeyEvent.VK_A) izquierda = false;
        if (key == KeyEvent.VK_D) derecha = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}