package entidades;

public abstract class Proyectil {

    private float posicionX;
    private float posicionY;
    private double velocidadProyectil;
    private Integer danoProyectil;

    private double direccionX;
    private double direccionY;

    private Integer tamanoWidth;
    private Integer tamanoHeight;

    public Proyectil(float posicionX, float posicionY, double velocidadProyectil,
            Integer danoProyectil, double direccionX, double direccionY,
            Integer tamanoWidth, Integer tamanoHeight) {
        if (velocidadProyectil <= 0.0)
            throw new IllegalArgumentException("Velocidad de proyectil invalida");
        if (danoProyectil == null || danoProyectil <= 0)
            throw new IllegalArgumentException("Daño de proyectil invalido");
        if (tamanoHeight == null || tamanoHeight <= 0)
            throw new IllegalArgumentException("valor de altura del proyectil invalido");
        if (tamanoWidth == null || tamanoWidth <= 0)
            throw new IllegalArgumentException("valor de ancho del proyectil invalido");

        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.velocidadProyectil = velocidadProyectil;
        this.danoProyectil = danoProyectil;

        this.direccionX = direccionX;
        this.direccionY = direccionY;

        this.tamanoWidth = tamanoWidth;
        this.tamanoHeight = tamanoHeight;

    }

    // Getters

    public float getPosicionX() {
        return posicionX;
    }

    public float getPosicionY() {
        return posicionY;
    }

    public double getVelocidadProyectil() {
        return velocidadProyectil;
    }

    public Integer getDanoProyectil() {
        return danoProyectil;
    }

    public Integer getTamanoWidth() {
        return tamanoWidth;
    }

    public Integer getTamanoHeight() {
        return tamanoHeight;
    }

    // Setters no van, tengo entendido que bugean las "fisicas" de la bala, despues
    // preguntar bien a los profes

    // Actualizacion de posicion por cada frame

    public void actualizarPosicion(float nuevoX, float nuevoY) {
        this.posicionX = nuevoX;
        this.posicionY = nuevoY;
    }
    // No es complejo de pensar, pero tuve que usar IA pq no supe como implementarlo
    // (era una re pavada)

    /*
     * Los proyectiles van todo recto
     * para eso usaremos una formula matematica algebraica
     * arostotelica analitica geometrica angular fisica
     * no binarie menta granizada
     */
    public void mover() {
        // Formula: Posicion Actual + (Direccion # Velocidad)
        // Aprendan Albert Epstein y Estifen fukin (dea)
        float nuevoX = (float) (this.posicionX + (this.direccionX * this.velocidadProyectil));
        float nuevoY = (float) (this.posicionY + (this.direccionY * this.velocidadProyectil));

        this.actualizarPosicion(nuevoX, nuevoY);
    }

    /*
     * Ahora se viene la matematica de las colisiones,
     * voy a usar AABB, busquenlo como matematica de la colision (AABB)
     * el mismo tiene 4 premisas, aca las implemento, un saludo al indio alibaba
     * ingeniero de chutub
     */

    public boolean colisionProyectil(Personaje objetivo) {
        if (objetivo == null)
            return false;

        boolean colisionX = this.posicionX < (objetivo.getPosicionX() + objetivo.getTamanoWidth()) &&
                (this.posicionX + this.tamanoWidth) > objetivo.getPosicionX();

        boolean colisionY = this.posicionY < (objetivo.getPosicionY() + objetivo.getTamanoHeight()) &&
                (this.posicionY + this.tamanoHeight) > objetivo.getPosicionY();

        return colisionX && colisionY;
    }

}