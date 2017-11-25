package snakesAndLadders.model;

public class Main {
    public static void main(String[] args) {
        Board board = BoardBuilder.get6x6Board();
        Game game = new Game(board, 2);

        while (!game.isFinished()) {
            game.move();
            System.out.println(game);
        }
        System.out.println("FIN");
    }
}
