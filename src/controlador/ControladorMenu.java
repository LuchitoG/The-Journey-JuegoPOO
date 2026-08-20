package controlador;

import vista.PanelCreditos;
import vista.PanelLogin;
import vista.PanelMenu;
import vista.PanelOpciones;
import vista.PanelRanking;
import vista.VistaPrincipal;

public class ControladorMenu {
    
    private PanelMenu panelMenu;

    private PanelLogin panelLogin;
    private PanelRanking panelRanking;
    private PanelOpciones panelOpciones;
    private PanelCreditos panelCreditos;

    private ControladorLogin controladorLogin;
    private ControladorRanking controladorRanking;
    private ControladorOpciones controladorOpciones;
    private ControladorCreditos controladorCreditos;

    public ControladorMenu(PanelMenu panelMenu) {
        this.panelMenu = panelMenu;
        this.panelMenu.getBotonJugar().addActionListener(e -> new ControladorJuego());
        VistaPrincipal.setPanelContenedor(panelMenu);

        this.panelMenu.getBotonJugar().addActionListener(e -> {
            System.out.println("Boton jugar");
            
            panelLogin = new PanelLogin();
            controladorLogin = new ControladorLogin(panelLogin);
        });


        this.panelMenu.getBotonRanking().addActionListener(e -> {
            System.out.println("Boton ranking");

            panelRanking = new PanelRanking();
            controladorRanking = new ControladorRanking(panelRanking);
        });


        this.panelMenu.getBotonOpciones().addActionListener(e -> {
            System.out.println("Boton opciones");

            panelOpciones = new PanelOpciones();
            controladorOpciones = new ControladorOpciones(panelOpciones);
        });


        this.panelMenu.getBotonCreditos().addActionListener(e -> {
            System.out.println("Boton creditos");

            panelCreditos = new PanelCreditos();
            controladorCreditos = new ControladorCreditos(panelCreditos);
        });


    }


}
