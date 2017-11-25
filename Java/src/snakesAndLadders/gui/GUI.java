package snakesAndLadders.gui;

import snakesAndLadders.model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI extends JPanel {
    private Game game;
    private GameView gameView;
    private JButton moveButton;
    private JLabel dieValue;

    public GUI(Game game, String boardImagePath, int numRows, int numCols) throws IOException {
        this.game = game;

        setLayout(new BorderLayout());

        gameView = new GameView(game, boardImagePath, numRows, numCols);
        add(gameView, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        add(rightPanel, BorderLayout.LINE_END);

        moveButton = new JButton("Move");
        rightPanel.add(moveButton);

        dieValue = new JLabel("");
        rightPanel.add(dieValue);
    }

    @Override
    protected void paintComponent(Graphics g) {
        dieValue.setText("Die: " + game.dieValue());
        super.paintComponent(g);
    }


    public void addActionListener(ActionListener listener) {
        moveButton.addActionListener(listener);
    }
}
