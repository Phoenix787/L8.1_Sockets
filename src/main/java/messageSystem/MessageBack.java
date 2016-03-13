package messageSystem;

import clients.ClientThread;

/**
 * Created by Ксения on 08.03.2016.
 */
public class MessageBack extends MessageToServer {
    String message;

    public MessageBack(Address from, Address to, String message) {
        super(from, to, message);
        this.message = message;
    }

    @Override
    public void exec(ClientThread client) {
       // Msg back = new MsqIsAnswer()
    }
}
