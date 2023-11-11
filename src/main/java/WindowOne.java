import javax.swing.*;

public class WindowOne extends JFrame {
    public WindowOne(){
        super("Registro para Baile");
        setSize(600,600);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Registro para Baile");
        label.setBounds(250, 10, 200, 30);
        add(label);
        JLabel label2 = new JLabel("Nombre del chico");
        label2.setBounds(10, 50, 200, 30);
        add(label2);
        JTextField textField = new JTextField();
        textField.setBounds(10, 80, 200, 30);
        add(textField);
        JLabel label3 = new JLabel("Nombre de la chica");
        label3.setBounds(10, 120, 200, 30);
        add(label3);
        JTextField textField2 = new JTextField();
        textField2.setBounds(10, 150, 200, 30);
        add(textField2);
        JLabel label4 = new JLabel("Apellido");
        label4.setBounds(10, 190, 200, 30);
        add(label4);
        JTextField textField3 = new JTextField();
        textField3.setBounds(10, 220, 200, 30);
        add(textField3);
        JLabel label5 = new JLabel("Carnet");
        label5.setBounds(10, 260, 200, 30);
        add(label5);
        JTextField textField4 = new JTextField();
        textField4.setBounds(10, 290, 200, 30);
        add(textField4);
        JLabel label6 = new JLabel("Fecha de registro");
        label6.setBounds(10, 330, 200, 30);
        add(label6);
        JTextField textField5 = new JTextField();
        textField5.setBounds(10, 360, 200, 30);
        add(textField5);






    }

    public static void main(String[] args) {
        WindowOne window1 = new WindowOne();
        window1.setVisible(true);
    }
}
