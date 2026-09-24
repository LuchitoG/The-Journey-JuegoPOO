package vista;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utilidades.GestorFuentes;

public class PanelRanking extends JPanel {

    private JTable tabla;
    private float hue = 0f;

    public PanelRanking() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(20, 10, 35));

        JLabel labelTitulo = new JLabel("Ranking");
        labelTitulo.setForeground(new Color(255, 7, 58));
        labelTitulo.setFont(GestorFuentes.getFuente(80f));
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalStrut(30));
        this.add(labelTitulo);
        this.add(Box.createVerticalStrut(20));

        this.tabla = crearTabla();
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setAlignmentX(Component.CENTER_ALIGNMENT);
        scroll.getViewport().setBackground(new Color(30, 15, 45));
        scroll.setBorder(BorderFactory.createEmptyBorder(0, 60, 30, 60));
        scroll.setOpaque(true);
        scroll.setBackground(new Color(20, 10, 35));

        this.add(scroll);

        iniciarAnimacionArcoiris();
    }

    private JTable crearTabla() {
        String[] columnas = { "#", "Jugador", "Tiempo" };
        Object[][] filas = obtenerFilasOrdenadas();

        DefaultTableModel modelo = new DefaultTableModel(filas, columnas) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        JTable tablaNueva = new JTable(modelo);
        estilizarTabla(tablaNueva);
        return tablaNueva;
    }

    private Object[][] obtenerFilasOrdenadas() {
        // Esto lo reemplazamos cuando tengamos la base de datos
        Object[][] jugadores = {
            { "El_Puchikachi MKII", 135 },
            { "Fernet destroyer", 167 },
            { "Chesseburguer triple", 182 },
            { "Von Neumann", 210 },
            { "Babbage", 250},
        };

        java.util.Arrays.sort(jugadores, (a, b) -> Integer.compare((int) a[1], (int) b[1]));

        Object[][] filas = new Object[jugadores.length][3];
        for (int i = 0; i < jugadores.length; i++) {
            String nombre = (String) jugadores[i][0];
            int segundos = (int) jugadores[i][1];

            filas[i][0] = i + 1;
            filas[i][1] = nombre;
            filas[i][2] = formatearTiempo(segundos);
        }
        return filas;
    }

    private String formatearTiempo(int segundosTotales) {
        int minutos = segundosTotales / 60;
        int segundos = segundosTotales % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    private void estilizarTabla(JTable tabla) {
        tabla.setRowHeight(65);
        tabla.setBackground(new Color(30, 15, 45));
        tabla.setGridColor(new Color(60, 40, 80));
        tabla.setRowSelectionAllowed(false);
        tabla.setFocusable(false);

        tabla.getTableHeader().setFont(GestorFuentes.getFuente(30f));
        tabla.getTableHeader().setForeground(Color.YELLOW);
        tabla.getTableHeader().setBackground(new Color(45, 20, 70));
        tabla.getTableHeader().setReorderingAllowed(false);

        DefaultTableCellRenderer rendererAnimado = crearRendererAnimado();
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(rendererAnimado);
        }
    }

    private DefaultTableCellRenderer crearRendererAnimado() {
        return new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean seleccionada,
                    boolean foco, int fila, int columna) {
                Component celda = super.getTableCellRendererComponent(tabla, valor, seleccionada, foco, fila, columna);
                setHorizontalAlignment(JLabel.CENTER);
                setFont(GestorFuentes.getFuente(obtenerTamanoFuente(fila)));

                if (fila < 3) {
                    celda.setForeground(Color.getHSBColor(hue, 1f, 1f));
                } else {
                    celda.setForeground(Color.WHITE);
                }
                return celda;
            }
        };
    }

    private float obtenerTamanoFuente(int fila) {
        switch (fila) {
            case 0: return 44f;  // 1er puesto: grande
            case 1: return 34f;  // 2do puesto: mediano
            case 2: return 28f;  // 3er puesto: chica
            default: return 22f; // 4to en adelante: mas chico
        }
    }

    private void iniciarAnimacionArcoiris() {
        Timer timerArcoiris = new Timer(40, e -> {
            hue += 0.005f;
            if (hue > 1f) {
                hue = 0f;
            }
            tabla.repaint();
        });
        timerArcoiris.start();
    }
}