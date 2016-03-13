package clients;

import messageSystem.Abonent;
import messageSystem.Address;
import messageSystem.MessageSystem;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Ксения on 08.03.2016.
 *
 */
public class ClientThread implements Runnable {
    //private final Address address;
    Socket s;
    private Scanner in;
    //private final MessageSystem ms;
    private boolean shutdown = false;


    public ClientThread(Socket incoming) {
        this.s = incoming;
      //  address = new Address();
        //this.ms = ms;
    }

    public void run() {
        while (s != null){
            try {
                in = new Scanner(new InputStreamReader(s.getInputStream(), "UTF-8"));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"), true);
                //out.println("Welcome");
                while(!shutdown && in.hasNextLine()){
                    String message = in.nextLine();
                    if (message.equals("Bue.")) shutdown = true;
                    out.println(message);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                in.close();
                shutdown = true;
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                s = null;
            }
        }

    }


}
