package modelo.item;

import modelo.entidades.Heroe;

import java.awt.image.BufferedImage;
public class MejoraVidaMaxima extends Item implements Efecto {

    private final Integer incrementoVidaMaxima = 10;

    public MejoraVidaMaxima(String nombreItem, String descripcionItem, Integer precioItem, float posicionX, float posicionY, float posicionZ, int ancho, 
        int alto, boolean existe, BufferedImage spriteActual) {
        super(nombreItem, descripcionItem, precioItem, posicionX, posicionY, posicionZ, ancho, 
     alto, existe, spriteActual);
    }

    @Override
    public void aplicarEfecto(Heroe heroe) {
        int nuevaVidaMaxima = heroe.getVidaMaxima() + incrementoVidaMaxima;
        if (nuevaVidaMaxima > 250) {
            nuevaVidaMaxima = 250;
        }
        heroe.setVidaMaxima(nuevaVidaMaxima);
    }
}
