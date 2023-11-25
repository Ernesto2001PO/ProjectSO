import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow extends JFrame {
    public StartWindow(){
        super("Bienvenidos a Technologie Club");
        setSize(600, 600);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton registrarButton = new JButton("Registrar");
        registrarButton.setBounds(250, 400, 100, 30);
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWindowOne();
            }
        });

        add(registrarButton);
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