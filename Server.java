import java.util.ArrayList;
import java.util.Random;
/**
 * Represents a a mailbox object.
 * @author Jesse Fowler
 * @version 1.0
 */
public class Server {

    private Mailbox trash;
    private Mailbox inbox;
    private Mailbox flagged;
    private ArrayList<Mailbox> boxes;

    /** Creates three mailboxes and an ArrayList of the boxes when called
      */
    public Server() {
        Person p1 = new Person();
        Person p2 = new Person("Bob Johnson", "BJohnson@email.com");
        Person p3 = new Person("Jack Brown", "JBrown@dmain.com");
        ArrayList<Person> r1 = new ArrayList<Person>();
        r1.add(p2);
        ArrayList<Person> r2 = new ArrayList<Person>();
        r2.add(p3);
        ArrayList<Person> r3 = new ArrayList<Person>();
        r3.add(p2);
        r3.add(p3);

        ArrayList<Message> b1 = new ArrayList<Message>();
        for (int x = 0; x < 10; ++x) {
            Random r = new Random(x);
            b1.add(new Message(p1, r1, "Subject " + x, r.toString()));
        }
        ArrayList<Message> b2 = new ArrayList<Message>();
        for (int x = 0; x < 10; ++x) {
            Random r = new Random(x);
            b2.add(new Message(p2, r2, "Subject " + x, r.toString()));
        }
        ArrayList<Message> b3 = new ArrayList<Message>();
        for (int x = 0; x < 10; ++x) {
            Random r = new Random(x);
            b3.add(new Message(p3, r3, "Subject " + x, r.toString()));
        }


        Mailbox aInbox = new Mailbox("Inbox", b1);
        this.inbox = aInbox;
        Mailbox aTrash = new Mailbox("Trash", b2);
        this.trash = aTrash;
        Mailbox aFlagged = new Mailbox("Flagged", b3);
        this.flagged = aFlagged;

        this.boxes = new ArrayList<Mailbox>();
        this.boxes.add(this.inbox);
        this.boxes.add(this.trash);
        this.boxes.add(this.flagged);
    }

    /** Returns the Inbox of the Server
      * @return The Inbox of the Server
      */
    public Mailbox getInbox() {
        return this.inbox;
    }

    /** Returns the trash box of the Server
      * @return The trash box of the Server
      */
    public Mailbox getTrash() {
        return this.trash;
    }

    /** Returns the flagged box of the Server
      * @return The flagged box of the Server
      */
    public Mailbox getFlagged() {
        return this.flagged;
    }

    /** Returns the ArrayList of all the mailboxes
      * @return The ArrayList of all the mailboxes
      */
    public ArrayList<Mailbox> getBoxes() {
        return this.boxes;
    }
}
