package modelo.items;
import modelo.entidades.Heroe;

public class MejoraVidaMaxima extends Item implements Efecto {

    private final Integer incrementoVidaMaxima = 10;

    public MejoraVidaMaxima(String nombreItem, String descripcionItem, Integer precioItem){
        super(nombreItem, descripcionItem, precioItem);
    }
    @Override 
    public void aplicarEfecto(Heroe heroe) {
        int nuevaVidaMaxima = heroe.getVidaMaxima() + incrementoVidaMaxima;
        if (nuevaVidaMaxima > 250){
            nuevaVidaMaxima = 250;
        }
        heroe.setVidaMaxima(nuevaVidaMaxima);
    }
}
