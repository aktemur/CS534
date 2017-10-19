package mvc.minesweeper;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MineSweeperView extends JPanel {
    private JButton[][] buttons;

    public MineSweeperView(int numRows, int numCols, final MineSweeperController controller) {
        setLayout(new GridLayout(numRows, numCols));
        buttons = new JButton[numRows][numCols];
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                JButton button = new JButton();
                add(button);
                final int row = i;
                final int col = j;
                button.addActionListener(new ButtonListener(controller, col, row));
                                
                buttons[i][j] = button;
            }
        }
    }

    public void updateButton(int i, int j, String label) {
        buttons[i][j].setText(label);
    }
}

class ButtonListener implements ActionListener {
    private final MineSweeperController controller;
    private final int col;
    private final int row;

    ButtonListener(MineSweeperController controller, int col, int row) {
        this.controller = controller;
        this.col = col;
        this.row = row;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Delegate to the controller 
        // the task of handling the user action
        controller.buttonClicked(row, col);
    }
}

