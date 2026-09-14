package modelo.entidades;

public abstract class Item {
    
    private String nombreItem;
    private  String descripcionItem;
    //private Integer precio;
 
    public Item(String nombreItem, String descripcionItem, Integer precio) {

        if (nombreItem == null || nombreItem.isEmpty() || nombreItem.length() > 30){
            throw new  IllegalArgumentException("Nombre de ITEM invalido");
        }
        if (descripcionItem == null || descripcionItem.isEmpty() || descripcionItem.length() > 200){
            throw new  IllegalArgumentException("Descripcion de ITEM invalido");
        }
       /*  if (precio == null || precio <= 0 || precio >= 20){
            throw new  IllegalArgumentException("Precio de ITEM invalido");
        }*/

        this.nombreItem = nombreItem;
        this.descripcionItem = descripcionItem;
        //this.precio = precio;
    }

// getters y setters
    public String getNombreItem() {
        return nombreItem;
    }

    public String getDescripcionItem() {
        return descripcionItem;
    }

    /*public Integer getPrecio() {
        return precio;
    } */

    public boolean setNombreItem(String nombreItem) {
        if (nombreItem == null || nombreItem.isEmpty() || nombreItem.length() > 30) {
            return false;
        }
        this.nombreItem = nombreItem;
        return true;
    }
    public boolean setDescripcionItem(String descripcionItem) {
        if (descripcionItem == null || descripcionItem.isEmpty() || descripcionItem.length() > 200) {
            return false;
        }
        this.descripcionItem = descripcionItem;
        return true;
    }
    /* public Boolean setVida(Integer vida) {
        if (precio == null || precio <= 0 || precio >= 20) {
            return false;
        }
        this.precio = precio;
        return true;
    } */
        
}