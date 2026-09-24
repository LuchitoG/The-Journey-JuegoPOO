package modelo.entidades;

import java.awt.image.BufferedImage;
import modelo.Direccion;
import modelo.GameObject;

public abstract class Proyectil extends GameObject{

    private double velocidadProyectil;
    private Integer danoProyectil;
    private Direccion direccion;
    private Personaje dueño;


    public Proyectil(float posicionX, float posicionY, float posicionZ, int ancho, int alto, boolean existe, BufferedImage spriteActual, double velocidadProyectil, Integer danoProyectil, Direccion direccion, Personaje dueno) {
        super(posicionX, posicionY, posicionZ, ancho, alto, existe, spriteActual);

        


    }

    // Getters

    public double getVelocidadProyectil() {
        return velocidadProyectil;
    }

    public Integer getDanoProyectil() {
        return danoProyectil;
    }

/* 
    // Setters no van, tengo entendido que bugean las "fisicas" de la bala, despues
    // preguntar bien a los profes

    // Actualizacion de posicion por cada frame

    public void actualizarPosicion(float nuevoX, float nuevoY) {
        this.posicionX = nuevoX;
        this.posicionY = nuevoY;
    }
    // No es complejo de pensar, pero tuve que usar IA pq no supe como implementarlo
    // (era una re pavada)

    //Los proyectiles van todo recto para eso usaremos una formula matematica algebraica * arostotelica analitica geometrica angular fisica * no binarie menta granizada

    public void mover() {
        // Formula: Posicion Actual + (Direccion # Velocidad)
        // Aprendan Albert Epstein y Estifen fukin (dea)
        float nuevoX = (float) (this.posicionX + (this.direccionX * this.velocidadProyectil));
        float nuevoY = (float) (this.posicionY + (this.direccionY * this.velocidadProyectil));

        this.actualizarPosicion(nuevoX, nuevoY);
    }

    // Ahora se viene la matematica de las colisiones, voy a usar AABB, busquenlo como matematica de la colision (AABB) el mismo tiene 4 premisas, aca las implemento, un saludo al indio alibaba ingeniero de chutub
     

    public boolean colisionProyectil(Personaje objetivo) {
        if (objetivo == null)
            return false;

        boolean colisionX = this.posicionX < (objetivo.getPosicionX() + objetivo.getAncho()) &&
                (this.posicionX + this.tamanoWidth) > objetivo.getPosicionX();

        boolean colisionY = this.posicionY < (objetivo.getPosicionY() + objetivo.getAlto()) &&
                (this.posicionY + this.tamanoHeight) > objetivo.getPosicionY();

        return colisionX && colisionY;
    }

    // Verifica si la bala salio completamente de los bordes de la pantalla
    public boolean estaFueraDePantalla(int anchoPantalla, int altoPantalla) {
        return this.posicionX < 0 || this.posicionX > anchoPantalla ||
                this.posicionY < 0 || this.posicionY > altoPantalla;
    } */

}