package modelo.obstaculo;

import java.awt.image.BufferedImage;
import modelo.GameObject;

public abstract class Obstaculo extends GameObject {
    private boolean bloqueaPersonaje;
    private boolean bloqueaProyectil;
    private boolean destructible;

    public Obstaculo(boolean bloqueaPersonaje, boolean bloqueaProyectil, boolean destructible, float posicionX,
            float posicionY, float posicionZ, int ancho, int alto, boolean existe, BufferedImage spriteActual) {
        super(posicionX, posicionY, posicionZ, ancho, alto, existe, spriteActual);

        this.bloqueaPersonaje = bloqueaPersonaje;
        this.bloqueaProyectil = bloqueaProyectil;
        this.destructible = destructible;
    }

    public boolean isBloqueaPersonaje() {
        return bloqueaPersonaje;
    }

    public void setBloqueaPersonaje(boolean bloqueaPersonaje) {
        this.bloqueaPersonaje = bloqueaPersonaje;
    }

    public boolean isBloqueaProyectil() {
        return bloqueaProyectil;
    }

    public void setBloqueaProyectil(boolean bloqueaProyectil) {
        this.bloqueaProyectil = bloqueaProyectil;
    }

    public boolean isDestructible() {
        return destructible;
    }

    public void setDestructible(boolean destructible) {
        this.destructible = destructible;
    }
}
