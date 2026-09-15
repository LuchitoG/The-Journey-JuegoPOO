package modelo.item;

import controlador.ControladorSprites;
import modelo.entidades.Personaje;

public class MejoraDano extends Item implements Efecto {
    private final double incrementoDano = 0.1;

    public MejoraDano(String nombreItem, String descripcionItem, Integer precioItem, Integer incrementoVida) {
        super(nombreItem, descripcionItem, precioItem);
        ControladorSprites.getSprite(1, 81, 32, 16);
    }

    @Override
    public void aplicarEfecto(Personaje personaje) {
        int incremento = personaje.getDano();

        double nuevoDano = incremento * (1.0 + incrementoDano); // le sumo el 10% al dano que tengo y lo guardo en nuevoDano que es double

        int nuevoDanoEntero = (int) Math.round(nuevoDano); // utilizo Math.round que me convierte el valor de dano de double a Integer y lo guardo

        personaje.setDano(nuevoDanoEntero);
    }
}
