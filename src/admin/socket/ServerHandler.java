package admin.socket;

import Core.Packet;
import Core.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import admin.Interface.AdminInterface;
import java.util.LinkedList;

public class ServerHandler implements Runnable {

    ObjectOutputStream out;
    ObjectInputStream in;
    Socket socket;
    AdminInterface listener;
    LinkedList<Packet> messageQueue;

    public ServerHandler(Socket socket, AdminInterface listener) {
        this.socket = socket;
        this.listener = listener;
        this.messageQueue = new LinkedList<>();
    }

    @Override
    public void run() {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            while (!messageQueue.isEmpty()) {
                sendMessage(messageQueue.poll());
            }

            Packet clientMsg;
            while (!(clientMsg = (Packet) in.readObject()).message.equals("/disconnect")) {
                if (clientMsg.message.equals("Login")) {
                    this.listener.studentLogin(this, clientMsg.email, clientMsg.password);
                }

                if (clientMsg.message.equals("Score")) {
                    this.listener.addScore(clientMsg.student);
                }

                if (clientMsg.message.equals("0xEditStudent")) {
                    System.out.println("server checked...");
                    Student tmp = clientMsg.student;
                    this.listener.saveEditStudent(tmp.id, tmp.name, tmp.email, tmp.password);
                }
                
                if (clientMsg.message.equals("0xDisconnect")) {
                    System.out.println("admin.socket.ServerHandler.run()");
                    this.listener.clientDisconnect(clientMsg.student);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            close();
        }
    }

    public void sendMessage(Packet packet) {
        try {
            if (out == null) {
                messageQueue.offer(packet);
            } else {
                out.writeObject(packet);
            }
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
