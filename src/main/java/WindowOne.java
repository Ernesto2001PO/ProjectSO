import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


public class WindowOne extends JFrame {
    private JTextField person1Field;
    private JTextField person2Field;

    public WindowOne() {
        super("Registro para Baile");
        setSize(600, 600);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background image
        setContentPane(new JLabel(new ImageIcon("path_to_your_image.jpg")));


        // Add text fields for entering names
        person1Field = new JTextField();
        person1Field.setBounds(10, 80, 200, 30);
        add(person1Field);
        JLabel label2 = new JLabel("Nombre de la persona 1");
        label2.setBounds(10, 50, 200, 30);
        add(label2);

        person2Field = new JTextField();
        person2Field.setBounds(10, 150, 200, 30);
        add(person2Field);
        JLabel label3 = new JLabel("Nombre de la persona 2");
        label3.setBounds(10, 120, 200, 30);
        add(label3);

        // Add submit button
        JButton submitButton = new JButton("Registrar");
        submitButton.setBounds(10, 190, 200, 30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAndAddCouple();
            }
        });
        add(submitButton);
    }
    private void checkAndAddCouple() {
        String person1 = person1Field.getText();
        String person2 = person2Field.getText();

        // Check if the couple is a man and a woman
        if (isMale(person1) && !isMale(person2) || !isMale(person1) && isMale(person2)) {
            // Add the couple to the party
            Couple couple = new Couple(person1, person2, "", "", "", 0);

            // Load the image from the resources directory and create an ImageIcon with it
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/RegistroCorrecto.png"));

            // Obtiene la imagen del ImageIcon
            Image image = imageIcon.getImage();

           //Redimensiona la imagen
            Image newimg = image.getScaledInstance(300, 200,  java.awt.Image.SCALE_SMOOTH);

            // Crea un nuevo ImageIcon con la imagen redimensionada
            ImageIcon newIcon = new ImageIcon(newimg);

            // Create a JLabel with the ImageIcon
            JLabel labelWithImage = new JLabel(newIcon);

            // Create a JOptionPane with the JLabel
            JOptionPane optionPane = new JOptionPane(labelWithImage, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);

            // Change the options of the JOptionPane
            Object[] options = {"OK"};
            optionPane.setOptions(options);

            // Create a JDialog that contains the JOptionPane
            JDialog dialog = optionPane.createDialog(this, "La pareja ha sido registrada.");

            // Set the size of the dialog
            dialog.setSize(300, 350); // Replace 300, 200 with the desired width and height

            // Show the dialog
            dialog.setVisible(true);



            // Check if the user clicked OK
          //  if (JOptionPane.OK_OPTION == (int) optionPane.getValue()) {
                // The user clicked OK, save the registration in the array
                // Add 'couple' to your array here
         //   }
        } else {
            // Load the image from the resources directory and create an ImageIcon with it
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/ErrorRegistro.jpg"));

            // Obtiene la imagen del ImageIcon
            Image image = imageIcon.getImage();

            //Redimensiona la imagen
            Image newimg = image.getScaledInstance(300, 200,  java.awt.Image.SCALE_SMOOTH);

            // Crea un nuevo ImageIcon con la imagen redimensionada
            ImageIcon newIcon = new ImageIcon(newimg);

            // Create a JLabel with the ImageIcon
            JLabel labelWithImage2 = new JLabel(newIcon);

            // Create a JOptionPane with the JLabel
            JOptionPane optionPane = new JOptionPane(labelWithImage2, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);

            // Change the options of the JOptionPane
            Object[] options = {"OK"};
            optionPane.setOptions(options);

            // Create a JDialog that contains the JOptionPane
            JDialog dialog = optionPane.createDialog(this, "No se puede Registrar la pareja.");

            // Set the size of the dialog
            dialog.setSize(300, 350); // Replace 300, 200 with the desired width and height

            // Show the dialog
            dialog.setVisible(true);



        }
    }


    /**
     * Esta función determina si un nombre es masculino utilizando la API de Genderize.io.
     *
     * @param name El nombre que se va a verificar.
     * @return true si el nombre es masculino, false en caso contrario.
     */
    private boolean isMale(String name) {
        try {
            // Crea una URL que apunta a la API de Genderize.io, añadiendo el nombre proporcionado como parámetro a la URL.
            URL url = new URL("https://api.genderize.io/?name=" + name);

            // Abre una conexión HTTP a la URL y configura el método de la solicitud como GET.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Lee la respuesta de la API utilizando un InputStreamReader.
            InputStreamReader reader = new InputStreamReader(conn.getInputStream());

            // Utiliza la biblioteca Gson para deserializar la respuesta JSON en un Map<String, Object>.
            Map<String, Object> responseMap = new Gson().fromJson(reader, Map.class);

            // Obtiene el valor del campo "gender" del mapa.
            String gender = (String) responseMap.get("gender");

            // Compara este valor con la cadena "male". Si son iguales, la función devuelve true, indicando que el nombre es masculino.
            // Si no son iguales, la función devuelve false, indicando que el nombre no es masculino (y por lo tanto, asumimos que es femenino).
            return "male".equals(gender);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        WindowOne partyWindow = new WindowOne();
        partyWindow.setVisible(true);

    }
}


// Path: src/main/java/WindowTwo.java
// Compare this snippet from src/main/java/Couple.java:


