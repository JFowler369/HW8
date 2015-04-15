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

    public int getIndex(Message m) {
        return this.messages.indexOf(m);
    }

    public String getName() {
        return this.name;
    }

    public Message getMessage(int idx) {
        return this.messages.get(idx);
    }

    public ArrayList<Message> getMessages() {
        return this.messages;
    }

    public void remove(Message m) {
        this.messages.remove(m);
    }

    public void removeAll() {
        this.messages = new ArrayList<Message>();
    }

    public void add(Message m) {
        this.messages.add(m);
    }

    public void add(ArrayList<Message> ms) {
        for (Message m: ms) {
            this.messages.add(m);
        }
    }

}
