package client;

import com.beust.jcommander.JCommander;
import server.Args;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class Main {
    private static final String ADDRESS = "127.0.0.1";
    private static final int PORT = 23456;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(InetAddress.getByName(ADDRESS), PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        ) {
            System.out.println("Client started!");
            Args commandLineObject = new Args();
            JCommander.newBuilder()
                    .addObject(commandLineObject)
                    .build()
                    .parse(args);
            String clientRequest = (commandLineObject.getCommand()+" "+commandLineObject.getIndex()+" "+commandLineObject.getValue()).trim();
            output.writeObject(commandLineObject);
            System.out.println("Sent: " + clientRequest);
            System.out.println("Received: " + input.readUTF());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
