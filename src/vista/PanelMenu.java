package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenu extends JPanel{

    JButton botonJugar, botonRanking, botonOpciones, botonCreditos;
    
    public PanelMenu() {
        this.setLayout(new GridLayout(1, 2));
        this.setBackground(new Color(20,10,35));

        // MITAD IZQUIERDA
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setOpaque(false); // Para que no tenga fondo
        // ACA ESTARIA EL PERSONAJE

        // MITAD DERECHA
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        panelDerecho.setOpaque(false); 

        JLabel labelTitulo = new JLabel("The Journey");
        labelTitulo.setForeground(Color.WHITE);
        labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 80));
        labelTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);


        Dimension dimensionBotones = new Dimension(400, 60);
        this.botonJugar = new JButton("Jugar");
        botonJugar.setFont(new Font("Monospaced", Font.BOLD, 32));
        botonJugar.setPreferredSize(dimensionBotones);
        botonJugar.setMinimumSize(dimensionBotones);
        botonJugar.setMaximumSize(dimensionBotones);

        this.botonRanking = new JButton("Ranking");
        botonRanking.setFont(new Font("Monospaced", Font.BOLD, 32));
        botonRanking.setPreferredSize(dimensionBotones);
        botonRanking.setMinimumSize(dimensionBotones);
        botonRanking.setMaximumSize(dimensionBotones);

        this.botonOpciones = new JButton("Opciones");
        botonOpciones.setFont(new Font("Monospaced", Font.BOLD, 32));
        botonOpciones.setPreferredSize(dimensionBotones);
        botonOpciones.setMinimumSize(dimensionBotones);
        botonOpciones.setMaximumSize(dimensionBotones);

        this.botonCreditos = new JButton("Creditos");
        botonCreditos.setFont(new Font("Monospaced", Font.BOLD, 32));
        botonCreditos.setPreferredSize(dimensionBotones);
        botonCreditos.setMinimumSize(dimensionBotones);
        botonCreditos.setMaximumSize(dimensionBotones);

        panelDerecho.add(Box.createVerticalGlue());
        panelDerecho.add(labelTitulo);
        panelDerecho.add(Box.createVerticalStrut(40));
        panelDerecho.add(botonJugar);
        panelDerecho.add(Box.createVerticalStrut(20));
        panelDerecho.add(botonRanking);
        panelDerecho.add(Box.createVerticalStrut(20));
        panelDerecho.add(botonOpciones);
        panelDerecho.add(Box.createVerticalStrut(20));
        panelDerecho.add(botonCreditos);
        panelDerecho.add(Box.createVerticalGlue());
        


        this.add(panelIzquierdo);
        this.add(panelDerecho);
    }

    public JButton getBotonJugar(){
        return this.botonJugar;
    }
    public JButton getBotonRanking(){
        return this.botonRanking;
    }
    public JButton getBotonOpciones(){
        return this.botonOpciones;
    }
    public JButton getBotonCreditos(){
        return this.botonCreditos;
    }
}
