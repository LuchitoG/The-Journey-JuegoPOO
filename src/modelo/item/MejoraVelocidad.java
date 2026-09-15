package modelo.item;

import modelo.entidades.Heroe;

public class MejoraVelocidad extends Item implements Efecto {

    private final double incrementoVelocidad = 0.5;

    public MejoraVelocidad(String nombreItem, String descripcionItem, Integer precioItem) {
        super(nombreItem, descripcionItem, precioItem);
    }

    @Override
    public void aplicarEfecto(Heroe heroe) {
        double nuevaVelocidad = heroe.getVelocidad() + incrementoVelocidad;
        heroe.setVelocidad(nuevaVelocidad);
    }
}
