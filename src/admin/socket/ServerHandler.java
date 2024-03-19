package admin.socket;

import Core.Packet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import admin.Interface.AdminInterface;

public class ServerHandler implements Runnable{
    ObjectOutputStream out;
    ObjectInputStream in;
    Socket socket;
    AdminInterface listener;

    public ServerHandler(Socket socket, AdminInterface listener) {
        this.socket = socket;
        this.listener = listener;
    }

    @Override
    public void run() { 
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            Packet clientMsg;
            while (!(clientMsg = (Packet) in.readObject()).message.equals("/disconnect")) {
                if (clientMsg.message.equals("Login")) {
                    this.listener.studentLogin(this, clientMsg.email, clientMsg.password);
                }
                
                if (clientMsg.message.equals("Score")) {
                    this.listener.addScore(clientMsg.student);
                }
                System.out.println(clientMsg.from + ":: " + clientMsg.message);
            }
        } catch (IOException | ClassNotFoundException e) {
            close();
        }
    }

    public void sendMessage(Packet packet) {
        try {
            out.writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}