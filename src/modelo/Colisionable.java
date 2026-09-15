package modelo;

import java.awt.Rectangle;

public interface Colisionable {

    float getPosicionX();

    float getPosicionY();

    int getAncho();

    int getAlto();

    Rectangle getLimites();

    boolean colisionaCon(Colisionable otro);

}
