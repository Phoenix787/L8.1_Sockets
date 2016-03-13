package messageSystem;

import clients.ClientThread;

/**
 * Created by Ксения on 08.03.2016.
 */
public abstract class MessageToServer extends Msg {


    public MessageToServer(Address from, Address to, String message) {
        super(from, to);

    }

    @Override
    public void exec(Abonent abonent) {
        if (abonent instanceof ClientThread){
            exec((ClientThread) abonent);
        } else {
            System.out.println("Wrong abonent");
        }
    }

    public abstract void exec(ClientThread client);
}
