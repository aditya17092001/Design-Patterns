import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    Deque<Player> players = new LinkedList<>();
    Board board;
    Scanner s = new Scanner(System.in);

    public void intializeGame() {
        System.out.println("Enter the name of the Player1: ");
        String player1Name = s.nextLine();
        System.out.println("Choose the piece you want\n1. X\n2. O");
        int pieceOption = s.nextInt();

        PieceX pieceX;
        PieceO pieceO;
        Player player1;
        Player player2;
        if (pieceOption == 1) {
            pieceX = new PieceX();
            player1 = new Player(player1Name, pieceX);
        } else {
            pieceO = new PieceO();
            player1 = new Player(player1Name, pieceO);
        }

        s.nextLine();
        System.out.println("Enter the name of the Player2: ");
        String player2Name = s.nextLine();
        if (pieceOption == 1) {
            pieceO = new PieceO();
            player2 = new Player(player2Name, pieceO);
        } else {
            pieceX = new PieceX();
            player2 = new Player(player2Name, pieceX);
        }

        players.add(player1);
        players.add(player2);

        board = new Board(3);
    }

    public void start() {
        boolean noWinner = true;

        while (noWinner) {
            Player turn = players.removeFirst();

            board.printBoard();
            int emptyCells = board.getEmptyCells();
            if (emptyCells == 0) {
                noWinner = false;
                break;
            }

            System.out.println(turn.getName() + "'s turn, please choose row and column: ");
            String rowCol[] = s.nextLine().split(",");

            int row = Integer.parseInt(rowCol[0]);
            int column = Integer.parseInt(rowCol[1]);
            boolean canChoose = board.addPiece(row, column, turn.getPiece());
            if (!canChoose) {
                System.out.println("Please choose a valid cell, it's already taken!");
                players.addFirst(turn);
                continue;
            } else {
                players.addLast(turn);
            }

            boolean isWinner = isThereAWinner(row, column, turn.getPiece());
            if (isWinner) {
                board.printBoard();;
                System.out.println(turn.getName() + " Wins");
                return;
            }
        }
        System.out.println("TIE!");
    }

    public boolean isThereAWinner(int row, int col, PlayingPiece piece) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for (int i = 0; i < board.size; i++) {
            if ((board.board[row][i] == null) || (board.board[row][i].type != piece.type)) {
                columnMatch = false;
                break;
            }
        }

        for (int i = 0; i < board.size; i++) {
            if ((board.board[i][col] == null) || (board.board[i][col].type != piece.type)) {
                rowMatch = false;
                break;
            }
        }

        for (int i = 0, j = 0; i < board.size && j < board.size; i++, j++) {
            if ((board.board[i][j] == null) || (board.board[i][j].type != piece.type)) {
                diagonalMatch = false;
                break;
            }
        }

        for (int i = 0, j = board.size - 1; i < board.size && j >= 0; i++, j--) {
            if ((board.board[i][j] == null) || (board.board[i][j].type != piece.type)) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return (rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch);
    }
}
