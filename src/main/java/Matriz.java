
public class Matriz {
    private String[][] matrizParejas;

    public Matriz(int filas, int columnas) {
        matrizParejas = new String[filas][columnas];
        // Inicializa la matriz con valores predeterminados (cadenas vacías representarán posiciones vacías)
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizParejas[i][j] = "";
            }
        }
    }

    public void asignarPareja(int x, int y, String pareja) {
        // Asigna la pareja seleccionada en la posición (x, y) de la matriz
        // Si la posición ya está ocupada, muestra un mensaje o realiza la lógica que desees
        if (matrizParejas[y][x].isEmpty()) {
            matrizParejas[y][x] = pareja;
        } else {
            System.out.println("La posición ya está ocupada.");
            // Aquí puedes lanzar una excepción, mostrar un mensaje de error, o realizar otra acción.
        }
    }

    public String[][] obtenerMatrizParejas() {
        // Devuelve la matriz que representa las parejas seleccionadas
        return matrizParejas;
    }

    public String[][] obtenerMatriz() {
        // Devuelve la matriz que representa las parejas seleccionadas
        double[][] matriz = new double[matrizParejas.length][matrizParejas[0].length];
        for (int i = 0; i < matrizParejas.length; i++) {
            for (int j = 0; j < matrizParejas[i].length; j++) {
                if (matrizParejas[i][j].isEmpty()) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = 1;
                }
            }
        }
        return matrizParejas;
    }
}
