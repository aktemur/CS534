package snakesAndLadders.v1.gui;

import snakesAndLadders.v1.model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private Game game;
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
        game.move();
        gui.repaint();
        if (game.isFinished()) {
            JOptionPane.showMessageDialog(null, "We have a winner!");
            System.exit(0);
        }
    }
}
