package modelo.items;

import modelo.entidades.Heroe;

public class MejoraCadencia extends Item implements Efecto{
    
    private final int decrementoCadencia = 2; //cuantos ticks de espera le saca cada vez que se aplica

    public MejoraCadencia(String nombreItem, String descripcionItem, Integer precioItem){
        super(nombreItem, descripcionItem, precioItem);
    }
    @Override 
    public void aplicarEfecto(Heroe heroe) {
        int cadenciaActual = heroe.getCadencia();
        int nuevaCadencia = cadenciaActual - decrementoCadencia;

        if (nuevaCadencia < 1) {
            nuevaCadencia = 1;
        }
        heroe.setCadencia(nuevaCadencia);
    }
}
