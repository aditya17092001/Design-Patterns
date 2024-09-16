public class Board {
    int size;
    PlayingPiece board[][];

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public int getEmptyCells() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
        if (board[row][col] != null) {
            return false;
        }
        board[row][col] = playingPiece;
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(board[i][j].type.name() + " ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
