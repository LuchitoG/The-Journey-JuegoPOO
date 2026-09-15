package modelo;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class GameObject implements Colisionable {
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

    @Override
    public float getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(float posicionX) {
        this.posicionX = posicionX;
    }

    @Override
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

    @Override
    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    @Override
    public int getAlto() {
        return alto;
    }

    @Override
    public Rectangle getLimites() {
        return new Rectangle((int) getPosicionX(), (int) getPosicionY(), getAncho(), getAlto());
    }

    @Override
    public boolean colisionaCon(Colisionable otro) {
        if (otro == null) {
            return false;
        }
        return this.getLimites().intersects(otro.getLimites());
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
