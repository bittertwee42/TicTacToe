import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[][] matrix = new String[3][3]; //allocazione matrice 3x3
        int row, col;
        boolean gameOver = false, winner = false;
        int turn = 0;  // 0 per giocatore 1 (X), 1 per giocatore 2 (O)

        // Inizializzazione della tabella con spazi vuoti
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = " ";
            }
        }

        do {
            // Stampa della tabella
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(matrix[i][j]);
                    if (j < 2) {
                        System.out.print("|");
                    }
                }
                System.out.println();
                if (i < 2) {
                    System.out.println("-----");
                }
            }
            // Controllo di chi è il turno
            if (turn % 2 == 0) {
                System.out.println("Giocatore 1 (X), inserisci la tua mossa (riga e colonna): ");
            } else {
                System.out.println("Giocatore 2 (O), inserisci la tua mossa (riga e colonna): ");
            }
            // Inserimento della mossa
            row = sc.nextInt();
            col = sc.nextInt();
            // controllo validità mosse e 
            if (row < 0 || row > 2 || col < 0 || col > 2 || !matrix[row][col].equals(" ")) {
                System.out.println("Questa mossa non è valida. Riprova.");
            } else {
                if (turn % 2 == 0) {
                    matrix[row][col] = "X";
                } else {
                    matrix[row][col] = "O";
                }
            }
            // Controllo se c'è un vincitore
            // Controlla le righe
            for (int i = 0; i < 3; i++) {
                if (matrix[i][0].equals(matrix[i][1]) && matrix[i][1].equals(matrix[i][2]) && !matrix[i][0].equals(" ")) {
                    winner = true;
                }
            }
            // Controlla le colonne
            for (int i = 0; i < 3; i++) {
                if (matrix[0][i].equals(matrix[1][i]) && matrix[1][i].equals(matrix[2][i]) && !matrix[0][i].equals(" ")) {
                    winner = true;
                }
            }
            // Controlla le diagonali
            if (matrix[0][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][2]) && !matrix[0][0].equals(" ")) {
                winner = true;
            }
            if (matrix[0][2].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][0]) && !matrix[0][2].equals(" ")) {
                winner = true;
            }
            // Controllo chi è il vincitore, o se è pareggio 
            if (winner) {
                gameOver = true;
                if (turn % 2 == 0) {
                    System.out.println("Giocatore 1 (X) vince!");
                } else {
                    System.out.println("Giocatore 2 (O) vince!");
                }
            } else if (turn == 8) {
                gameOver = true;
                System.out.println("La partita è finita in pareggio!");
            }
            turn++;
        } while (!gameOver);
        sc.close();
    }
}