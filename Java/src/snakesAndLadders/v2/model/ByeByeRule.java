package snakesAndLadders.v2.model;

public class ByeByeRule extends Rule {
    public ByeByeRule(IGame game) {
        super(game);
    }

    @Override
    public void move() {
        game.move();

        Player currentPlayer = currentPlayer();
        Cell currentPlayerCell = currentPlayer.getCell();
        for (Player player: getPlayers()) {
            if (player != currentPlayer && player.getCell() == currentPlayerCell) {
                player.setCell(getBoard().getFirstCell());
            }
        }
    }
}
