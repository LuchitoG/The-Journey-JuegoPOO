package modelo.obstaculos;

import java.awt.image.BufferedImage;

public class Agua extends Obstaculo {
    public Agua(float posicionX, float posicionY, float posicionZ, int ancho, int alto,
            boolean existe, BufferedImage spriteActual) {
        super(true, true, true, posicionX, posicionY, posicionZ, ancho, alto, existe, spriteActual);
    }
}
