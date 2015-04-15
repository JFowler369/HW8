import java.util.ArrayList;

public class Mailbox {

    private String name;
    private ArrayList<Message> messages;

    public Mailbox() {
        this.name = "Mailbox";
        this.messages = new ArrayList<Message>();
    }

    public Mailbox(String name) {
        this.name = name;
        this.messages = new ArrayList<Message>();
    }

    public Mailbox(ArrayList<Message> m) {
        this.name = "Mailbox";
        this.messages = m;
    }

    public Mailbox(String name, ArrayList<Message> m) {
        this.name = name;
        this.messages = m;
    }

}
