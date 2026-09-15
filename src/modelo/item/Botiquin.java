package modelo.item;

import controlador.ControladorSprites;
import modelo.entidades.Heroe;
import modelo.entidades.Personaje;

public class Botiquin extends Item implements Efecto {

    private final Integer incrementoVida = 25;

    public Botiquin(String nombreItem, String descripcionItem, Integer precioItem, Integer incrementoVida) {
        super(nombreItem, descripcionItem, precioItem);
        ControladorSprites.getSprite(33, 81, 16, 16);
        if (incrementoVida == null || incrementoVida > 25) {
            throw new IllegalArgumentException("Valor de incremento de vida invalido");
        }
    }

    @Override
    public void aplicarEfecto(Personaje personaje) {
        int incremento = personaje.getVida() + incrementoVida;

        if (personaje instanceof Heroe) { // antes de incremetar la vida me fijo que estoy incrementandole al modelo
                                          // hijo de personaje correcto ya que el heroe tiene definido la vida maxima y no queremos que se pase del limite
            Heroe heroe = (Heroe) personaje;
            if (incremento > heroe.getVidaMaxima()) {
                incremento = heroe.getVidaMaxima();
            }
            personaje.setVida(incremento);
        }
    }

}
