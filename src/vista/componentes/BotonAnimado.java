package vista.componentes;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class BotonAnimado extends JButton {

    private Color colorNormal;
    private Color colorHover;
    private Font fuenteBase;
    private String textoOriginal;
    private float tamañoNormal;
    private float tamañoHover;

    // El constructor ahora recibe los tamaños de fuente normal y hover
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
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(colorNormal);
                setFont(fuenteBase.deriveFont(tamañoNormal));
                setText(textoOriginal);
            }
        });
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
}