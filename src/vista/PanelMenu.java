package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.InputStream;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import vista.componentes.BotonAnimado;

public class PanelMenu extends JPanel {

    JButton botonJugar, botonRanking, botonOpciones, botonCreditos;
    Font fuenteTitulo;
    Font fuenteBotones;

    public PanelMenu() {
        this.setLayout(new GridLayout(1, 2));
        this.setBackground(new Color(20, 10, 35));

        // FUENTES PERSONALIZADAS
        fuenteTitulo = cargarFuente("/recursos/tipografias/Jersey.ttf", 140f);
        fuenteBotones = cargarFuente("/recursos/tipografias/Jersey.ttf", 72f);

        // MITAD IZQUIERDA
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setOpaque(false);

        // MITAD DERECHA
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        panelDerecho.setOpaque(false);

        JLabel labelTitulo = new JLabel("The Journey");
        labelTitulo.setForeground(Color.WHITE);
        labelTitulo.setFont(fuenteTitulo); // Aplicamos la fuente aquí
        labelTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        Dimension dimensionBotones = new Dimension(400, 100);
        
        this.botonJugar =  new BotonAnimado("Jugar", dimensionBotones, fuenteBotones, Color.WHITE, new Color(255, 215, 0), 50f, 55f);
        this.botonRanking =  new BotonAnimado("Ranking", dimensionBotones, fuenteBotones, Color.WHITE, new Color(255, 215, 0), 50f, 55f);
        this.botonOpciones=  new BotonAnimado("Opciones", dimensionBotones, fuenteBotones, Color.WHITE, new Color(255, 215, 0), 50f, 55f);
        this.botonCreditos =  new BotonAnimado("Creditos", dimensionBotones, fuenteBotones, Color.WHITE, new Color(255, 215, 0), 50f, 55f);

        panelDerecho.add(Box.createVerticalGlue());
        panelDerecho.add(labelTitulo);
        panelDerecho.add(Box.createVerticalStrut(40));
        panelDerecho.add(botonJugar);
        panelDerecho.add(Box.createVerticalStrut(20));
        panelDerecho.add(botonRanking);
        panelDerecho.add(Box.createVerticalStrut(20));
        panelDerecho.add(botonOpciones);
        panelDerecho.add(Box.createVerticalStrut(20));
        panelDerecho.add(botonCreditos);
        panelDerecho.add(Box.createVerticalGlue());

        this.add(panelIzquierdo);
        this.add(panelDerecho);
    }

    // MÉTODO AUXILIAR PARA CARGAR LA FUENTE
    private Font cargarFuente(String ruta, float tamaño) {
        try {
            // Buscamos el archivo directamente en los recursos del programa
            InputStream is = getClass().getResourceAsStream(ruta);
            
            // Si la ruta está mal, InputStream devuelve null
            if (is == null) {
                System.err.println("No se encontró el archivo exacto en: " + ruta);
                return new Font("Monospaced", Font.BOLD, (int) tamaño);
            }
            
            // Carga la fuente desde el InputStream
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            return font.deriveFont(Font.BOLD, tamaño); 
            
        } catch (Exception e) {
            System.err.println("Error al cargar la fuente, usando por defecto.");
            return new Font("Monospaced", Font.BOLD, (int) tamaño); 
        }
    }

    // MÉTODO AUXILIAR PARA NO REPETIR CÓDIGO EN LOS BOTONES
    private JButton crearBoton(String texto, Dimension dimension) {
        JButton boton = new JButton(texto);
        boton.setFont(fuenteBotones); // Aplicamos la fuente
        boton.setPreferredSize(dimension);
        boton.setMinimumSize(dimension);
        boton.setMaximumSize(dimension);

        boton.setFocusPainted(false);

        return boton;
    }

    public JButton getBotonJugar() { return this.botonJugar; }
    public JButton getBotonRanking() { return this.botonRanking; }
    public JButton getBotonOpciones() { return this.botonOpciones; }
    public JButton getBotonCreditos() { return this.botonCreditos; }
}