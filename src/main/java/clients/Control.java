package clients;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Ксения on 08.03.2016.
 *
 */
public class Control {
    public static Control _control;
    public final static int MAX_RUN_THREAD = 10;
    //private ArrayList<ClientThread> list = new ArrayList<>();
    private int numClients = 1;

    public Control() {
        _control = this;
        startServer();
    }

    public void startServer() {

        try {
            ServerSocket server = new ServerSocket(5050);
            System.out.println("Server started");
            while (true) {
                Socket incoming = server.accept();
                ClientThread client = new ClientThread(incoming);
               // list.add(client);
                numClients++;
                Thread t = new Thread(client);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public void shutDownClient(ClientThread client) {
//        list.remove(client);
//    }





}
