package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import vista.componentes.BotonAnimado;

public class PanelSalir extends JDialog {

    private JButton botonSi;
    private JButton botonNo;
    private Font fuenteLabel;
    private Font fuenteBotones;

    // Ahora recibe un "Window" (la ventana principal del juego) para poder centrarse sobre ella
    public PanelSalir(Window ventanaPadre) {
        super(ventanaPadre, "Salir", ModalityType.APPLICATION_MODAL); // Modalidad: bloquea la ventana de atrás
        
        setSize(600, 300); // Tamaño de la ventanita emergente
        setLocationRelativeTo(ventanaPadre); // Centrar sobre el juego
        setResizable(false);

        // Creamos un panel principal para el fondo oscuro
        JPanel panelFondo = new JPanel();
        panelFondo.setLayout(new BoxLayout(panelFondo, BoxLayout.Y_AXIS));
        panelFondo.setBackground(new Color(20, 10, 35));

        fuenteLabel = cargarFuente("/recursos/tipografias/Jersey.ttf", 32f);
        fuenteBotones = cargarFuente("/recursos/tipografias/Jersey.ttf", 32f);

        JLabel labelMensaje = new JLabel("¿Estás seguro de salir del juego?");
        labelMensaje.setForeground(Color.WHITE);
        labelMensaje.setFont(fuenteLabel);
        labelMensaje.setAlignmentX(Component.CENTER_ALIGNMENT);

        Dimension dimensionBotones = new Dimension(150, 50);

        this.botonSi = new BotonAnimado("Sí", dimensionBotones, fuenteBotones, Color.WHITE, new Color(255, 215, 0), 36f, 40f);
        this.botonNo = new BotonAnimado("No", dimensionBotones, fuenteBotones, Color.WHITE, new Color(255, 215, 0), 36f, 40f);

        // Acciones: Si presiona Sí, cierra todo. Si presiona No, cierra solo esta ventanita (dispose)
        botonSi.addActionListener(e -> System.exit(0)); 
        botonNo.addActionListener(e -> dispose()); 

        // --- ESCAPE PARA CERRAR LA VENTANITA ---
        panelFondo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cerrarEsc");
        panelFondo.getActionMap().put("cerrarEsc", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
        panelBotones.setOpaque(false);
        panelBotones.add(botonSi);
        panelBotones.add(Box.createHorizontalStrut(50));
        panelBotones.add(botonNo);

        panelFondo.add(Box.createVerticalGlue());
        panelFondo.add(labelMensaje);
        panelFondo.add(Box.createVerticalStrut(40));
        panelFondo.add(panelBotones);
        panelFondo.add(Box.createVerticalGlue());

        // Añadimos el panel oscuro a la ventana
        add(panelFondo);
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
}