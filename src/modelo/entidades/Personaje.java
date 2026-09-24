package modelo.entidades;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import modelo.Direccion;
import modelo.GameObject;

public abstract class Personaje extends GameObject{

    private Integer vida;
    private double velocidad;
    private Integer cadencia;
    private List<BufferedImage> listaSprites;
    private Integer dano;
    private String sfxAtaque;
    private String sfxMuerte;
    private Direccion direccion;

    public Personaje(float posicionX, float posicionY, float posicionZ, int ancho, int alto, boolean existe, BufferedImage spriteActual, Integer vida, double velocidad, Integer cadencia, Integer dano, Direccion direccion) {
        super(posicionX, posicionY, posicionZ, ancho, alto, existe, spriteActual);

        this.vida = vida;
        this.velocidad = velocidad;
        this.cadencia = cadencia;
        this.listaSprites = new ArrayList<>();
        this.dano = dano;
        this.sfxAtaque = sfxAtaque;
        this.sfxMuerte = sfxMuerte;
        this.direccion = direccion;

    }

    // getters y setters
    public Integer getVida() {
        return vida;
    }

    public Boolean setVida(Integer vida) {
        if (vida == null || vida == 0) {
            return false;
        }
        this.vida = vida;
        return true;
    }
    public double getVelocidad() {
        return velocidad;
    }

    public Boolean setVelocidad(double velocidad) {
        if (velocidad <= 0.0) {
            return false;
        }
        this.velocidad = velocidad;
        return true;
    }

    public Integer getCadencia() {
        return cadencia;
    }

    public Boolean setCadencia(Integer cadencia) {
        if (cadencia == null || cadencia == 0) {
            return false;
        }
        this.cadencia = cadencia;
        return true;
    }

    /*
     * public Sprite getlistaSprite() {
     * return listaSprite;
     * }
     * 
     * public Sprite setlistaSprite() {
     * this.listaSprite = listaSprite;
     * }
     */

    public Integer getDano() {
        return dano;
    }

    public Boolean setDano(Integer dano) {
        if (dano == null || dano <= 0) {
            return false;
        }
        this.dano = dano;
        return true;
    }
    /*
     * public Sfx getSfxMuerte() {
     * return sfxMuerte;
     * }
     * 
     * public Sfx setSfxMuerte() {
     * this.sfxMuerte = sfxMuerte;
     * }
     */



    /*
     * public direccion getDireccion() {
     * return direccion;
     * }
     * 
     * public direccion setDireccion() {
     * this.direccion = direccion;
     * }
     */


    // METODOS PADRES

    public void atacar(Personaje objetivo) {
        objetivo.recibirDano(dano);
    }

    public void recibirDano(Integer dano) {
        this.vida -= dano;
    }

    public boolean estaMuerto() {
        return vida <= 0;
    }


}
