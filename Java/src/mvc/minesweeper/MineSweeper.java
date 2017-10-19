package mvc.minesweeper;

import javax.swing.JFrame;

/**
 * This is a simple example of what is called the Model-View-Controller (MVC)
 * programming pattern. In this pattern, the idea is to keep the underlying 
 * logic separate from the GUI.
 *  
 * In our application, MineSweeperModel is the Model; it defines the logic.
 * The model is completely unaware of visualization and user interaction.
 * 
 * MineSweeperView is the View; it defines how to visualize the mine grid.
 * It's dummy; it does not contain any "smart" things.
 * It simply displays things as it is told, and it receives user
 * input. It does not handle the input, though.
 * It tells the controller when a user action is received.
 * 
 * MineSweeperController is the Controller; it defines what action
 * to take when a button is clicked. Controller updates the model,
 * and then decides how to update the view.
 * 
 *  
 * @author aktemur
 *
 */

public class MineSweeper {
    private static final int NUM_MINES = 5;
    private static final int SIZE = 5;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mine Sweeper | # of mines: " + NUM_MINES);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        MineSweeperModel grid = new MineSweeperModel(SIZE, SIZE, NUM_MINES);
        MineSweeperController controller = new MineSweeperController(grid);
        frame.add(controller.getView());        

        frame.setVisible(true);
    }
}

