package Server.ViewerHandler;

import Server.ViewerTracker.ViewerTracker;
import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

public class ViewerHandler extends Thread {

    ViewerTracker viewerTracker = new ViewerTracker();
    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket socket;
    final String uuid;

    // Constructor
    public ViewerHandler(Socket socket, DataInputStream dis, DataOutputStream dos, String uuid) {
        this.socket = socket;
        this.dis = dis;
        this.dos = dos;
        this.uuid = uuid;
    }

    @Override
    public void run()
    {
        String received;
        String toreturn;
        while (true)
        {
            try {

                // Ask user what he wants
                dos.writeUTF("What do you want?[Date | Time]..\n"+
                        "Type Exit to terminate connection.");

                // Attempt to read client data input stream and handle any exceptions
                try {
                    // receive the answer from client
                    received = dis.readUTF();
                }
                catch (IOException e) {
                    System.out.println("Client " + socket + " disconnected...");
                    viewerTracker.Remove(this.uuid);
                    this.socket.close();
                    System.out.println("Connection closed");
                    break;
                }

                if(received.equals("Exit"))
                {
                    System.out.println("Client " + this.socket + " sends exit...");
                    System.out.println("Closing this connection.");
                    viewerTracker.Remove(this.uuid);
                    this.socket.close();
                    System.out.println("Connection closed");
                    break;
                }

                // creating Date object
                Date date = new Date();

                // write on output stream based on the
                // answer from the client
                switch (received) {

                    case "Date" :
                        toreturn = fordate.format(date);
                        dos.writeUTF(toreturn);
                        break;

                    case "Time" :
                        toreturn = fortime.format(date);
                        dos.writeUTF(toreturn);
                        break;

                    case "Ping" :
                        dos.writeUTF("Pong..");
                        break;

                    default:
                        dos.writeUTF("Invalid input");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            // closing resources
            this.dis.close();
            this.dos.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}