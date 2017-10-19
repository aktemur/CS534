package command.v1;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
	public static void main(String args[]) throws Exception {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter server IP:");
		String serverIP = userInput.nextLine();

		// When the socket object is created,
		// connection is made.
		Socket socket = new Socket(serverIP, Server.PORT);

		// create reader and writer
		ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
		System.out.println("Connected to Server");

		while(true) {
			System.out.print("Enter command > ");
			String cmd  = userInput.nextLine();
			if(cmd.equals("turn left")) {
				writer.writeObject(new TurnLeft());
			} else if (cmd.equals("turn right")) {
				writer.writeObject(new TurnRight());
			} else if (cmd.equals("go forward")) {
				writer.writeObject(new GoForward());
			} else if (cmd.equals("speak")) {
				writer.writeObject(new Beep());
			} else if (cmd.equals("undo")) {
				writer.writeObject(new Undo());
			} else {
				System.out.println("Command not recognized.");
			}
		}
	}
}








