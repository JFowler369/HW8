import java.util.ArrayList;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Represents a Message object.
 * @author Jesse Fowler
 * @version 1.0
 */
public class Message {

    private Person sender;
    private ArrayList<Person> recipients;
    private String subject;
    private String message;
    private Date date;

    /** Constructor for a Message Object
      * @param sender Sender of the Message
      * @param recipients ArrayList of Persons to recieve the message
      * @param subject Subject for the Message
      * @param message Body of the Message
      */
    public Message(Person sender, ArrayList<Person> recipients, String subject,
                   String message) {
        this.sender = sender;
        this.recipients = recipients;
        this.subject = subject;
        this.message = message;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.date = new Date();
    }

    /** Returns the sender of the Message
      * @return The sender of the Message
      */
    public Person getSender() {
        return this.sender;
    }

    /** Returns the subject of the Message
      * @return The subject of the Message
      */
    public String getSubject() {
        return this.subject;
    }

    /** Returns the ArrayList of recipients
      * @return The ArrayList of recipients
      */
    public ArrayList<Person> getRecipients() {
        return this.recipients;
    }

    /** Returns the body of the Message
      * @return The body of the Message
      */
    public String getMessage() {
        return this.message;
    }

    /** Returns the date the Message was created/sent
      * @return The date the Message was created/sent
      */
    public Date getDate() {
        return this.date;
    }

    /** Returns the String representation of the Message
      * @return The String representation of the Message
      */
    public String toString() {
        return this.getSender().getName() + ": " + this.getSubject();
    }
}
