import javax.swing.*;
import java.awt.*;

class GradientLabel extends JLabel {
    private Color color1;
    private Color color2;

    public GradientLabel(String text, Color color1, Color color2) {
        super(text); // Convertir el objeto Couple en un String
        this.color1 = color1;
        this.color2 = color2;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        int width = getWidth();
        int height = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
        g2d.dispose();

        super.paintComponent(g);
    }
}