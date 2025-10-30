
package Domain;

/**
 *
 * @author USER
 */
public class Tablero {
    private Ficha[][] tablero;

    public Tablero() {
        tablero = new Ficha[8][8];
        inicializarTablero();
    }

    private void inicializarTablero() {
        // Fichas negras arriba
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 != 0) {
                    tablero[i][j] = new Ficha("B");
                }
            }
        }

        // Fichas rojas abajo
        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 != 0) {
                    tablero[i][j] = new Ficha("R");
                }
            }
        }
    }

    public void imprimirTablero() {
        System.out.println("    0 1 2 3 4 5 6 7");
        System.out.println("   -----------------");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean moverFicha(int filaOrigen, int colOrigen, int filaDestino, int colDestino, String turno) {
        // Validaciones básicas
        if (!coordenadasValidas(filaOrigen, colOrigen, filaDestino, colDestino)) {
            System.out.println("Movimiento fuera del tablero.");
            return false;
        }

        Ficha ficha = tablero[filaOrigen][colOrigen];
        if (ficha == null) {
            System.out.println("No hay ficha en la posición de origen.");
            return false;
        }

        if (!ficha.getColor().equals(turno)) {
            System.out.println("Esa ficha no te pertenece.");
            return false;
        }

        if (tablero[filaDestino][colDestino] != null) {
            System.out.println("La casilla destino está ocupada.");
            return false;
        }

        if (!esMovimientoDiagonalValido(filaOrigen, colOrigen, filaDestino, colDestino, turno)) {
            System.out.println("Movimiento inválido. Solo puedes mover una casilla en diagonal.");
            return false;
        }

        // Mover la ficha
        tablero[filaDestino][colDestino] = ficha;
        tablero[filaOrigen][colOrigen] = null;
        return true;
    }

    private boolean coordenadasValidas(int f1, int c1, int f2, int c2) {
        return f1 >= 0 && f1 < 8 && c1 >= 0 && c1 < 8 && f2 >= 0 && f2 < 8 && c2 >= 0 && c2 < 8;
    }

    private boolean esMovimientoDiagonalValido(int f1, int c1, int f2, int c2, String color) {
        int df = f2 - f1;
        int dc = Math.abs(c2 - c1);

        if (dc != 1) return false; // solo una columna
        if (color.equals("R") && df != 1) return false;  // rojas bajan
        if (color.equals("B") && df != -1) return false; // negras suben

        return true;
    }
}
