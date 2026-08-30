package vista.componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import utilidades.GestorAudio;

public class BotonAnimado extends JButton {

    private Color colorNormal;
    private Color colorHover;
    private Font fuenteBase;
    private String textoOriginal;
    private float tamañoNormal;
    private float tamañoHover;

    // Rutas de sonido por defecto
    private String rutaSonidoHover = "/recursos/sonidos/hover.wav";
    private String rutaSonidoClic = "/recursos/sonidos/clic.wav";

    public BotonAnimado(String texto, Dimension dimension, Font fuente, Color colorNormal, Color colorHover, float tamañoNormal, float tamañoHover) {
        super(texto);
        this.textoOriginal = texto;
        this.fuenteBase = fuente;
        this.colorNormal = colorNormal;
        this.colorHover = colorHover;
        this.tamañoNormal = tamañoNormal;
        this.tamañoHover = tamañoHover;

        configurarEstilo(dimension);
        configurarEventos();
    }

    private void configurarEstilo(Dimension dimension) {
        setFont(fuenteBase.deriveFont(tamañoNormal));
        setForeground(colorNormal);
        
        if (dimension != null) {
            setPreferredSize(dimension);
            setMaximumSize(dimension);
            setMinimumSize(dimension);
        }

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void configurarEventos() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(colorHover);
                setFont(fuenteBase.deriveFont(tamañoHover));
                setText("> " + textoOriginal + " <");
                // Lo cambie ciro reproducirEfectoCorto(rutaSonidoHover); // Sonido al pasar el ratón
                GestorAudio.getInstance().reproducirEfecto(GestorAudio.SFX_HOVER);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(colorNormal);
                setFont(fuenteBase.deriveFont(tamañoNormal));
                setText(textoOriginal);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Lo cambie ciro reproducirEfectoCorto(rutaSonidoClic); // Sonido al hacer clic
                GestorAudio.getInstance().reproducirEfecto(GestorAudio.SFX_CLICK);
            }
        });
    }

    // --- REPRODUCTOR DE SONIDO INTEGRADO ---
    private void reproducirEfectoCorto(String ruta) {
        try {
            URL url = getClass().getResource(ruta);
            if (url != null) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start(); 
            }
        } catch (Exception ex) {
            // Se ignora para no inundar la consola si falta un archivo
        }
    }

    // --- Setters para modificar los valores dinámicamente ---

    public void setColorNormal(Color colorNormal) {
        this.colorNormal = colorNormal;
        setForeground(colorNormal);
    }

    public void setColorHover(Color colorHover) {
        this.colorHover = colorHover;
    }

    public void setTextoBoton(String texto) {
        this.textoOriginal = texto;
        setText(texto);
    }

    public void setTamañoFuentes(float normal, float hover) {
        this.tamañoNormal = normal;
        this.tamañoHover = hover;
        setFont(fuenteBase.deriveFont(this.tamañoNormal));
    }

    // Setters por si necesitas cambiar los sonidos de un botón específico
    public void setSonidoHover(String ruta) {
        this.rutaSonidoHover = ruta;
    }

    public void setSonidoClic(String ruta) {
        this.rutaSonidoClic = ruta;
    }
}