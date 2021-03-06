package messageSystem;

/**
 * Created by Ксения on 08.03.2016.
 */
public abstract class Msg {
    private final Address from;
    private  final Address to;

    public Msg(Address from, Address to) {
        this.from = from;
        this.to = to;
    }

    protected Address getFrom() {
        return from;
    }

    protected Address getTo() {
        return to;
    }

    public abstract void exec(Abonent abonent);
}
