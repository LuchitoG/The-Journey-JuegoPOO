package modelo.Items;

import modelo.entidades.Personaje;

public class MejoraCadencia extends Item implements Efecto{
    
    private final int decrmentoCadencia = 2; //cuantos ticks de espera le saca cada vez que se aplica

    public MejoraCadencia(String nombreItem, String descripcionItem, Integer precioItem){
        super(nombreItem, descripcionItem, precioItem);
    }
    @Override 
    public void aplicarEfecto(Personaje personaje) {
        int cadenciaActual = personaje.getCadencia();
        int nuevaCadencia = cadenciaActual - decrmentoCadencia;

        if (nuevaCadencia < 1) {
            nuevaCadencia = 1;
        }
        personaje.setCadencia(nuevaCadencia);
    }
}
