package vista;

import controlador.ControladorTeclado;
import entidades.Heroe;
import entidades.ProyectilHeroe;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class VistaJuego extends JPanel implements ActionListener {

    // instancias de las clases que se van a usar
    private Heroe jugador;
    private ControladorTeclado teclado;
    private Timer timer;

    // guarda la cantidad de proyectiles del jugador
    private List<ProyectilHeroe> proyectiles;

    public VistaJuego(Heroe jugador, ControladorTeclado teclado) {
        this.jugador = jugador;
        this.teclado = teclado;
        this.proyectiles = new ArrayList<>();
        setBackground(Color.BLACK); // color del fondo
        setFocusable(true);
        addKeyListener(teclado);

        timer = new Timer(16, this); // (1000ms / 60 ≈ 16ms)
        timer.start(); // el timer lo que hace es checkear a cada rato si se esta realizando alguna
                       // accion del usuario

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // posicion del jugador
        g.setColor(Color.RED);
        g.fillRect(
                jugador.getPosicionX().intValue(),
                jugador.getPosicionY().intValue(),
                jugador.getTamanoWidth(),
                jugador.getTamanoHeight());
        // balas del jugador
        g.setColor(Color.WHITE);
        for (ProyectilHeroe p : proyectiles) {
            g.fillOval(
                    (int) p.getPosicionX(),
                    (int) p.getPosicionY(),
                    p.getTamanoWidth(),
                    p.getTamanoHeight());
        }
    }

    // todo esto es lo que hace el personaje
    @Override
    public void actionPerformed(ActionEvent e) {
        // Posición, velocidad y dimensiones del heroe
        double vel = jugador.getVelocidad();
        float posX = jugador.getPosicionX();
        float posY = jugador.getPosicionY();
        int ancho = jugador.getTamanoWidth();
        int alto = jugador.getTamanoHeight();

        // Movimiento leyendo directamente el estado del teclado
        if (teclado.isArriba() && posY - vel >= 0) {
            posY -= vel;
        }
        if (teclado.isAbajo() && posY + alto + vel <= getHeight()) {
            posY += vel;
        }
        if (teclado.isIzquierda() && posX - vel >= 0) {
            posX -= vel;
        }
        if (teclado.isDerecha() && posX + ancho + vel <= getWidth()) {
            posX += vel;
        }

        // Actualizar la posición del héroe
        jugador.setPosicionX(posX);
        jugador.setPosicionY(posY);

        // Disparo del jugador
        ProyectilHeroe nuevoProyectil = jugador.intentarDisparar(teclado);
        if (nuevoProyectil != null) {
            proyectiles.add(nuevoProyectil);
        }

        // Mover proyectiles y remover
        Iterator<ProyectilHeroe> it = proyectiles.iterator();
        while (it.hasNext()) {
            ProyectilHeroe p = it.next();
            p.mover(); // Llama a la formula de trayecto del proyectil

            // método estaFueraDePantalla de Proyectil
            if (p.estaFueraDePantalla(getWidth(), getHeight())) {
                it.remove();
            }
        }
        repaint();
    }
}
