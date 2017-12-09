package snakesAndLadders.v3.model;

public class BoardBuilder {
    // This is the board at
    // http://www.citywomenflaward.co.uk/wp-content/uploads/2014/05/snakes-and-ladders.jpg
    public static Board get6x6Board() {
        Board board = new Board(6 * 6);
        // Ladders
        board.setTransporter(1, 14);
        board.setTransporter(4, 6);
        board.setTransporter(8, 26);
        board.setTransporter(17, 28);
        board.setTransporter(24, 34);
        // Snakes
        board.setTransporter(33, 11);
        board.setTransporter(31, 29);
        board.setTransporter(19, 5);
        board.setTransporter(16, 3);
        board.setTransporter(23, 15);

        return board;
    }
}
