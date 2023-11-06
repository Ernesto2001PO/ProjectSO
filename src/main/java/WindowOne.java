import javax.swing.*;

public class WindowOne extends JFrame {


    public WindowOne(){
        super("Registro");
        setSize(600,600);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Hola pa esto es una prueba de git
        //Si ves esto hay que hacer un commit

        //22,



    }

    public static void main(String[] args) {
        WindowOne window1 = new WindowOne();
        window1.setVisible(true);
    }
}
