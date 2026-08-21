package controlador;

import java.awt.image.BufferedImage;

public class ControladorSprites {

    private BufferedImage[] sprites;
    private int indiceActual = 0;

    // contador de ticks para trackear tiempo
    private int Ticks = 0;
    private int velAnimacion; // Cantidad de ticks para cambiar de sprite
    private boolean enPausa = false;

    public ControladorSprites(BufferedImage[] sprites, int velAnimacion) {
        this.sprites = sprites;
        this.velAnimacion = velAnimacion;
    }

    public void actualizar() {
        if (enPausa || sprites == null || sprites.length <= 1) // actualiza al siguiente frame del sprite
            return;

        Ticks++;
        if (Ticks >= velAnimacion) {
            Ticks = 0;
            nextSprite();
        }
    }

    public void nextSprite() {
        if (sprites != null && sprites.length > 0) {
            indiceActual = (indiceActual + 1) % sprites.length;
        }
    }

    public BufferedImage getSprite() {
        if (sprites == null || sprites.length == 0)
            return null;
        return sprites[indiceActual];
    }

    public void reiniciar() {
        this.indiceActual = 0;
        this.Ticks = 0;
    }

    public void setPausa(boolean enPausa) {
        this.enPausa = enPausa;
    }

    public void setVelocidadAnimacion(int velocidad) {
        this.velAnimacion = velocidad;
    }
}