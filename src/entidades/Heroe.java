package entidades;

public class Heroe extends Personaje {
    private String nombre;
    private Integer vidaMaxima;
    private Integer mana;

    public Heroe(Integer vida, double velocidad, Integer cadencia, Integer dano, Float posicionX, Float posicionY,
            Integer tamanoHeight, Integer tamanoWidth, String nombre, Integer vidaMaxima, Integer mana) {

        super(vida, velocidad, cadencia, dano, posicionX, posicionY, tamanoHeight, tamanoWidth); // heredacion toda
                                                                                                 // mugrienta
        if (nombre.isEmpty() || nombre == null) {
            throw new IllegalArgumentException("nombre invalido wacho");
        }
        if (vidaMaxima <= 0 || vidaMaxima > 250) {
            throw new IllegalArgumentException("vida maxima invalida algo rompiste");
        }
        if (mana <= 0 || mana > 100) {
            throw new IllegalArgumentException("valor de mana invalida algo rompiste");
        }

        // thises mugrientos

        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.mana = mana;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Boolean setNombre(String nombre) {
        if (nombre.isEmpty() || nombre == null) {
            return false;
        }
        this.nombre = nombre;
        return true;
    }

    public Integer getVidaMaxima() {
        return this.vidaMaxima;
    }

    public Boolean setVidaMaxima(Integer vidaMaxima) {
        if (vidaMaxima <= 0 || vidaMaxima > 250) {
            return false;
        }
        this.vidaMaxima = vidaMaxima;
        return true;
    }

    public Integer getMana() {
        return this.mana;
    }

    public Boolean setMana(Integer mana) {
        if (mana <= 0 || mana > 100) {
            return false;
        }
        this.mana = mana;
        return true;
    }
}
