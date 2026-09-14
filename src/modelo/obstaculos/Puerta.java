package modelo.obstaculos;

import controlador.ControladorSprites;
import java.awt.image.BufferedImage;

public class Puerta extends Obstaculo {

    public Puerta(float posicionX, float posicionY, float posicionZ, int ancho, int alto,
            boolean existe, BufferedImage spriteActual) {
        super(false, true, false, posicionX, posicionY, posicionZ, ancho, alto, existe, spriteActual);
        ControladorSprites.getSprite(65, 193, 32, 16); // falta cambiar cuando este el sprite de puerta hecho
    }
}
