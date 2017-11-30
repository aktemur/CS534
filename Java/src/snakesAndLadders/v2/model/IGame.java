package snakesAndLadders.v2.model;

import java.util.List;

public interface IGame {
    void rollDie();

    void move();

    Player currentPlayer();

    void switchToNextPlayer();

    boolean isFinished();

    Player getWinner();

    List<Player> getPlayers();

    int dieValue();

    Board getBoard();

    @Override
    String toString();
}
