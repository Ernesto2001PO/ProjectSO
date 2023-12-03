import javax.swing.*;
import java.awt.*;

public class WindowTwo extends JFrame {

    private JPanel panelMatriz;
    private Couple [][] matrizParejas;

    public WindowTwo(Couple [][] matrizParejas) {
        this.matrizParejas = matrizParejas;

        setTitle("Ventana dos - Matriz de parejas");
        setSize(600, 600); // Tamaño de la ventana principal
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout()); // Establecer el layout de la ventana como BorderLayout

        initComponents();

    }

    private void initComponents() {

        // Cargar la imagen de fondo en un ImageIcon
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/FondoPista.jpg"));

        // Crear un JLabel con el ImageIcon
        JLabel labelFondo = new JLabel(imagenFondo);

        // Establecer el tamaño del JLabel para que coincida con el tamaño de la imagen
        labelFondo.setBounds(0, 0, imagenFondo.getIconWidth(), imagenFondo.getIconHeight());

        // Cargar la imagen en un ImageIcon
        ImageIcon imagenDj = new ImageIcon(getClass().getResource("/Dj.jpg"));

        // Escalar la imagen
        Image image = imagenDj.getImage();
        Image scaledImage = image.getScaledInstance(400, 100, Image.SCALE_SMOOTH);
        imagenDj = new ImageIcon(scaledImage);

        // Crear un JLabel con el ImageIcon
        JLabel imageLabel = new JLabel(imagenDj);

        // Crear un panel para mostrar la matriz
        panelMatriz = new JPanel(new GridLayout(matrizParejas.length, matrizParejas[0].length));
        panelMatriz.setPreferredSize(new Dimension(400, 400)); // Tamaño de la matriz

        // Cargar la imagen de la pareja en un ImageIcon
        ImageIcon imagenPareja = new ImageIcon(getClass().getResource("/Pareja.jpg"));

        // Escalar la imagen
        Image imagePareja = imagenPareja.getImage();
        Image scaledImagePareja = imagePareja.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        imagenPareja = new ImageIcon(scaledImagePareja);


        // Recorrer la matriz y agregar etiquetas JLabel al panel para mostrar la matriz
        for (int i = 0; i < matrizParejas.length; i++) {
            for (int j = 0; j < matrizParejas[0].length; j++) {
                JLabel label;
                if (matrizParejas[i][j] != null) {
                    // Si hay una pareja en esta posición, muestra la imagen de la pareja
                    label = new JLabel(imagenPareja);
                   // Establece el tooltip del JLabel con los nombres de la pareja
                    label.setToolTipText(matrizParejas[i][j].getNameBoy() + " y " + matrizParejas[i][j].getNameGirl());




                } else {
                    // Si no hay una pareja en esta posición, muestra un JLabel con un color de fondo específico
                    label = new GradientLabel("Vacio", Color.BLUE, Color.WHITE);

                }

                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);

                panelMatriz.add(label);
            }
        }

        // Agrega el JLabel de la imagen y el panel de la matriz al JLabel de fondo
        labelFondo.setLayout(new BorderLayout());
        labelFondo.add(imageLabel, BorderLayout.NORTH);
        labelFondo.add(panelMatriz, BorderLayout.CENTER);

        // Agrega el JLabel de fondo a la ventana
        add(labelFondo);

        // Llama a repaint y revalidate para actualizar el panel de la matriz
        panelMatriz.repaint();
        panelMatriz.revalidate();
    }
    public void updateWindow() {
        // Elimina todos los componentes del panel de la matriz
        panelMatriz.removeAll();

        // Recrea la matriz y agrega los componentes al panel de la matriz
        initComponents();

        // Actualiza la interfaz gráfica de usuario
        panelMatriz.repaint();
        panelMatriz.revalidate();
    }

}
