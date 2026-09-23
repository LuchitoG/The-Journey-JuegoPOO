package modelo.item;
import java.awt.image.BufferedImage;
import controlador.ControladorSprites;
import modelo.entidades.Heroe;

public class Botiquin extends Item implements Efecto {

    private final Integer incrementoVida = 25;

    public Botiquin(String nombreItem, String descripcionItem, Integer precioItem, float posicionX, float posicionY, float posicionZ, int ancho, 
        int alto, boolean existe, BufferedImage spriteActual) {
        super(nombreItem, descripcionItem, precioItem,posicionX, posicionY, posicionZ, alto, ancho, existe, spriteActual);

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

