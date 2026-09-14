package modelo;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.Map;
import modelo.entidades.Enemigo;
import modelo.obstaculos.Obstaculo;

public class Habitacion {
    private Image spriteDeFondo;
    private List<Obstaculo> listaObstaculos;
    private List<Enemigo> listaEnemigos;
    private Map<Direccion, Point2D.Float> mapaSpawn;
    private Direccion puertaPorLaQueSali;

    public Habitacion(Image spriteDeFondo, List<Obstaculo> listaObstaculos,
            List<Enemigo> listaEnemigos, Map<Direccion, Point2D.Float> mapaSpawn,
            Direccion puertaPorLaQueSali) {
        this.spriteDeFondo = spriteDeFondo;
        this.listaObstaculos = listaObstaculos;
        this.listaEnemigos = listaEnemigos;
        this.mapaSpawn = mapaSpawn;
        this.puertaPorLaQueSali = puertaPorLaQueSali;
    }

    public Image getSpriteDeFondo() {
        return spriteDeFondo;
    }

    public void setSpriteDeFondo(Image spriteDeFondo) {
        this.spriteDeFondo = spriteDeFondo;
    }

    public List<Obstaculo> getListaObstaculos() {
        return listaObstaculos;
    }

    public void setListaObstaculos(List<Obstaculo> listaObstaculos) {
        this.listaObstaculos = listaObstaculos;
    }

    public List<Enemigo> getListaEnemigos() {
        return listaEnemigos;
    }

    public void setListaEnemigos(List<Enemigo> listaEnemigos) {
        this.listaEnemigos = listaEnemigos;
    }

    public Map<Direccion, Point2D.Float> getMapaSpawn() {
        return mapaSpawn;
    }

    public void setMapaSpawn(Map<Direccion, Point2D.Float> mapaSpawn) {
        this.mapaSpawn = mapaSpawn;
    }

    public Direccion getPuertaPorLaQueSali() {
        return puertaPorLaQueSali;
    }

    public void setPuertaPorLaQueSali(Direccion puertaPorLaQueSali) {
        this.puertaPorLaQueSali = puertaPorLaQueSali;
    }
}
