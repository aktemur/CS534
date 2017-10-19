package mvc.tictactoe;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class TicTacToeView extends JFrame {
    protected JComponent[][] components = new JComponent[3][3];

    public TicTacToeView(final TicTacToeController controller) {
        setLayout(new GridLayout(3,3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                components[i][j] = getNewCell();
                add(components[i][j]);
                final int row = i;
                final int col = j;
                components[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent arg0) {
                        // Delegate to the controller 
                        // the task of handling the user action
                        controller.cellClicked(row, col);                        
                    }
                });
            }
        }
    }

    public abstract void updateCell(int i, int j, int playerID);

    protected abstract JComponent getNewCell();

    public void updateTitle(int player) {
        setTitle("Player " + player + "'s turn.");
    }
}