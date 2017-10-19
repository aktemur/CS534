package mvc.tictactoe;

import javax.swing.JOptionPane;

public class TicTacToeController {
    private TicTacToeModel grid;
    private TicTacToeView view;

    public TicTacToeController(TicTacToeModel grid) {
        this.grid = grid;

        // Randomly pick a view.
        // This is just to show that different visualization methods
        // can work seamlessly.
        // Exercise: Write a view class that uses images.
        if (Math.random() < 0.5) {
            this.view = new TicTacToePanelView(this);
        } else {
            this.view = new TicTacToeButtonView(this);
        }
    }

    public void startGame() {
        view.setSize(300,300);        
        view.setVisible(true);
    }

    public void cellClicked(int row, int col) {
        int currentPlayer = grid.getCurrentPlayer();
        grid.markCell(row, col);
        int nextPlayer = grid.getCurrentPlayer();
        view.updateCell(row, col, currentPlayer);
        view.updateTitle(nextPlayer);
        if(grid.hasWinningCondition()) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won!!!");
            System.exit(0);
        } else if(grid.hasTieCondition()) {
            JOptionPane.showMessageDialog(null, "Game tied!!!");
            System.exit(0);
        }
    }
}

