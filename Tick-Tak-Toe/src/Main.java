import enums.Piece;

public class Main {
    public static void main(String[] args) {
        System.out.println("Tic-Tack-Toe");

        Game myGame = new Game(3);
        Player player1 = new Player("Alice", Piece.X);
        Player player2 = new Player("Bob", Piece.O);

        myGame.addPlayer(player1);
        myGame.addPlayer(player2);

        myGame.playGame();
    }
}