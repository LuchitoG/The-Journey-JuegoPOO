package entidades;

public abstract class Personaje {

    private String nombre;
    private Integer vida; // current hp
    private double velocidad;
    private Integer cadencia;
    // private Sprite listaSprite;
    // private Sprite spriteActual;
    private Integer dano;
    // private Sfx sfxAtaque;
    // private Sfx sfxMuerte;
    private Float posicionX;
    private Float posicionY;
    // private direccion direccion;
    private Integer tamanoHeight;
    private Integer tamanoWidth;
    // constructor con los atributos que estan comentados

    // public Personaje(Integer vida, double velocidad, Integer cadencia, Sprite
    // listaSprite, Sprite spriteActual, Integer dano, Sfx sfxAtaque, Sfx sfxMuerte,
    // Float posicionX, Float posicionY, direccion direccion, Integer tamanoHeight,
    // Integer tamanoWidth) {

    public Personaje(String nombre, Integer vida, double velocidad, Integer cadencia, Integer dano, Float posicionX,
            
            
            Float posicionY,
            Integer tamanoHeight, Integer tamanoWidth) {
 
        // CONSISTENCIA DE ATRIBUTOS 
        if (nombre == null || nombre.isEmpty() || nombre.length() > 30) {
            throw new IllegalArgumentException("nombre invalido");
        }
        if (vida == null || vida == 0) {
            throw new IllegalArgumentException("valor de vida invalida");
        }

        if (velocidad <= 0.0) {
            throw new IllegalArgumentException("valor de velocidad invalido");
        }

        if (cadencia == null || cadencia == 0) {
            throw new IllegalArgumentException("valor de cadencia invalido");
        }

        if (dano == null || dano <= 0) {
            throw new IllegalArgumentException("valor de dano invalido");
        }

        if (posicionX == null) {
            throw new IllegalArgumentException("posicionX invalida");
        }

        if (posicionY == null) {
            throw new IllegalArgumentException("posicionY invalida");
        }

        if (tamanoHeight == null || tamanoHeight <= 0) {
            throw new IllegalArgumentException("valor de altura invalido");
        }

        if (tamanoWidth == null || tamanoWidth <= 0) {
            throw new IllegalArgumentException("valor de ancho invalido");
        }

        // this todos mugrientos jaja

        this.nombre = nombre;
        this.vida = vida;
        this.velocidad = velocidad;
        this.cadencia = cadencia;
        // this.listaSprite = listaSprite;
        // this.spriteActual = spriteActual;
        this.dano = dano;
        // this.sfxAtaque = sfxAtaque;
        // this.sfxMuerte = sfxMuerte;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        // this.direccion = direccion;
        this.tamanoHeight = tamanoHeight;
        this.tamanoWidth = tamanoWidth;
    }

    // getters y setters
public String getNombre(){
        return nombre;
    }
    public Integer getVida() {
        return vida;
    }
    public boolean setNombre(String nombre){
         if (nombre == null || nombre.isEmpty() || nombre.length() > 30){
            return false;
        }
        this.nombre = nombre;
        return true;
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

    public Float getPosicionX() {
        return posicionX;
    }

    public Boolean setPosicionX(Float posicionX) {
        if (posicionX == null) {
            return false;
        }
        this.posicionX = posicionX;
        return true;
    }

    public Float getPosicionY() {
        return posicionY;
    }

    public Boolean setPosicionY(Float posicionY) {
        if (posicionY == null) {
            return false;
        }
        this.posicionY = posicionY;
        return true;
    }
    /*
     * public direccion getDireccion() {
     * return direccion;
     * }
     * 
     * public direccion setDireccion() {
     * this.direccion = direccion;
     * }
     */

    public Integer getTamanoHeight() {
        return tamanoHeight;
    }

    public Boolean setTamanoHeight(Integer tamanoHeight) {
        if (tamanoHeight == null || tamanoHeight <= 0) {
            return false;
        }
        this.tamanoHeight = tamanoHeight;
        return true;
    }

    public Integer getTamanoWidth() {
        return tamanoWidth;
    }

    public Boolean setTamanoWidth(Integer tamanoWidth) {
        if (tamanoWidth == null || tamanoWidth <= 0) {
            return false;
        }
        this.tamanoWidth = tamanoWidth;
        return true;
    }

    // METODOS PADRES

    public void atacar(Personaje objetivo) {
        objetivo.recibirDano(dano);
    }

    public void recibirDano(Integer dano) {
        this.vida -= dano;
    }

    public boolean estaMuerto() {
        return vida < 0;
    }

}
