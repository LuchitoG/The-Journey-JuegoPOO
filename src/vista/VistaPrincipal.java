package vista;

import controlador.ControladorMenu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

public class VistaPrincipal extends JFrame {

    public static JPanel panelContenedor; 
    private PanelMenu panelMenu;
    private ControladorMenu controladorMenu;

    public VistaPrincipal() {
        setTitle("The Journey");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // --- CONFIGURACIÓN DE PANTALLA COMPLETA ---
        setUndecorated(true); 
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        // ------------------------------------------

        panelContenedor = new JPanel();
        panelContenedor.setLayout(new BorderLayout());
        panelContenedor.setBackground(Color.BLACK);
        this.add(panelContenedor);

        panelMenu = new PanelMenu();
        controladorMenu = new ControladorMenu(panelMenu);

        // Cargamos el menú inicial al arrancar el programa
        setPanelContenedor(panelMenu);

    }

    public static void setPanelContenedor(JPanel panelNuevo) {
        panelContenedor.removeAll();
        panelContenedor.add(panelNuevo, BorderLayout.CENTER);

        // Para que swing refresque y se vea
        panelContenedor.revalidate();
        panelContenedor.repaint();
        
        // --- FOCO PARA EL TECLADO ---
        SwingUtilities.invokeLater(() -> panelNuevo.requestFocusInWindow());
    }
}