package modelo;

public class Enemigo extends Personaje {

    public Enemigo(String nombre, Integer vida, double velocidad, Integer cadencia, Integer dano, Float posicionX,
            Float posicionY, Integer tamanoHeight, Integer tamanoWidth) {
        super(nombre, vida, velocidad, cadencia, dano, posicionX, posicionY, tamanoHeight, tamanoWidth);
        // TODO Auto-generated constructor stub
    }

    // Encapsulamiento bros
    private double probabilidadDrop;

}
