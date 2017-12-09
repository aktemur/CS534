package snakesAndLadders.v3.gui;

import snakesAndLadders.v3.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private IGame game;
    private GUI gui;

    public Controller(Game game, GUI gui) {
        this.game = game;
        this.gui = gui;
        gui.addActionListener(this);
    }

    public void start() {
        JFrame frame = new JFrame("Snakes and Ladders");
        frame.setSize(700, 600);
        frame.setLayout(new BorderLayout());
        frame.add(gui, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCmd = e.getActionCommand();
        if (actionCmd.equals("Start")) {
            if (gui.rule1CheckBox.isSelected())
                game = new ExactLandingRule(game);
            if (gui.rule2CheckBox.isSelected())
                game = new Lucky6Rule(game);
            if (gui.rule3CheckBox.isSelected())
                game = new ByeByeRule(game);

            gui.moveButton.setEnabled(true);
            gui.startButton.setEnabled(false);
            gui.rule1CheckBox.setEnabled(false);
            gui.rule2CheckBox.setEnabled(false);
            gui.rule3CheckBox.setEnabled(false);
        } else if (actionCmd.equals("Move")) {
            gui.moveButton.setEnabled(false);
            Timer timer = new Timer(200, new DieRoller(10));
            timer.start();
        }
    }

    private void play() {
        game.move();
        game.switchToNextPlayer();
        gui.moveButton.setEnabled(true);
        gui.repaint();
        if (game.isFinished()) {
            JOptionPane.showMessageDialog(null, "We have a winner!");
            System.exit(0);
        }
    }

    class DieRoller implements ActionListener {
        private int steps;

        public DieRoller(int steps) {
            this.steps = steps;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (steps > 0) {
                game.rollDie();
                gui.repaint();
                steps--;
            } else {
                Timer timer = (Timer)e.getSource();
                timer.stop();
                play();
            }
        }
    }
}
