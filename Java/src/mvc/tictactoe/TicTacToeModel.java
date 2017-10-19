package mvc.tictactoe;

//Grid is the "model" that implements the game logic.
//Note that grid is completely unaware of the GUI-related
//things. This is a good design principle. 
class TicTacToeModel {
    private int[][] grid = new int[3][3];
    public static final int PLAYER1 = 1;
    public static final int PLAYER2 = 2;
    private int currentPlayer = PLAYER1;

    public int getCellValue(int i, int j) {
        return grid[i][j];
    }

    public void markCell(int i, int j) {
        grid[i][j] = currentPlayer;
        if(currentPlayer == PLAYER1) currentPlayer = PLAYER2;
        else currentPlayer = PLAYER1;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean hasWinningCondition() {
        return hasWinningConditionOnRows()
                || hasWinningConditionOnColumns()
                || hasWinningConditionOnDiagonals();
    }

    private boolean hasWinningConditionOnRows() {
        for(int i = 0; i < 3; i++) {
            if(grid[i][0] != 0 && 
                    grid[i][0] == grid[i][1] && 
                    grid[i][1] == grid[i][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean hasWinningConditionOnColumns() {
        for(int j = 0; j < 3; j++) {
            if(grid[0][j] != 0 && 
                    grid[0][j] == grid[1][j] && 
                    grid[1][j] == grid[2][j]) {
                return true;
            }
        }
        return false;
    }

    private boolean hasWinningConditionOnDiagonals() {
        if(grid[0][0] != 0 && 
                grid[0][0] == grid[1][1] && 
                grid[1][1] == grid[2][2]) {
            return true;
        }
        if(grid[0][2] != 0 && 
                grid[0][2] == grid[1][1] && 
                grid[1][1] == grid[2][0]) {
            return true;
        }
        return false;
    }

    public boolean hasTieCondition() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(grid[i][j] == 0)
                    return false;
            }
        }
        // If we reach here, that means all the cells
        // have been marked
        return true;
    }
}

