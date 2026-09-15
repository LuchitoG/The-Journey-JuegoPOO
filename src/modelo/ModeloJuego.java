package modelo;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class ModeloJuego {
    private Habitacion habitacionActual;

    public ModeloJuego() {
        inicializarMundo();
    }

    private void inicializarMundo() {

        try {
            Image fondoInicial = ImageIO.read(new File("src/recursos/sprite_fondo.png"));

            habitacionActual = new Habitacion(
                    fondoInicial,
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new HashMap<>(),
                    null);
        } catch (IOException e) {
            System.out.println("¡ERROR! No se encontró la imagen en la ruta especificada.");
            e.printStackTrace();
        }
    }

    public Habitacion getHabitacionActual() {
        return habitacionActual;
    }

    public void actualizar() {
        // VER DSP
    }
}