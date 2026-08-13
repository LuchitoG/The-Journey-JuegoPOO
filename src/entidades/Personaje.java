package entidades;

public class Personaje {

    private int vida; // current hp 
    private int vidaMaxima; // containers de corazon
    private int danio;
    private int velocidad;
    private double fireRate; // disparos por segundo o cooldown

    // Constructor completo
    public Personaje(int vidaMaxima, int vida, int danio, int velocidad, double fireRate) {
        this.vidaMaxima = vidaMaxima;
        this.vida = vida; 
        this.danio = danio;
        this.velocidad = velocidad;
        this.fireRate = fireRate;
    }

    // getters y setters

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public double getFireRate() {
        return fireRate;
    }

    public void setFireRate(double fireRate) {
        this.fireRate = fireRate;
    }
}