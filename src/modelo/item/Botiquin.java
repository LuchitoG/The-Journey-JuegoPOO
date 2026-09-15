package modelo.item;

import controlador.ControladorSprites;
import modelo.entidades.Heroe;

public class Botiquin extends Item implements Efecto {

    private final Integer incrementoVida = 25;

    public Botiquin(String nombreItem, String descripcionItem, Integer precioItem) {
        super(nombreItem, descripcionItem, precioItem);
        ControladorSprites.getSprite(33, 81, 16, 16);
    }
    
    @Override
    public void aplicarEfecto(Heroe heroe) {
        int nuevaVida = heroe.getVida() + incrementoVida;

        if (nuevaVida > heroe.getVidaMaxima()) {
            nuevaVida = heroe.getVidaMaxima();
        }

        heroe.setVida(nuevaVida);
    }

}

