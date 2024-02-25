package student.socket;

import Core.Packet;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

    public Client client;

    public ClientHandler(Client client) {
        this.client = client;
    }


    @Override
    public void run() {

            Scanner scanner = new Scanner(System.in);

            while (!this.client.socket.isClosed()) {

                System.out.print("Message to Server: ");
                String tmpMsg = scanner.next();

                Packet msg = new Packet(null, tmpMsg, "Server", "Client");
                msg.email = "whlmrbitoco@gmail.com";
                msg.password = "letmein";
                this.client.sendMessage(msg);
            }


    }
}