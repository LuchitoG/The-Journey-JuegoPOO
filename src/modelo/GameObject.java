package modelo;

import java.awt.image.BufferedImage;

public abstract class GameObject {
    private float posicionX;
    private float posicionY;
    private float posicionZ;
    private int ancho;
    private int alto;
    private boolean existe;
    private BufferedImage spriteActual;

    public GameObject(float posicionX, float posicionY, float posicionZ, int ancho, int alto, boolean existe,
            BufferedImage spriteActual) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.posicionZ = posicionZ;
        this.ancho = ancho;
        this.alto = alto;
        this.existe = existe;
        this.spriteActual = spriteActual;
    }

    public float getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(float posicionX) {
        this.posicionX = posicionX;
    }

    public float getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(float posicionY) {
        this.posicionY = posicionY;
    }

    public float getPosicionZ() {
        return posicionZ;
    }

    public void setPosicionZ(float posicionZ) {
        this.posicionZ = posicionZ;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public BufferedImage getSprite() {
        return spriteActual;
    }

    public void setSprite(BufferedImage spriteActual) {
        this.spriteActual = spriteActual;
    }
}
