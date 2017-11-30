package snakesAndLadders.v2.model;

public class RelaxedLandingRule extends Rule {
    public RelaxedLandingRule(IGame game) {
        super(game);
    }

    @Override
    public void move() {
        Cell lastCell = getBoard().getLastCell();
        lastCell.setNext(lastCell);
        game.move();
    }
}
