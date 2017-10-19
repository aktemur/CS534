package command.v0;

import java.io.*;
import java.net.*;

public class Server {
	// server port number
	public final static int PORT = 3458;

	private static Robot robot = new Robot();

	public static void main(String args[]) throws Exception {        
		// create socket and bind to port
		ServerSocket sock = new ServerSocket(PORT);

		System.out.println("Server is waiting for client to connect.");
		Socket clientSocket = sock.accept();
		System.out.println("Client has connected.");

		ObjectInputStream reader = new ObjectInputStream(clientSocket.getInputStream());

		while(true) {
			System.out.println(robot);
			// read msg from client       
			String msg = (String)reader.readObject();
			if (msg.equals("<left>")) {
				robot.turnLeft();
			} else if (msg.equals("<right>")) {
				robot.turnRight();
			} else if (msg.equals("<step>")) {
				robot.moveForward();
			} else if (msg.equals("<beep>")) {
				robot.beep();
			}
		}			
	}
}






