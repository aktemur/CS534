package command.bank;

import java.io.*;
import java.net.*;

interface Command extends Serializable {
    void execute();
}

class Deposit implements Command {
    public void execute() {
        System.out.println("Depositing money...");
    }
}

class Withdraw implements Command {
    public void execute() {
        System.out.println("Withdrawing money...");
    }
}

class Transfer implements Command {
    public void execute() {
        System.out.println("Transfering...");
    }
}

public class Server {
    // server port number
    public final static int PORT = 3458;

    public static void main(String args[]) throws Exception {        
        // create socket and bind to port
        ServerSocket sock = new ServerSocket(PORT);

        System.out.println("Server is waiting for client to connect.");
        Socket clientSocket = sock.accept();
        System.out.println("Client has connected.");

        ObjectInputStream reader = new ObjectInputStream(clientSocket.getInputStream());
        
        while(true) {
            // read msg from client
            Command msg = (Command)reader.readObject();
            msg.execute();
        }			
    }
}