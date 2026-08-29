package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.componentes.BotonAnimado;

public class PanelLogin extends JPanel {

    private JTextField textFieldLogin;
    private JButton botonJugar;

    Font fuenteBotones;
    Font fuenteLabel;

    public PanelLogin() {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(20, 10, 35));

        fuenteLabel = cargarFuente("/recursos/tipografias/Jersey.ttf", 36f);
        fuenteBotones = cargarFuente("/recursos/tipografias/Jersey.ttf", 24f); 

        JLabel labelLogin = new JLabel("Ingrese su nombre de usuario");
        labelLogin.setForeground(Color.WHITE);
        labelLogin.setFont(fuenteLabel); 
        labelLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ---------------------------------------------------------
        // TEXTFIELD SIN BORDE EXTERIOR
        // ---------------------------------------------------------
        this.textFieldLogin = new JTextField();
        
        textFieldLogin.setBackground(Color.WHITE);
        textFieldLogin.setForeground(Color.BLACK);
        
        // Solo dejamos un EmptyBorder para mantener el margen interior (padding).
        // Al no tener LineBorder, el input se verá como un rectángulo blanco plano.
        textFieldLogin.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        Dimension dimensionInput = new Dimension(400, 45); 
        textFieldLogin.setPreferredSize(dimensionInput);
        textFieldLogin.setMaximumSize(dimensionInput);
        
        textFieldLogin.setFont(new Font("Monospaced", Font.BOLD, 20));
        textFieldLogin.setHorizontalAlignment(JTextField.CENTER);
        textFieldLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        // ---------------------------------------------------------

        Dimension dimensionBotones = new Dimension(150, 40);

        this.botonJugar = new BotonAnimado("Jugar", dimensionBotones, fuenteBotones, Color.WHITE, new Color(255, 215, 0), 24f, 28f);
        botonJugar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonJugar.setPreferredSize(dimensionBotones); 
        botonJugar.setMaximumSize(dimensionBotones);

        // --- NUEVA LÍNEA: Activar el botón al presionar Enter en el input ---
        this.textFieldLogin.addActionListener(e -> this.botonJugar.doClick());

        this.add(Box.createVerticalGlue());
        this.add(labelLogin);
        this.add(Box.createVerticalStrut(20));
        this.add(textFieldLogin);
        this.add(Box.createVerticalStrut(40));
        this.add(botonJugar);
        this.add(Box.createVerticalGlue());
    }

    public JButton getBotonJugar() {
        return this.botonJugar;
    }

    private Font cargarFuente(String ruta, float tamaño) {
        try {
            InputStream is = getClass().getResourceAsStream(ruta);
            if (is == null) {
                System.err.println("No se encontró el archivo exacto en: " + ruta);
                return new Font("Monospaced", Font.BOLD, (int) tamaño);
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            return font.deriveFont(Font.BOLD, tamaño); 
        } catch (Exception e) {
            System.err.println("Error al cargar la fuente, usando por defecto.");
            return new Font("Monospaced", Font.BOLD, (int) tamaño); 
        }
    }
}