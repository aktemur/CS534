package mvc.minesweeper;

import javax.swing.JOptionPane;

public class MineSweeperController {
    private MineSweeperModel grid;
    private MineSweeperView view;

    public MineSweeperController(MineSweeperModel grid) {
        this.grid = grid;
        this.view = new MineSweeperView(grid.getNumCols(), grid.getNumCols(), this);
    }

    public void buttonClicked(int row, int col) {
        if(grid.containsMineAt(row, col)) {
            JOptionPane.showMessageDialog(null, "OOOPS!!");
            System.exit(0);
        } else {
            int info = grid.getInfoAt(row, col);
            view.updateButton(row, col, String.valueOf(info));
        }
    }

    public MineSweeperView getView() {
        return view;
    }
}



