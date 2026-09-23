package modelo.item;

import modelo.entidades.Heroe;

import java.awt.image.BufferedImage;
public class MejoraVelocidad extends Item implements Efecto {

    private final double incrementoVelocidad = 0.5;

    public MejoraVelocidad(String nombreItem, String descripcionItem, Integer precioItem, float posicionX, float posicionY, float posicionZ, int ancho, 
        int alto, boolean existe, BufferedImage spriteActual) {
        super(nombreItem, descripcionItem, precioItem, posicionX, posicionY, posicionZ, ancho, 
     alto, existe, spriteActual);
    }

    @Override
    public void aplicarEfecto(Heroe heroe) {
        double nuevaVelocidad = heroe.getVelocidad() + incrementoVelocidad;
        heroe.setVelocidad(nuevaVelocidad);
    }
}
