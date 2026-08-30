package modelo;

import utilidades.GestorAudio;

public class ModeloOpciones {

    private static ModeloOpciones instance;
    
    private int volumen;
    private boolean botonWasdK, botonFlechasF;

    private ModeloOpciones() {
        this.volumen = 50;

    }

    // SINGLETON
    public static ModeloOpciones getInstance() {
        if (instance == null) {
            instance = new ModeloOpciones();
        }
        return instance;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
        GestorAudio.getInstance().setVolumenGlobal(volumen);
    }

    public int getVolumen() {
        return this.volumen;
    }

}

