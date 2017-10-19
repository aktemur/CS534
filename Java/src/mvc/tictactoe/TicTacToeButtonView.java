package mvc.tictactoe;

import javax.swing.JButton;
import javax.swing.JComponent;

//The GUI is the view that contains buttons
@SuppressWarnings("serial")
public class TicTacToeButtonView extends TicTacToeView {
    public TicTacToeButtonView(final TicTacToeController controller) {
        super(controller);
    }

    protected JComponent getNewCell() {
        JButton button = new JButton();
        return button;
    }

    public void updateCell(int i, int j, int playerID) {
        JButton button = (JButton)components[i][j];
        button.setText(playerID == 1 ? "X" : "O");
        button.setEnabled(false);
    }
}

