package snakesAndLadders.v3.gui;

import snakesAndLadders.v3.model.IGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI extends JPanel {
    private IGame game;
    private GameView gameView;
    JButton startButton;
    JCheckBox rule1CheckBox, rule2CheckBox, rule3CheckBox;
    JButton moveButton;
    private JLabel dieValue;
    private JLabel nextPlayer;
    private static final String[] dieFaces = {"",
    "\u2680", "\u2681", "\u2682", "\u2683", "\u2684", "\u2685"};

    public GUI(IGame game, String boardImagePath, int numRows, int numCols) throws IOException {
        this.game = game;

        setLayout(new BorderLayout());

        gameView = new GameView(game, boardImagePath, numRows, numCols);
        add(gameView, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        add(rightPanel, BorderLayout.LINE_END);

        rule1CheckBox = new JCheckBox("ExactLanding");
        rule2CheckBox = new JCheckBox("Lucky6");
        rule3CheckBox = new JCheckBox("ByeBye");
        startButton = new JButton("Start");
        rightPanel.add(rule1CheckBox);
        rightPanel.add(rule2CheckBox);
        rightPanel.add(rule3CheckBox);
        rightPanel.add(startButton);

        moveButton = new JButton("Move");
        rightPanel.add(moveButton);

        dieValue = new JLabel("Die value");
        rightPanel.add(dieValue);

        nextPlayer = new JLabel("Player");
        nextPlayer.setOpaque(true);
        rightPanel.add(nextPlayer);

        moveButton.setEnabled(false);

        Font font = dieValue.getFont();
        dieValue.setFont(new Font(font.getName(), font.getStyle(), font.getSize() * 5));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Color playerColor = gameView.pickPlayerColor(game.getPlayers().size(), game.currentPlayer().getIndex());
        nextPlayer.setBackground(playerColor);
        dieValue.setText(dieFaces[game.dieValue()]);
        super.paintComponent(g);
    }


    public void addActionListener(ActionListener listener) {
        moveButton.addActionListener(listener);
        startButton.addActionListener(listener);
    }
}
