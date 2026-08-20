package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelLogin extends JPanel{

    private JTextField textFieldLogin;
    private JButton botonJugar;


    public PanelLogin() {
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(20,10,35));

        JLabel labelLogin = new JLabel("Ingrese su nombre de usuario");
        labelLogin.setForeground(Color.WHITE);
        labelLogin.setFont(new Font("Monospaced", Font.BOLD, 24));
        labelLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.textFieldLogin = new JTextField();
        textFieldLogin.setPreferredSize(new Dimension(300,40));
        textFieldLogin.setMaximumSize(new Dimension(300,40));
        textFieldLogin.setFont(new Font("Monospaced", Font.BOLD, 20));
        textFieldLogin.setHorizontalAlignment(JTextField.CENTER);
        textFieldLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        this.botonJugar = new JButton("Jugar");
        botonJugar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonJugar.setPreferredSize(new Dimension(200,40));
        botonJugar.setMaximumSize(new Dimension(200,40));
        

        this.add(Box.createVerticalGlue());
        this.add(labelLogin);
        this.add(Box.createVerticalStrut(20));
        this.add(textFieldLogin);
        this.add(Box.createVerticalStrut(40));
        this.add(botonJugar);
        this.add(Box.createVerticalGlue());
    }

    public JButton getBotonJugar(){
        return this.botonJugar;
    }

}
