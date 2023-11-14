import javax.swing.*;
import java.awt.*;


public class TestImage {
    public static void main(String[] args) {

        /**
         * Testeo exitoso
         * La ruta de recursos de es correcta
         */
        // Carga la imagen desde el directorio de recursos
        ImageIcon imageIcon = new ImageIcon(TestImage.class.getResource("/RegistroCorrecto.png"));

        // Crea un JLabel y establece la imagen como su icono
        JLabel label = new JLabel(imageIcon);

        // Crea un JFrame para mostrar la imagen
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 500);
        frame.add(label, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

