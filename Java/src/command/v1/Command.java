package command.v1;

import java.io.Serializable;

public interface Command extends Serializable {
	public abstract void executeOn(Robot robot);
	public abstract void unexecuteOn(Robot robot);
}

class TurnLeft implements Command {
	public void executeOn(Robot robot) {
		robot.turnLeft();
	}

	public void unexecuteOn(Robot robot) {
		robot.turnRight();
	}
}

class GoForward implements Command {
	public void executeOn(Robot robot) {
		robot.moveForward();
	}

	public void unexecuteOn(Robot robot) {
		robot.turnLeft();
		robot.turnLeft();
		robot.moveForward();
		robot.turnLeft();
		robot.turnLeft();
	}
}

class TurnRight implements Command {
	public void executeOn(Robot robot) {
		robot.turnRight();
	}

	public void unexecuteOn(Robot robot) {
		robot.turnLeft();
	}
}

class Beep implements Command {
	public void executeOn(Robot robot) {
		robot.beep();
	}

	public void unexecuteOn(Robot robot) {
		// do nothing
	}
}

class Undo implements Command {
	public void executeOn(Robot robot) {
		Server.commands.pop(); // remove the Undo command
		Command lastCommand = Server.commands.pop();
		lastCommand.unexecuteOn(robot);
	}

	public void unexecuteOn(Robot robot) {
		// do nothing
	}
}

















