package snakesAndLadders.gui;

import snakesAndLadders.model.BoardBuilder;
import snakesAndLadders.model.Game;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game(BoardBuilder.get6x6Board(), 2);
        GUI gui = new GUI(game, "board6x6.jpg", 6, 6);
        Controller controller = new Controller(game, gui);
        controller.start();
    }
}
