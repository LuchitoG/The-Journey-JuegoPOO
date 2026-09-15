package modelo.obstaculo;

import controlador.ControladorSprites;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Piedra extends Obstaculo {
    private int durabilidad;

    public Piedra(float posicionX, float posicionY, float posicionZ, int ancho, int alto,
            boolean existe, BufferedImage spriteActual, int durabilidad) {
        super(true, true, true, posicionX, posicionY, posicionZ, 32, 32, existe,
                ControladorSprites.getSprite(17, 145, 32, 32));
        this.durabilidad = durabilidad;

    }

    @Override
    public Rectangle getLimites() {
        /*         
        int hitboxX = (int) getPosicionX() + 4; //Desplaza la hitbox a la derecha
        int hitboxY = (int) getPosicionY() + 10; // desplaza la hitbox hacia abajo
        int hitboxAncho = getAncho() - 8; // reduce el ancho de la hitbox
        int hitboxAlto = getAlto() - 10;  // reduce el alto de hitbox
        */

        // mismo tamano que el sprite
        int hitboxX = (int) getPosicionX();
        int hitboxY = (int) getPosicionY();
        int hitboxAncho = getAncho();
        int hitboxAlto = getAlto();

        return new Rectangle(hitboxX, hitboxY, hitboxAncho, hitboxAlto);
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
