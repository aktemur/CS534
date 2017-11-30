package snakesAndLadders.v2.gui;

import snakesAndLadders.v2.model.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IGame game = new Game(BoardBuilder.get6x6Board(), 2);
        game = new RelaxedLandingRule(game);
        //game = new ExactLandingRule(game);
        game = new Lucky6Rule(game);
        game = new ByeByeRule(game);


        GUI gui = new GUI(game, "board6x6.jpg", 6, 6);
        Controller controller = new Controller(game, gui);
        controller.start();
    }
}
