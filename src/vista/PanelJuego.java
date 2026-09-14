package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import modelo.ModeloJuego;

public class PanelJuego extends JPanel {

    JPanel panelArriba, panelAbajo, panelIzquierda, panelDerecha, contenedorJuego;

    public PanelJuego(ModeloJuego modeloJuego) {

        this.setPreferredSize(new Dimension(1920, 1080));
        this.setLayout(new BorderLayout());

        panelArriba = new JPanel();
        panelAbajo = new JPanel();
        panelIzquierda = new JPanel();
        panelDerecha = new JPanel();

        // Sobrescribimos paintComponent al crear el contenedor
        contenedorJuego = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Limpia el panel
                
                // Si el modelo y la habitacion existen, dibujamos el fondo
                if (modeloJuego != null && modeloJuego.getHabitacionActual() != null) {
                    Image spriteFondo = modeloJuego.getHabitacionActual().getSpriteDeFondo();
                    
                    // Dibuja la imagen ocupando todo el contenedorJuego (1536x832)
                    g.drawImage(spriteFondo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panelArriba.setPreferredSize(new Dimension(1920, 124));
        panelAbajo.setPreferredSize(new Dimension(1920, 124));

        panelIzquierda.setPreferredSize(new Dimension(192, 832));
        panelDerecha.setPreferredSize(new Dimension(192, 832));

        contenedorJuego.setPreferredSize(new Dimension(1536, 832));

        panelArriba.setBackground(Color.RED);
        panelAbajo.setBackground(Color.BLUE);
        panelIzquierda.setBackground(Color.GREEN);
        panelDerecha.setBackground(Color.YELLOW);

        this.add(panelArriba, BorderLayout.NORTH);
        this.add(panelAbajo, BorderLayout.SOUTH);
        this.add(panelIzquierda, BorderLayout.WEST);
        this.add(panelDerecha, BorderLayout.EAST);
        this.add(contenedorJuego, BorderLayout.CENTER);
    }
    
}