package mvc.tictactoe;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class TicTacToePanelView extends TicTacToeView {
    public TicTacToePanelView(final TicTacToeController controller) {
        super(controller);
    }

    protected JComponent getNewCell() {
        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder());
        return panel;
    }

    public void updateCell(int i, int j, int playerID) {
        JPanel panel = (JPanel)components[i][j];
        panel.setBackground(playerID == 1 ? Color.RED : Color.BLUE);
        panel.setEnabled(false);
    }
}

