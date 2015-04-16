import java.util.ArrayList;
/**
 * Represents a mailbox object.
 * @author Jesse Fowler
 * @version 1.0
 */
public class Mailbox {

    private String name;
    private ArrayList<Message> messages;

    /** No arguement constructor for a Mailbox
      */
    public Mailbox() {
        this.name = "Mailbox";
        this.messages = new ArrayList<Message>();
    }

    /** Constructer that take a name and creates an empty mailbox.
      * @param name Name of the mailbox.
      */
    public Mailbox(String name) {
        this.name = name;
        this.messages = new ArrayList<Message>();
    }

    /** Takes an ArrayList<Message> and sets it as the mailbox with a
      * generic name.
      * @param m ArrayList of messages for the mailbox
      */
    public Mailbox(ArrayList<Message> m) {
        this.name = "Mailbox";
        this.messages = m;
    }

    /** Constructor that takes a name and ArrayList of messages
      * @param name Name of the mailbox
      * @param m ArrayList of messages
      */
    public Mailbox(String name, ArrayList<Message> m) {
        this.name = name;
        this.messages = m;
    }

    /** Returns the index of a specific message in the mailbox
      * @param m Message that you want the index of.
      * @return The index of the passed message
      */
    public int getIndex(Message m) {
        return this.messages.indexOf(m);
    }

    /** Returns the name of the mailbox.
      * @return The name of the mailbox.
      */
    public String getName() {
        return this.name;
    }

    /** Returns a message of a specific index in the ArrayList
      * @param idx Index of the message
      * @return The message at the index
      */
    public Message getMessage(int idx) {
        return this.messages.get(idx);
    }

    /** Returns the ArrayList of messages
      * @return The ArrayList of messages
      */
    public ArrayList<Message> getMessages() {
        return this.messages;
    }

    /** Removes a specific message for the ArrayList
      * @param m The message to be removed
      */
    public void remove(Message m) {
        this.messages.remove(m);
    }

    /** Removes all messages in the ArrayList
      */
    public void removeAll() {
        this.messages = new ArrayList<Message>();
    }

    /** Adds a message to the ArrayList
      * @param m The message to bo added
      */
    public void add(Message m) {
        this.messages.add(m);
    }

    /** Adds an entire ArrayList to the objects ArrayList
      * @param ms The ArrayList to be added
      */
    public void add(ArrayList<Message> ms) {
        for (Message m: ms) {
            this.messages.add(m);
        }
    }

}
