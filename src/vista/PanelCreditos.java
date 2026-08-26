package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PanelCreditos extends JPanel {

    private JButton botonVolver;
    private Font fuenteJersey;

    // Paleta de colores estándar
    private final Color COLOR_FONDO = new Color(20, 10, 35);
    private final Color COLOR_TITULO = new Color(255, 0, 255);
    private final Color COLOR_ROL = new Color(255, 215, 0);       // Dorado
    private final Color COLOR_NOMBRE = new Color(230, 230, 240);  // Blanco suave
    private final Color COLOR_BOTON_NORMAL = new Color(200, 200, 220);
    private final Color COLOR_BOTON_HOVER = new Color(255, 215, 0);

    public PanelCreditos() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(COLOR_FONDO);

        fuenteJersey = cargarFuente("/recursos/tipografias/Jersey.ttf");

        // Título
        JLabel labelTitulo = new JLabel("Créditos");
        labelTitulo.setFont(fuenteJersey.deriveFont(72f));
        labelTitulo.setForeground(COLOR_TITULO);
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Contenedor de créditos
        JPanel contenedorCreditos = new JPanel();
        contenedorCreditos.setLayout(new BoxLayout(contenedorCreditos, BoxLayout.Y_AXIS));
        contenedorCreditos.setOpaque(false);
        contenedorCreditos.setAlignmentX(Component.CENTER_ALIGNMENT);

        // --- EQUIPO DE DESARROLLO ---
        agregarEncabezado(contenedorCreditos, "DESARROLLADO POR");
        agregarNombre(contenedorCreditos, "León Flores");
        agregarNombre(contenedorCreditos, "Luca Gil");
        agregarNombre(contenedorCreditos, "Lucciano Giovanini");
        agregarNombre(contenedorCreditos, "Ciro Saucedo");

        contenedorCreditos.add(Box.createVerticalStrut(18));

        // --- RECURSOS EXTERNOS ---
        agregarEncabezado(contenedorCreditos, "MÚSICA");
        agregarNombre(contenedorCreditos, "Música por: León Flores");

        contenedorCreditos.add(Box.createVerticalStrut(12));

        agregarEncabezado(contenedorCreditos, "TIPOGRAFÍA");
        agregarNombre(contenedorCreditos, "Jersey 10 / Google Fonts");

        // Botón Volver con acción de cierre de ventana
        this.botonVolver = crearBotonVolver("Volver al Menú", new Dimension(300, 50));
        this.botonVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Cierra la ventana emergente/diálogo donde esté alojado este panel
        this.botonVolver.addActionListener(e -> {
            Window ventanaPadre = SwingUtilities.getWindowAncestor(this);
            if (ventanaPadre != null) {
                ventanaPadre.dispose();
            }
        });

        // Armado del panel con espaciadores
        this.add(Box.createVerticalGlue());
        this.add(labelTitulo);
        this.add(Box.createVerticalStrut(30));
        this.add(contenedorCreditos);
        this.add(Box.createVerticalStrut(25));
        this.add(botonVolver);
        this.add(Box.createVerticalGlue());
    }

    private void agregarEncabezado(JPanel contenedor, String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(fuenteJersey.deriveFont(20f));
        label.setForeground(COLOR_ROL);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        contenedor.add(label);
        contenedor.add(Box.createVerticalStrut(4));
    }

    private void agregarNombre(JPanel contenedor, String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(fuenteJersey.deriveFont(24f));
        label.setForeground(COLOR_NOMBRE);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        contenedor.add(label);
        contenedor.add(Box.createVerticalStrut(4));
    }

    private JButton crearBotonVolver(String texto, Dimension dimension) {
        JButton boton = new JButton(texto);
        boton.setFont(fuenteJersey.deriveFont(28f));
        boton.setForeground(COLOR_BOTON_NORMAL);
        boton.setPreferredSize(dimension);
        boton.setMaximumSize(dimension);
        boton.setMinimumSize(dimension);

        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setOpaque(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setForeground(COLOR_BOTON_HOVER);
                boton.setFont(fuenteJersey.deriveFont(32f));
                boton.setText("> " + texto + " <");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setForeground(COLOR_BOTON_NORMAL);
                boton.setFont(fuenteJersey.deriveFont(28f));
                boton.setText(texto);
            }
        });

        return boton;
    }

    private Font cargarFuente(String ruta) {
        try {
            InputStream is = getClass().getResourceAsStream(ruta);
            if (is == null) {
                return new Font("Monospaced", Font.BOLD, 28);
            }
            return Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception e) {
            return new Font("Monospaced", Font.BOLD, 28);
        }
    }

    public JButton getBotonVolver() {
        return this.botonVolver;
    }
}