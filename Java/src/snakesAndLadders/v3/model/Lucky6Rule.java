package snakesAndLadders.v3.model;

public class Lucky6Rule extends Rule {
    public Lucky6Rule(IGame game) {
        super(game);
    }

    @Override
    public void switchToNextPlayer() {
        if (dieValue() != 6) {
            game.switchToNextPlayer();
        }
    }
}
