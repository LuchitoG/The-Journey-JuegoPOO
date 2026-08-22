package entidades;

public abstract class Enemigo extends Personaje {

    private double probabilidadDrop;
    private Integer manaMinimo;
    private Integer manaMaximo;

    public Enemigo(String nombre, Integer vida, double velocidad, Integer cadencia, Integer dano, Float posicionX,
            Float posicionY, Integer tamanoHeight, Integer tamanoWidth, double probabilidadDrop, Integer manaMinimo,
            Integer manaMaximo) {
        super(nombre, vida, velocidad, cadencia, dano, posicionX, posicionY, tamanoHeight, tamanoWidth);
        // TODO Auto-generated constructor stub

        if (probabilidadDrop < 0.0 || probabilidadDrop > 1.0)
            throw new IllegalArgumentException("Probabilidad de drop inválida");

        if (manaMinimo == null || manaMinimo < 0 || manaMaximo == null || manaMaximo > 100 || manaMinimo > manaMaximo)
            throw new IllegalArgumentException("Rango de drop de mana inváido");

        this.probabilidadDrop = probabilidadDrop;
        this.manaMinimo = manaMinimo;
        this.manaMaximo = manaMaximo;
    }

    public double getProbabilidadDrop() {
        return probabilidadDrop;
    }

    // ahora me hago la mecanica de dropear loot, dsp fijarse si esta bien planteada
    // Dont forget, iam with you in the dark
    public boolean dropearItem() {
        return Math.random() <= this.probabilidadDrop;
    }
    // math random siempre devuelve un double entre 0.0 a 0.9999

    // ahora casi lo mismo pero con mana

    public Integer dropearMana() {
        if (this.manaMinimo == 0) {
            return 0;
        }
        int cantidadDeOpciones = (this.manaMaximo - this.manaMinimo) + 1;
        return (int) (Math.random() * cantidadDeOpciones) + this.manaMinimo;
    }
}
