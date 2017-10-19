package command.v1;

import java.io.*;
import java.net.*;
import java.util.Stack;

public class Server {
	// server port number
	public final static int PORT = 3458;

	private static Robot robot = new Robot();

	public static Stack<Command> commands = new Stack<Command>();

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
			Command msg = (Command)reader.readObject();
			commands.push(msg);
			msg.executeOn(robot);
		}			
	}
}














