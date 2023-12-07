import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowTwo extends JFrame {

    private JPanel panelMatriz;
    private Couple[][] matrizParejas;

    public WindowTwo(Couple[][] matrizParejas) {
        this.matrizParejas = matrizParejas;

        setTitle("Ventana dos - Matriz de parejas");
        setSize(600, 600); // Tamaño de la ventana principal
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout()); // Establecer el layout de la ventana como BorderLayout

        // Boton Bailar que hace llama al hilo
        JButton bailarButton = new JButton("Bailar");
        bailarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        danceAnimation();
                        return null;
                    }
                }.execute();
            }
        });

        initComponents();
        add(bailarButton, BorderLayout.SOUTH);
    }

    private void danceAnimation() {
        // Recorre la matriz
        for (int i = 0; i < matrizParejas.length; i++) {
            for (int j = 0; j < matrizParejas[i].length; j++) {
                // Si hay una pareja en esta posición
                if (matrizParejas[i][j] != null) {
                    // Muestra el nombre de la pareja en la consola

                    // Muestra la imagen de la pareja en la posición actual con movimiento de sacudida
                    shakeImage(i * matrizParejas.length + j);

                    // Espera 1 segundo
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Restaura la imagen de la pareja en la posición actual
                    restoreImage(i * matrizParejas.length + j);
                }
            }
        }
    }

    private void shakeImage(int position) {
        ImageIcon imagenPareja = new ImageIcon(getClass().getResource("/Pareja.jpg"));

        // Escala la imagen
        Image imagePareja = imagenPareja.getImage();
        Image scaledImagePareja = imagePareja.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        imagenPareja = new ImageIcon(scaledImagePareja);

        // Obtiene el JLabel en la posición actual
        JLabel label = (JLabel) panelMatriz.getComponent(position);

        // Guarda la posición original
        int originalX = label.getX();

        // Mueve la imagen hacia la derecha y luego hacia la izquierda
        for (int i = 0; i < 5; i++) {
            label.setLocation(originalX + 5, label.getY());

            // Espera un breve tiempo para el efecto de movimiento
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            label.setLocation(originalX, label.getY());

            // Espera un breve tiempo para el efecto de movimiento
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Restaura la posición original
        label.setLocation(originalX, label.getY());
    }

    private void restoreImage(int position) {
        ImageIcon imagenPareja = new ImageIcon(getClass().getResource("/Pareja.jpg"));

        // Escala la imagen
        Image imagePareja = imagenPareja.getImage();
        Image scaledImagePareja = imagePareja.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        imagenPareja = new ImageIcon(scaledImagePareja);

        // Restaura la imagen original en la posición actual
        JLabel label = (JLabel) panelMatriz.getComponent(position);
        label.setIcon(imagenPareja);
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
                    label = new GradientLabel(" ", Color.BLUE, Color.WHITE);

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


    //Threads que hace la simulacion del baile
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            // Recorre la matriz
            for (int i = 0; i < matrizParejas.length; i++) {
                for (int j = 0; j < matrizParejas[i].length; j++) {
                    // Si hay una pareja en esta posición
                    if (matrizParejas[i][j] != null) {
                        // Muestra el nombre de la pareja en la consola
                        System.out.println(matrizParejas[i][j].getNameBoy() + " y " + matrizParejas[i][j].getNameGirl() + " bailan en la posición " + i + ", " + j);

                        // Muestra la imagen de la pareja en la posición actual
                        JLabel label = (JLabel) panelMatriz.getComponent(i * matrizParejas.length + j);
                        label.setIcon(new ImageIcon(getClass().getResource("/Pareja.jpg")));

                        // Espera 1 segundo
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                        // Muestra un JLabel con un color de fondo específico en la posición actual
                        label = new GradientLabel(" ", Color.BLUE, Color.WHITE);
                        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        label.setHorizontalAlignment(JLabel.CENTER);
                        label.setVerticalAlignment(JLabel.CENTER);
                        panelMatriz.add(label, i * matrizParejas.length + j);

                        // Actualiza la interfaz gráfica de usuario
                        panelMatriz.repaint();
                        panelMatriz.revalidate();
                    }
                }
            }
        }
    });

}
