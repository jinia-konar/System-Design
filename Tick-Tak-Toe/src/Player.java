import enums.Piece;

public class Player {
    private final String playerName;
    private final Piece piece;

    public Player(String playerName, Piece piece) {
        this.playerName = playerName;
        this.piece = piece;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Piece getPiece() {
        return piece;
    }
}
