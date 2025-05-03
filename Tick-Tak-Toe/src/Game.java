import enums.Piece;

import java.util.*;

public class Game {
    private final Board board;
    private final Deque<Player> players;
    private final Set<Piece> selectedPiece;
    Scanner scanner = new Scanner(System.in);

    public Game(int boardSize) {
        this.board = new Board(boardSize);
        this.players = new ArrayDeque<>();
        this.selectedPiece = new HashSet<>();
    }

    public void addPlayer(Player player) {
        if (selectedPiece.contains(player.getPiece())) {
            System.out.println(player.getPiece() + " piece already taken, please use another piece");
        }
        players.add(player);
        selectedPiece.add(player.getPiece());
    }

    private boolean gameOver() {
        return board.hasWinningLine();
    }

    public void playGame() {
        while(!players.isEmpty()) {
            board.printBoard();
            Player curPlayer = players.pollFirst();
            System.out.println("Enter row and column for " + curPlayer.getPlayerName());
            String[] input = scanner.nextLine().split(" ");
            int row = Integer.parseInt(input[0]);
            int column = Integer.parseInt(input[1]);

            boolean pieceAdded = board.addPiece(row, column, curPlayer.getPiece());
            if (!pieceAdded) {
                System.out.println("Not a valid row and column entered, please try again");
                players.addFirst(curPlayer);
                continue;
            }

            if (gameOver()) {
                System.out.println("Player " + curPlayer.getPlayerName() + " won the game!!");
                players.clear();
                break;
            }

            if(!board.isFreeSpace()) {
                System.out.println("Game is a Tie");
                players.clear();
                continue;
            }

            players.addLast(curPlayer);
        }
    }
}
