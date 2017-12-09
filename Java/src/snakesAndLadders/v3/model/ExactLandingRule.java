package snakesAndLadders.v3.model;

public class ExactLandingRule extends Rule {
    public ExactLandingRule(IGame game) {
        super(game);
    }

    @Override
    public void move() {
        int numSteps = dieValue();
        Player currentPlayer = currentPlayer();
        int targetIndex = currentPlayer.getCell().getIndex() + numSteps;
        int lastIndex = getBoard().getLastCell().getIndex();
        if (targetIndex <= lastIndex) {
            game.move();
        }
    }
}
