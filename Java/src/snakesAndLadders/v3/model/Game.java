package snakesAndLadders.v3.model;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {
    private Die die;
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;

    public Game(Board board, int numPlayers) {
        this.die = new Die();
        this.board = board;
        this.players = new ArrayList<Player>(numPlayers);
        for (int i = 0; i < numPlayers; i++) {
            Player player = new Player(i);
            players.add(player);
            player.setCell(board.getFirstCell());
        }
        this.currentPlayerIndex = 0;
    }

    @Override
    public void rollDie() {
        die.roll();
    }

    @Override
    public void move() {
        Player currentPlayer = currentPlayer();
        currentPlayer.move(die.getFace());
    }

    @Override
    public Player currentPlayer() {
        return players.get(currentPlayerIndex);
    }

    @Override
    public void switchToNextPlayer() {
        currentPlayerIndex = (++currentPlayerIndex) % players.size();
    }

    @Override
    public boolean isFinished() {
        return getWinner() != null;
    }

    @Override
    public Player getWinner() {
        for (Player player: getPlayers()) {
            if (player.getCell() == board.getLastCell())
                return player;
        }
        return null;
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public int dieValue() {
        return die.getFace();
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {
        String result = "Die: " + die.getFace() + "\n";

        for (Player player: players) {
            result += player.toString() + "\n";
        }

        return result;
    }
}
