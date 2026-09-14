package modelo.obstaculos;

import controlador.ControladorSprites;
import java.awt.image.BufferedImage;

public class Agua extends Obstaculo {
    public Agua(float posicionX, float posicionY, float posicionZ, int ancho, int alto,
            boolean existe, BufferedImage spriteActual) {
        super(true, true, true, posicionX, posicionY, posicionZ, 32, 16, existe, spriteActual);
        ControladorSprites.getSprite(65, 193, 32, 16);
    }
}
