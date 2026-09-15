package modelo.obstaculo;

import controlador.ControladorSprites;
import java.awt.image.BufferedImage;

public class Piedra extends Obstaculo {
    private int durabilidad;

    public Piedra(float posicionX, float posicionY, float posicionZ, int ancho, int alto,
            boolean existe, BufferedImage spriteActual, int durabilidad) {
        super(true, true, true, posicionX, posicionY, posicionZ, 32, 32, existe,
                ControladorSprites.getSprite(17, 145, 32, 32));
        this.durabilidad = durabilidad;

    }

    public void recibirDisparo() {
        if (isDestructible() && durabilidad > 0) {
            durabilidad--;
            if (durabilidad <= 0) {
                romper();
            }
        }
    }

    private void romper() {
        setBloqueaPersonaje(false);
        setBloqueaProyectil(false);
        setExiste(false);
    }

    private int getDurabilidad() {
        return durabilidad;
    }

    public void setDurabilidad(int durabailidad) {
        this.durabilidad = durabilidad;
    }

}
