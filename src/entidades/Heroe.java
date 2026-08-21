package entidades;

public class Heroe extends Personaje {

    private Integer vidaMaxima;
    private Integer mana;

    public Heroe(String nombre, Integer vida, double velocidad, Integer cadencia, Integer dano, Float posicionX,
            Float posicionY,
            Integer tamanoHeight, Integer tamanoWidth, Integer vidaMaxima, Integer mana) {

        super(nombre, vida, velocidad, cadencia, dano, posicionX, posicionY, tamanoHeight, tamanoWidth); // heredacion
                                                                                                         // toda
                                                                                                         // mugrienta
        if (vidaMaxima <= 0 || vidaMaxima > 250) {
            throw new IllegalArgumentException("vida maxima invalida algo rompiste");
        }
        if (mana <= 0 || mana > 100) {
            throw new IllegalArgumentException("valor de mana invalida algo rompiste");
        }

        // thises mugrientos

        this.vidaMaxima = vidaMaxima;
        this.mana = mana;
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

    // Esto hace que el PJ recupere mana cada vez que mate enemigos

   public void recuperarMana (Integer cantidadRestaurada){
        if (cantidadRestaurada == null || cantidadRestaurada <=0){
            return;
        }
        this.mana += cantidadRestaurada;
        //Consistencia de tope max = 100
        if (this.mana > 100){
            this.mana = 100;
        }
    }
// como dice el nombre
    public boolean gastarMana(Integer costoMana){
        if (costoMana == null || costoMana <=0){
            return false;
        }
        //Consistencia de mana que no puede bajar a 0
        if (this.mana >= costoMana){
            this.mana -= costoMana;
            return true; 
        }
        return false; 
    }
}