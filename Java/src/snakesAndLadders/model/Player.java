package snakesAndLadders.model;

public class Player {
    private String name;
    private Cell cell;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void move(int numSteps) {
        for (int i = 0; i < numSteps; i++) {
            cell = cell.getNext();
        }
        cell = cell.getTransport();
    }

    @Override
    public String toString() {
        return name + " @ " + cell;
    }
}
