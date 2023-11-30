import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow extends JFrame {
    public StartWindow(){
        super("Bienvenidos a Technologie Club");
        setSize(1000, 600);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creando el background
        ImageIcon logoPrueba = new ImageIcon(StartWindow.class.getResource("logoejemplo1.png"));
        JLabel labellogoPrueba = new JLabel(logoPrueba);
        labellogoPrueba.setBounds(0,0,1000,600);


        JButton registrarButton = new JButton("Registrar");
        registrarButton.setBounds(425, 400, 100, 30);
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWindowOne();
            }
        });
        labellogoPrueba.add(registrarButton);
        add(labellogoPrueba);
    }
    private void openWindowOne(){
        WindowOne windowOne = new WindowOne();
        windowOne.setVisible(true);
        dispose();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StartWindow startWindow = new StartWindow();
                startWindow.setVisible(true);
            }
        });
    }
}