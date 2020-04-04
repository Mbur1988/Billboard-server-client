import java.io.*;
import java.net.*;
import java.util.Scanner;

import ControlPanelInterface.ControlPanelInterface;
import LoginInterface.*;

// Client class 
public class ControlPanel
{
    private static InetAddress ip;
    private static int port;

    public static void setPort(int port) {
        ControlPanel.port = port;
    }

    public static int getPort() {
        return port;
    }

    public static void setIp(String ip) throws UnknownHostException {
        ControlPanel.ip = InetAddress.getByName(ip);
    }

    public static String getIp() {
        return ip.getHostAddress();
    }

    public static void main(String[] args) {
        ControlPanelInterface.controlPanelScreen();
        //LoginInterface.loginScreen();            // Don't forget to uncomment LOL
        try
        {
            Scanner scn = new Scanner(System.in);

            // setting ip
            setIp("localhost");
            // setting port
            setPort(5056);

            // establish the connection with server port 5056 
            Socket s = new Socket(ip, port);

            // obtaining input and out streams 
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            dos.writeUTF("controlpanel");

            // the following loop performs the exchange of 
            // information between client and client handler 
            while (true)
            {
                System.out.println(dis.readUTF());
                String tosend = scn.nextLine();
                dos.writeUTF(tosend);

                // If client sends exit,close this connection  
                // and then break from the while loop 
                if(tosend.equals("Exit"))
                {
                    System.out.println("Closing this connection : " + s);
                    s.close();
                    System.out.println("Connection closed");
                    break;
                }

                // printing date or time as requested by client 
                String received = dis.readUTF();
                System.out.println(received);
            }

            // closing resources 
            scn.close();
            dis.close();
            dos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}