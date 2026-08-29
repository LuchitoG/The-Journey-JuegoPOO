package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import vista.componentes.BotonAnimado;

public class PanelMenu extends JPanel {

    private JButton botonJugar, botonRanking, botonOpciones, botonCreditos, botonSalir;
    private Font fuenteTitulo, fuenteBotones;
    private Clip clipMusica;

    public PanelMenu() {
        this.setLayout(new GridLayout(1, 2));
        this.setBackground(new Color(20, 10, 35));

        fuenteTitulo = cargarFuente("/recursos/tipografias/Jersey.ttf", 140f);
        fuenteBotones = cargarFuente("/recursos/tipografias/Jersey.ttf", 72f);

        // MITAD IZQUIERDA (GIF)
        JPanel panelIzquierdo = new JPanel(new java.awt.BorderLayout());
        panelIzquierdo.setOpaque(false);
        try {
            java.net.URL urlGif = getClass().getResource("/recursos/mago.gif");
            if (urlGif != null) {
                JLabel labelGif = new JLabel(new javax.swing.ImageIcon(urlGif));
                labelGif.setHorizontalAlignment(JLabel.CENTER); 
                panelIzquierdo.add(labelGif, java.awt.BorderLayout.CENTER);
            }
        } catch (Exception e) {
            System.err.println("Error al cargar el GIF.");
        }

        // MITAD DERECHA (BOTONES)
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        panelDerecho.setOpaque(false);

        JLabel labelTitulo = new JLabel("The Journey");
        labelTitulo.setForeground(Color.YELLOW);
        labelTitulo.setFont(fuenteTitulo); 
        labelTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        Dimension dimensionBotones = new Dimension(400, 60);
        
        // El sonido ya viene incluido dentro de cada BotonAnimado
        botonJugar = new BotonAnimado("Jugar", dimensionBotones, fuenteBotones, Color.WHITE, new Color(255, 215, 0), 50f, 55f);
        botonRanking = new BotonAnimado("Ranking", dimensionBotones, fuenteBotones, Color.WHITE, new Color(255, 215, 0), 50f, 55f);
        botonOpciones = new BotonAnimado("Opciones", dimensionBotones, fuenteBotones, Color.WHITE, new Color(255, 215, 0), 50f, 55f);
        botonCreditos = new BotonAnimado("Creditos", dimensionBotones, fuenteBotones, Color.WHITE, new Color(255, 215, 0), 50f, 55f);
        botonSalir = new BotonAnimado("Salir", dimensionBotones, fuenteBotones, Color.WHITE, new Color(255, 215, 0), 50f, 55f);

        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escapeMenu");
        this.getActionMap().put("escapeMenu", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.awt.Window parent = javax.swing.SwingUtilities.getWindowAncestor(PanelMenu.this);
                new PanelSalir(parent).setVisible(true);
            }
        });

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
        panelDerecho.add(Box.createVerticalStrut(20));
        panelDerecho.add(botonSalir);
        panelDerecho.add(Box.createVerticalGlue());

        this.add(panelIzquierdo);
        this.add(panelDerecho);

        reproducirMusica("/recursos/sonidos/NORTHERNLIGHT(menu).wav");
    }

    private void reproducirMusica(String ruta) {
        try {
            java.net.URL url = getClass().getResource(ruta);
            if (url != null) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clipMusica = AudioSystem.getClip();
                clipMusica.open(audioIn);
                clipMusica.loop(Clip.LOOP_CONTINUOUSLY); 
                clipMusica.start();
            }
        } catch (Exception e) {}
    }

    private Font cargarFuente(String ruta, float tamaño) {
        try {
            InputStream is = getClass().getResourceAsStream(ruta);
            if (is == null) return new Font("Monospaced", Font.BOLD, (int) tamaño);
            return Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.BOLD, tamaño); 
        } catch (Exception e) {
            return new Font("Monospaced", Font.BOLD, (int) tamaño); 
        }
    }

    public JButton getBotonJugar() { return this.botonJugar; }
    public JButton getBotonRanking() { return this.botonRanking; }
    public JButton getBotonOpciones() { return this.botonOpciones; }
    public JButton getBotonCreditos() { return this.botonCreditos; }
    public JButton getBotonSalir() { return this.botonSalir; }
}