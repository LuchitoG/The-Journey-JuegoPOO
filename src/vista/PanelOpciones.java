package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import utilidades.GestorFuentes;

public class PanelOpciones extends JPanel{

    private JLabel labelVolumen;
    private JSlider sliderVolumen;

    public PanelOpciones() {
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(20, 10, 35));

        labelVolumen = new JLabel("Volumen");
        labelVolumen.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelVolumen.setFont(GestorFuentes.getFuente(50f));
        labelVolumen.setForeground(Color.YELLOW);

        sliderVolumen = new JSlider(0, 100, 50);
        sliderVolumen.setOpaque(false);
        sliderVolumen.setForeground(Color.WHITE);
        sliderVolumen.setFont(GestorFuentes.getFuente(30f));
        sliderVolumen.setMajorTickSpacing(25);
        sliderVolumen.setPaintTicks(true);
        sliderVolumen.setPaintLabels(true);
        sliderVolumen.setMaximumSize(new Dimension(500, 60));
        sliderVolumen.setAlignmentX(Component.CENTER_ALIGNMENT);


        this.add(Box.createVerticalStrut(20));
        this.add(labelVolumen);
        this.add(Box.createVerticalStrut(20));
        this.add(sliderVolumen);
        this.add(Box.createVerticalGlue());

    }

    public JSlider getSliderVolumen() {
        return this.sliderVolumen;
    }

}
