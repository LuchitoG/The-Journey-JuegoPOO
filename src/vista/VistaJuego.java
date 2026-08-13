package vista;

import controlador.ControladorTeclado;
import entidades.Personaje;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;



public class VistaJuego extends JPanel implements ActionListener {

// posicion y tamaño del cuadrado
private int x = 100;
private int y = 100;
private final int tamano = 50;

// instancias de las clases que se van a usar
private Personaje jugador; 
private ControladorTeclado teclado;
private Timer timer;



public VistaJuego(Personaje jugador, ControladorTeclado teclado) {
    this.jugador = jugador;
    this.teclado = teclado;
    setBackground(Color.BLACK); // color del fondo
    setFocusable(true);
    addKeyListener(teclado);

    timer = new Timer(16, this); // (1000ms / 60 ≈ 16ms)
    timer.start(); // el timer lo que hace es checkear a cada rato si se esta realizando alguna accion del usuario
    
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.RED); //dibujo el cuadraddo
    g.fillRect(x, y, tamano, tamano);
}
// todo esto es lo que hace que se mueva el cuadrado, se puede cambiar por lo que haga el personaje 
@Override
public void actionPerformed(ActionEvent e) {
    int vel = jugador.getVelocidad();
    if (teclado.isArriba() && y -vel >= 0) {
        y -= vel;
    }
    if (teclado.isAbajo() && y + tamano + vel <= getHeight()) {
        y += vel;
    }
    if (teclado.isIzquierda() && x - vel >= 0) {
        x -= vel;
    }
    if (teclado.isDerecha() && x + tamano + vel <= getWidth()) {
        x += vel;
    }
    repaint(); 
}
}

