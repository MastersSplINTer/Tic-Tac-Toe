import java.util.Scanner;
public class Main {
    //MastersSplINTer
    private static final char[] PLAYERS = {'X', 'O'};
    private static char[][] board = new char[3][3];
    private static int currentPlayer = 0; // 0 for 'X', 1 for 'O'
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a scanner object for reading input
        initializeBoard(); // Initialize the game board with empty values
        while (true) { // Main game loop
            System.out.println("Current board:");
            printBoard(); // Display the current state of the board
            int[] move = getMove(scanner); // Ask the current player for their move
            board[move[0]][move[1]] = PLAYERS[currentPlayer]; // Place the current player's symbol on the board at the specified location
            if (isWinner(move[0], move[1])) { // Check if the current move wins the game
                printBoard(); // Print the final state of the board
                System.out.println("Player '" + PLAYERS[currentPlayer] + "' wins!"); // Announce the winner
                break; // Exit the game loop
            }
            if (isBoardFull()) { // Check if the board is full and no more moves can be made
                printBoard(); // Print the final state of the board
                System.out.println("The game is a draw!"); // Announce the draw
                break; // Exit the game loop
            }
            currentPlayer = 1 - currentPlayer; // Switch to the other player
        }
        scanner.close(); // Close the scanner object to free up resources
    }


    public static void initializeBoard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    public static void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    public static int[] getMove(Scanner scanner) {
        int row, col;
        while (true) {
            System.out.println("Player '" + PLAYERS[currentPlayer] + "', enter your move (row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                return new int[]{row, col};
            } else {
                System.out.println("This move is invalid.");
            }
        }
    }
    public static boolean isWinner(int row, int col) {
        if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {  //&& board[row][0] != '-' ) {
            return true;
        }
        if (board[0][col] == board[1][col] && board[1][col] == board[2][col] ) { //&& board[0][col] != '-') {
            return true;
        }
        if ( row == col && board[0][0] == board[1][1] && board[1][1] == board[2][2] ) { // && board[0][0] != '-') {
            return true;
        }
        if (row + col == 2 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {//&& board [0][2] != '-') {
            return true;
        }
        else {
            return false;
        }

    }
    public static boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row){
                if(cell == '-') {
                    return false;
                }
            }

        }
        return true;
    }
}

