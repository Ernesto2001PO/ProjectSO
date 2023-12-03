import javax.swing.*;
import java.awt.*;

public class TestImageLoading {

    public static void main(String[] args) {
        // Cargar la imagen
        ImageIcon imagenPareja = new ImageIcon(TestImageLoading.class.getResource("/Pareja.jpg"));

        // Crear un JLabel con el ImageIcon
        JLabel label = new JLabel(imagenPareja);

        // Crear un JFrame para mostrar el JLabel
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.add(label);
        frame.setVisible(true);
    }
}