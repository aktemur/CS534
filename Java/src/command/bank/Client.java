package command.bank;

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
            System.out.print("Enter 1 to deposit, 2 to withdraw, 3 to transfer:");
            int choice = userInput.nextInt();
            if(choice == 1) {
                writer.writeObject(new Deposit());
            } else if (choice == 2) {
                writer.writeObject(new Withdraw());
            } else if (choice == 3) {
                writer.writeObject(new Transfer());
            }
            System.out.println("Done");
        }
    }
}