package snakesAndLadders.v3.model;

import java.util.List;

public class Rule implements IGame {
    protected IGame game;

    public Rule(IGame game) {
        this.game = game;
    }

    @Override
    public void rollDie() {
        game.rollDie();
    }

    @Override
    public void move() {
        game.move();
    }

    @Override
    public Player currentPlayer() {
        return game.currentPlayer();
    }

    @Override
    public void switchToNextPlayer() {
        game.switchToNextPlayer();
    }

    @Override
    public boolean isFinished() {
        return game.isFinished();
    }

    @Override
    public Player getWinner() {
        return game.getWinner();
    }

    @Override
    public List<Player> getPlayers() {
        return game.getPlayers();
    }

    @Override
    public int dieValue() {
        return game.dieValue();
    }

    @Override
    public Board getBoard() {
        return game.getBoard();
    }

    @Override
    public String toString() {
        return game.toString();
    }
}
