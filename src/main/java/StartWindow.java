import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow extends javax.swing.JFrame{

    public StartWindow() {
        super("Bienvenidos a Technologie Club");
        setSize(1000, 600);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon logoInicio = new ImageIcon(getClass().getResource("LogoFInal.png"));
        JLabel logoInicioLabel = new JLabel(logoInicio);
        logoInicioLabel.setBounds(0, 0, 1000, 600);
        add(logoInicioLabel);


        JButton registrarButton = new JButton("Registrar");
        registrarButton.setBounds(425, 400, 100, 30);
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWindowOne();
            }
        });
        add(registrarButton);
    }

    private void openWindowOne() {
        WindowOne windowOne = new WindowOne();
        windowOne.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartWindow startWindow = new StartWindow();
            startWindow.setVisible(true);
        });
    }
}
