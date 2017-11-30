package snakesAndLadders.v2.model;

public class Main {
    public static void main(String[] args) {
        Board board = BoardBuilder.get6x6Board();
        IGame game = new Game(board, 2);
        game = new ExactLandingRule(game);
        game = new Lucky6Rule(game);
        game = new ByeByeRule(game);

        while (!game.isFinished()) {
            game.rollDie();
            game.move();
            game.switchToNextPlayer();
            System.out.println(game);
        }
        System.out.println("FIN");
    }
}
