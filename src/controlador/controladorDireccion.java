package controlador;

public class ControladorDireccion {

    // Constantes para identificar las direcciones cardinales
    public static final int ARRIBA = 0;
    public static final int ABAJO = 1;
    public static final int IZQUIERDA = 2;
    public static final int DERECHA = 3;

    private int direccionActual;

    public ControladorDireccion() {
        this.direccionActual = ABAJO; // Dirección por defecto es abajo
    }

    public int getDireccionActual() {
        return direccionActual;
    }

    public void setDireccionActual(int direccionActual) {
        if (direccionActual >= ARRIBA && direccionActual <= DERECHA) {
            this.direccionActual = direccionActual;
        }
    }

    public boolean isArriba() {
        return direccionActual == ARRIBA;
    }

    public boolean isAbajo() {
        return direccionActual == ABAJO;
    }

    public boolean isIzquierda() {
        return direccionActual == IZQUIERDA;
    }

    public boolean isDerecha() {
        return direccionActual == DERECHA;
    }
}