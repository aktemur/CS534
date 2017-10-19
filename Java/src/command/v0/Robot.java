package command.v0;

enum Direction {
	NORTH, SOUTH, WEST, EAST
}

public class Robot {
	Direction direction;
	int x;
	int y;

	public Robot() {
		reset();
	}

	public void reset() {
		x = 0;
		y = 0;
		direction = Direction.NORTH;
	}

	public void moveForward() {
		switch(direction) {
		case NORTH: 
			y -= 5; break;
		case SOUTH: 
			y += 5; break;
		case WEST: 
			x -= 5; break;
		case EAST: 
			x += 5; break;
		}
	}

	public void turnLeft() {
		switch(direction) {
		case NORTH: 
			direction = Direction.WEST; break;
		case SOUTH: 
			direction = Direction.EAST; break;
		case WEST: 
			direction = Direction.SOUTH; break;
		case EAST: 
			direction = Direction.NORTH; break;
		}
	}

	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}

	public void beep() {
		System.out.println("BEEP!");
	}

	public String toString() {
		return "I'm at " + x + ", " + y + " facing " + direction + ".";
	}
}
