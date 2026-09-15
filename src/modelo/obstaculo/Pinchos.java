package modelo.obstaculo;

import controlador.ControladorSprites;
import java.awt.image.BufferedImage;

public class Pinchos extends Obstaculo {
    private int vidaARestar = 25;

    public Pinchos(float posicionX, float posicionY, float posicionZ, int ancho, int alto,
            boolean existe, BufferedImage spriteActual, int vidaARestar) {
        super(false, false, false, posicionX, posicionY, posicionZ, 16, 16, existe, spriteActual);
        this.vidaARestar = vidaARestar;
        ControladorSprites.getSprite(1, 177, 16, 16);
    }

}
