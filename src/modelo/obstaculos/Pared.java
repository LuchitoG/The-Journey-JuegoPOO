package modelo.obstaculos;

import controlador.ControladorSprites;
import java.awt.image.BufferedImage;

public class Pared extends Obstaculo {
    public Pared(float posicionX, float posicionY, float posicionZ, int ancho, int alto,
            boolean existe, BufferedImage spriteActual) {
        super(true, true, false, posicionX, posicionY, posicionZ, ancho, alto, existe, spriteActual);
        ControladorSprites.getSprite(65, 193, 32, 16); // falta el sprite de pared

    }
}
