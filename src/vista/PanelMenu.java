package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenu extends JPanel{

    private JButton botonJugar;
    
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
        labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 58));
        labelTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        botonJugar = new JButton("Jugar");
        JButton botonRanking = new JButton("Ranking");
        JButton botonOpciones = new JButton("Opciones");
        JButton botonCreditos = new JButton("Creditos");
        

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

    public JButton getBotonJugar() {
        return botonJugar;
    }

}
