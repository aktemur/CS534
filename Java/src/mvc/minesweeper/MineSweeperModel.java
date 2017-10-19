package mvc.minesweeper;

import java.util.Random;

public class MineSweeperModel {
    private int numMines;
    public static final int MINE = -1;     
    private int[][] numberOfSurroundingMines;
    // numberOfSurroundingMines is either MINE, meaning there is a mine
    // at that cell, or it keeps the number of surrounding mines.

    public MineSweeperModel(int numRows, int numCols, int numMines) {
        this.numMines = numMines;
        numberOfSurroundingMines = new int[numRows][numCols];

        placeMines();
        setMineInformation();
    }

    private void placeMines() {
        Random random = new Random();
        for(int i = 0; i < numMines; i++) {
            int x = random.nextInt(numberOfSurroundingMines.length);
            int y = random.nextInt(numberOfSurroundingMines[0].length);
            if(numberOfSurroundingMines[x][y] != MINE)
                numberOfSurroundingMines[x][y] = MINE;
            else // randomly picked an existing mine. Retry.
                i--; 
        }
    }

    private void setMineInformation() {
        for(int i = 0; i < numberOfSurroundingMines.length; i++) {
            for(int j = 0; j < numberOfSurroundingMines[0].length; j++) {
                if(numberOfSurroundingMines[i][j] == MINE) {
                    // previous row
                    incrementMineCountAt(i-1, j-1);
                    incrementMineCountAt(i-1, j);
                    incrementMineCountAt(i-1, j+1);

                    // left and right cells
                    incrementMineCountAt(i, j-1);
                    incrementMineCountAt(i, j+1);

                    // next row
                    incrementMineCountAt(i+1, j-1);
                    incrementMineCountAt(i+1, j);
                    incrementMineCountAt(i+1, j+1);
                }
            }   
        }
    }

    private void incrementMineCountAt(int i, int j) {
        if(isInsideGrid(i, j) && numberOfSurroundingMines[i][j] != MINE) {
            numberOfSurroundingMines[i][j] += 1;
        }
    }

    private boolean isInsideGrid(int i, int j) {
        return (i >= 0 && i < numberOfSurroundingMines.length) && 
                (j >= 0 && j < numberOfSurroundingMines[0].length);
    }

    public int getInfoAt(int i, int j) {
        return numberOfSurroundingMines[i][j];
    }

    public boolean containsMineAt(int i, int j) {
        return getInfoAt(i, j) == MINE;
    }

    public int getNumRows() {
        return numberOfSurroundingMines.length;
    }

    public int getNumCols() {
        return numberOfSurroundingMines[0].length;
    }

    public int getNumMines() {
        return numMines;
    }
}

