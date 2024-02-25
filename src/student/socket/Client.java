package student.socket;

import Core.Packet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import student.Interface.StudentInterface;

public class Client implements Runnable{

    public Socket socket;
    public String host;
    public int port;
    public ObjectOutputStream out;
    public ObjectInputStream in;
    public StudentInterface listener;

    public Client(String host, int port, StudentInterface listener) {
        this.host = host;
        this.port = port;
        this.listener = listener;
    }

    @Override
    public void run() {
        try {
            socket = new Socket(this.host, this.port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());


            Packet recPacket;
            while (!(recPacket = (Packet) in.readObject()).message.equals("/close")) {
                
                if (recPacket.auth) {
                    this.listener.authorize(recPacket.auth, recPacket.student);
                } 
                
                if (recPacket.message.equals("Quiz2Ans")) {
                    this.listener.setQuiz(recPacket.quizes);
                }
                
                System.out.println(recPacket.from + ":: " + recPacket.message);
                System.out.println(recPacket.quizes);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Server Disconnected");
        }
    }

    public void sendMessage(Packet packet) {
        try {
            out.writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   
}
