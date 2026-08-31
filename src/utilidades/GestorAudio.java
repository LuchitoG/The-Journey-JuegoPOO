package utilidades;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;
import modelo.ModeloOpciones;

public class GestorAudio {

    // SINGLETON
    private static GestorAudio instance;
    
    // La musica de fondo que esta sonando en el momento
    private Clip musicaActual;

    // Las constantes con las rutas de los audios
    public static final String MUSICA_MENU = "/recursos/sonidos/NORTHERNLIGHT(menu).wav";
    public static final String SFX_HOVER = "/recursos/sonidos/hover.wav";
    public static final String SFX_CLICK = "/recursos/sonidos/click.wav";

    private GestorAudio() {
        
    }

    public static GestorAudio getInstance() {
        if (instance == null) {
            instance = new GestorAudio();
        }
        return instance;
    }

    // Reproduce una musica de fondo en bucle
    public void reproducirMusica(String rutaAudio) {
        detenerMusica(); // Detiene la cancion anterior
        
        try {
            URL url = getClass().getResource(rutaAudio);
            if (url != null) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
                musicaActual = AudioSystem.getClip();
                musicaActual.open(audioInput);
                
                // Aplicamos el volumen actual antes de darle play
                int volumenActual = ModeloOpciones.getInstance().getVolumen();
                aplicarVolumen(musicaActual, volumenActual);
                
                musicaActual.loop(Clip.LOOP_CONTINUOUSLY); 
                musicaActual.start();
            } else {
                System.err.println("No se encontró la música: " + rutaAudio);
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // Detiene la musica de fondo actual
    public void detenerMusica() {
        if (musicaActual != null && musicaActual.isRunning()) {
            musicaActual.stop();
            musicaActual.close();
        }
    }

    
    // Reproduce un efecto una sola vez
    public void reproducirEfecto(String rutaAudio) {
        try {
            URL url = getClass().getResource(rutaAudio);
            if (url != null) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
                Clip efecto = AudioSystem.getClip();
                efecto.open(audioInput);
                
                // Aplicamos el volumen actual antes de darle play
                int volumenActual = ModeloOpciones.getInstance().getVolumen();
                aplicarVolumen(efecto, volumenActual);
                
                efecto.start(); 
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    
    // Metodo que llama ModeloOpciones cuando el usuario mueve el Jslider, solo afecta a la musica que ya esta sonando
    public void setVolumenGlobal(int nuevoVolumen) {
        if (musicaActual != null && musicaActual.isRunning()) {
            aplicarVolumen(musicaActual, nuevoVolumen);
        }
    }

    
    //Convierte el 0 - 100 a decibelios y se lo aplica al clip
    private void aplicarVolumen(Clip clip, int volumen) {
        if (clip != null && clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl controlVolumen = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            
            if (volumen <= 0) {
                controlVolumen.setValue(-80f); // full silencio
            } else {
                // Conversion a decibelios
                float decibelios = (float) (Math.log10(volumen / 100.0) * 50.0);
                if (decibelios <= -80f) decibelios = -80f; // -80f es el minimo asi q hacemos esto para q no se rompa
                controlVolumen.setValue(decibelios);
            }
        }
    }
}