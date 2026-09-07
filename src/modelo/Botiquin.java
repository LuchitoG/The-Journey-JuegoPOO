package modelo;

public class Botiquin extends Item implements Efecto {

    private Integer incrementoVida = 25;

    public Botiquin(String nombreItem, String descripcionItem, Integer precioItem, Integer incrementoVida) {
        super(nombreItem, descripcionItem, precioItem);
        if (incrementoVida == null || incrementoVida > 25) {
            throw new IllegalArgumentException("Valor de incremento de vida invalido");
        }
    }

    @Override
    public void aplicarEfecto(Integer vida) {
        vida = getVida();
        vida += 25;
        setVida(vida);
    }

}
