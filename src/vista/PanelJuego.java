package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class PanelJuego extends JPanel {

    JPanel panelArriba, panelAbajo, panelIzquierda, panelDerecha, contenedorJuego;

    public PanelJuego() {

        this.setPreferredSize(new Dimension(1920, 1080));
        this.setLayout(new BorderLayout());

        panelArriba = new JPanel();
        panelAbajo = new JPanel();
        panelIzquierda = new JPanel();
        panelDerecha = new JPanel();
        contenedorJuego = new JPanel();

        panelArriba.setPreferredSize(new Dimension(1920, 124));
        panelAbajo.setPreferredSize(new Dimension(1920, 124));

        panelIzquierda.setPreferredSize(new Dimension(192, 832));
        panelDerecha.setPreferredSize(new Dimension(192, 832));

        contenedorJuego.setPreferredSize(new Dimension(1536, 832));

        panelArriba.setBackground(Color.RED);
        panelAbajo.setBackground(Color.BLUE);
        panelIzquierda.setBackground(Color.GREEN);
        panelDerecha.setBackground(Color.YELLOW);
        contenedorJuego.setBackground(Color.BLACK);

        this.add(panelArriba, BorderLayout.NORTH);
        this.add(panelAbajo, BorderLayout.SOUTH);
        this.add(panelIzquierda, BorderLayout.WEST);
        this.add(panelDerecha, BorderLayout.EAST);
        this.add(contenedorJuego, BorderLayout.CENTER);
    }
    
}