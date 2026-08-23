package modelo;

import controlador.ControladorTeclado;

public class Heroe extends Personaje {

    private Integer vidaMaxima;
    private Integer mana;

    // el contador de ticks que hay que esperar para el siguiente disparo

    private int contadorCadencia = 0;

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

    public ProyectilHeroe intentarDisparar(ControladorTeclado teclado) {
        // controla el tiempo entre disparos
        if (contadorCadencia > 0) {
            contadorCadencia--;
            return null;
        }
        // si no se toca una tecla no hago nada xD
        if (!teclado.isDispararArriba() && !teclado.isDispararAbajo() & !teclado.isDispararIzq()
                && !teclado.isDispararDere()) {
            return null;
        }
        // la direccion a la que va a salir la bala
        double dirX = 0;
        double dirY = 0;

        if (teclado.isDispararArriba())
            dirY = -1;
        else if (teclado.isDispararAbajo())
            dirY = 1;
        else if (teclado.isDispararIzq())
            dirX = -1;
        else if (teclado.isDispararDere())
            dirX = 1;
        // reinicio el contadorCadencia para que no se rompa y no dispare nunca mas xD
        contadorCadencia = getCadencia();

        float centroX = getPosicionX() + (getTamanoWidth() / 2f);
        float centroY = getPosicionY() + (getTamanoHeight() / 2f);

        /*
         * STATS DEL PROYECTIL
         * luego vemos como aplicamos los powerups porque por ahora solo cambia aca con
         * constantes
         * seguro lo unico que hay que hacer es modificar eso dependiendo de las stats
         * del heroe
         * porque el heroe tiene stats de la bala que se modifican a cada rato
         */

        double velocidadBala = 8.0; // <---- se explica solo
        int tamanoBala = 10; // <---- se explica solo

        return new ProyectilHeroe(centroX, centroY, velocidadBala, getDano(), dirX, dirY, tamanoBala, tamanoBala);
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

    public void recuperarMana(Integer cantidadRestaurada) {
        if (cantidadRestaurada == null || cantidadRestaurada <= 0) {
            return;
        }
        this.mana += cantidadRestaurada;
        // Consistencia de tope max = 100
        if (this.mana > 100) {
            this.mana = 100;
        }
    }

    // como dice el nombre
    public boolean gastarMana(Integer costoMana) {
        if (costoMana == null || costoMana <= 0) {
            return false;
        }
        // Consistencia de mana que no puede bajar a 0
        if (this.mana >= costoMana) {
            this.mana -= costoMana;
            return true;
        }
        return false;
    }
}