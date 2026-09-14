package modelo.obstaculos;

public class Puerta extends Obstaculo {

    public Puerta(float posicionX, float posicionY, float posicionZ, int ancho, int alto,
            boolean existe, BufferedImage spriteActual)
            super(false,true,false,posicionX, posicionY, posicionZ, ancho, alto, existe, spriteActual);
}
