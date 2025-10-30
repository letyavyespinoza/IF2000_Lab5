
package Domain;
import java.util.Scanner;
/**
 *
 * @author USER
 */
public class Juego {
    private Tablero tablero;
    private String turnoActual;

    public Juego() {
        tablero = new Tablero();
        turnoActual = "R"; // Empiezan las rojas
    }

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nTurno de: " + (turnoActual.equals("R") ? "ROJAS (R)" : "NEGRAS (B)"));
            tablero.imprimirTablero();

            System.out.print("Fila origen: ");
            int filaOrigen = sc.nextInt();
            System.out.print("Columna origen: ");
            int colOrigen = sc.nextInt();
            System.out.print("Fila destino: ");
            int filaDestino = sc.nextInt();
            System.out.print("Columna destino: ");
            int colDestino = sc.nextInt();

            boolean movValido = tablero.moverFicha(filaOrigen, colOrigen, filaDestino, colDestino, turnoActual);

            if (movValido) {
                cambiarTurno();
            }

            System.out.print("¿Desea continuar jugando? si o no: ");
            String resp = sc.next();
            if (resp.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }
        System.out.println("Juego finalizado.");
    }

    private void cambiarTurno() {
        turnoActual = turnoActual.equals("R") ? "B" : "R";
    }
}
