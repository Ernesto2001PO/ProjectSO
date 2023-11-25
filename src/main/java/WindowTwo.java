import javax.swing.*;
import java.awt.*;

public class WindowTwo extends JFrame {

    private JPanel panelMatriz;
    private String[][] matrizParejas;

    public WindowTwo(String[][] matrizParejas) {
        this.matrizParejas = matrizParejas;

        setTitle("Ventana dos - Matriz de parejas");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        panelMatriz = new JPanel(new GridLayout(matrizParejas.length, matrizParejas[0].length));

        // Recorrer la matriz y agregar etiquetas JLabel al panel para mostrar la matriz
        for (int i = 0; i < matrizParejas.length; i++) {
            for (int j = 0; j < matrizParejas[0].length; j++) {
                JLabel label = new JLabel(matrizParejas[i][j]);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde para visualizar las celdas
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                panelMatriz.add(label);
            }
        }

        add(panelMatriz);
    }

    // Método para actualizar la matriz mostrada en el panel
    public void actualizarVisualizacionMatriz(String[][] nuevaMatriz) {
        matrizParejas = nuevaMatriz;
        panelMatriz.removeAll(); // Elimina componentes anteriores del panel

        // Actualiza la visualización con la nueva matriz
        for (int i = 0; i < matrizParejas.length; i++) {
            for (int j = 0; j < matrizParejas[0].length; j++) {
                JLabel label = new JLabel(matrizParejas[i][j]);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                panelMatriz.add(label);
            }
        }

        // Actualiza el panel
        panelMatriz.revalidate();
        panelMatriz.repaint();
    }

    // Método para llenar la matriz con parejas
    public void llenarMatrizConParejas(Couple[] parejas) {
        int index = 0;
        for (int i = 0; i < matrizParejas.length; i++) {
            for (int j = 0; j < matrizParejas[0].length; j++) {
                if (index < parejas.length) {
                    matrizParejas[i][j] = parejas[index].getNameBoy() + " y " + parejas[index].getNameGirl();
                    index++;
                } else {
                    matrizParejas[i][j] = "";
                }
            }
        }
        actualizarVisualizacionMatriz(matrizParejas);
    }
}