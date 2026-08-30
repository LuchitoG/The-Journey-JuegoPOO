package utilidades;

import java.awt.Font;
import java.io.InputStream;

public class GestorFuentes {
    
    private static Font fuentePrincipal;

    // Metodo publico, ESTE ES EL QUE HAY Q LLAMAR
    public static Font getFuente(float tamano) {
        // Si es la primera vez que se pide, la cargamos
        if (fuentePrincipal == null) {
            cargarFuenteBase();
        }
        
        return fuentePrincipal.deriveFont(Font.BOLD, tamano);
    }

    // Metodo privado que hace el laburo d leer el archivo .ttf
    private static void cargarFuenteBase() {
        try {
            // Ajusta la ruta según la estructura de tu proyecto
            InputStream is = GestorFuentes.class.getResourceAsStream("/recursos/tipografias/Jersey.ttf");
            
            if (is == null) {
                System.err.println("No se encontró el TTF. Usando fuente de respaldo.");
                fuentePrincipal = new Font("Monospaced", Font.BOLD, 12);
                return;
            }
            
            // Carga la fuente base (por defecto se crea en tamaño 1f)
            fuentePrincipal = Font.createFont(Font.TRUETYPE_FONT, is);
        
            
        } catch (Exception e) {
            System.err.println("Error al cargar la fuente: " + e.getMessage());
            fuentePrincipal = new Font("Monospaced", Font.BOLD, 12);
        }
    }
}