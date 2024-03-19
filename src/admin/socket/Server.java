package admin.socket;


import Core.Packet;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import admin.Interface.AdminInterface;

public class Server implements Runnable{

    private ArrayList<ServerHandler> clients;
    private int port;
    ServerSocket server;
    private AdminInterface listener;

    public Server(int port, AdminInterface listener) {
        this.port = port;
        this.clients = new ArrayList<>();
        this.listener = listener;
    }

    @Override
    public void run(){

       try {
           server = new ServerSocket(this.port);
           System.out.println("Server running on port " + this.port);

           while (!server.isClosed()) {
               Socket socket = server.accept();

               ServerHandler handler = new ServerHandler(socket, this.listener);
                clients.add(handler);
               Thread thread = new Thread(handler);
               thread.start();


           }

       } catch (Exception e) {
           e.printStackTrace();
           close();
       }
    }

    public void broadcast(Packet packet) {
        for (ServerHandler sh : clients) {
            sh.sendMessage(packet);
        }
    }
    
    public void sendOneMessage(ServerHandler server, Packet packet)  {
         for (ServerHandler sh : clients) {
             if (sh == server) {
                sh.sendMessage(packet);
             }
        }
    }

    public void close() {
        try {
            server.close();
        } catch (IOException e) {
            System.out.println("Already close");
        }
    }

}
