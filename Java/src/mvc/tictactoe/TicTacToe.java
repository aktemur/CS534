package mvc.tictactoe;

public class TicTacToe {    
    public static void main(String[] args) {
        TicTacToeModel grid = new TicTacToeModel();
        TicTacToeController controller = new TicTacToeController(grid);
        controller.startGame();
    }
}

