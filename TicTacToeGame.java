import java.util.Scanner;
 
public class TicTacToeGame {
     
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        char[][] board = new char[3][3];
        char currentPlayer = 'X';
 
        initializeBoard(board);
 
        while (true) {
            printBoard(board);
            System.out.println("Player " + currentPlayer + ", enter row (1-3) and column (1-3) separated by space: ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
 
            if (isValidMove(board, row, col)) {
                board[row][col] = currentPlayer;
 
                if (checkWin(board, currentPlayer)) {
                    printBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }
 
                if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("It's a tie!");
                    break;
                }
 
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
 
        scanner.close();
    }
 
    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
 
    private static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
 
    private static boolean isValidMove(char[][] board, int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
    }
 
    private static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Check rows
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Check columns
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) || // Check diagonals
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
 
    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
