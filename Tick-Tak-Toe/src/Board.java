import enums.Piece;

public class Board {
    private final int size;
    private Piece[][] board;

    public Board(int size) {
        this.size = size;
        board = new Piece[size][size];
    }

    public void printBoard() {
        System.out.println("Board: ");
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                Piece piece = board[i][j];
                String val = piece == null ? "_" : piece.name();
                System.out.print(val + " | ");
            }
            System.out.println();
        }
    }

    public boolean isFreeSpace() {
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(board[i][j] == null) return true;
            }
        }
        return false;
    }

    public boolean hasWinningLine() {
        //row
        boolean rowComplete = false;
        for(int i=0;i<size;i++) {
            Piece val = board[i][0];
            boolean status = true;
            for(int j=0;j<size;j++) {
                if(board[i][j] == null || board[i][j] != val) {
                    status = false;
                    break;
                }
            }
            rowComplete = rowComplete || status;
        }

        //column
        boolean columnComplete = false;
        for(int j=0;j<size;j++) {
            Piece val = board[0][j];
            boolean status = true;
            for(int i=0;i<size;i++) {
                if(board[i][j] == null || board[i][j] != val) {
                    status = false;
                    break;
                }
            }
            columnComplete = columnComplete || status;
        }

        //negativeDiagonal
        boolean negativeDiagonalComplete = true;
        Piece valNegativeDiagonal = board[0][0];
        for(int i=0;i<size;i++) {
            if(board[i][i] == null || board[i][i] != valNegativeDiagonal) {
                negativeDiagonalComplete = false;
                break;
            }
        }

        //positiveDiagonal
        boolean positiveDiagonalComplete = true;
        Piece valPositiveDiagonal = board[0][0];
        for(int i=0;i<size;i++) {
            if(board[i][size-1-i] == null || board[i][size-1-i] != valPositiveDiagonal) {
                positiveDiagonalComplete = false;
                break;
            }
        }

        return rowComplete || columnComplete || negativeDiagonalComplete || positiveDiagonalComplete;
    }

    public boolean addPiece(int row, int column, Piece piece) {
        if(row < 0 || row >= size || column < 0 || column >= size || board[row][column] != null) {
            return false;
        }
        board[row][column] = piece;
        return true;
    }
}
