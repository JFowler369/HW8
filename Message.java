import java.util.ArrayList;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Message {

    private Person sender;
    private ArrayList<Person> recipients;
    private String subject;
    private String message;
    private Date date;

    public Message(Person sender, ArrayList<Person> recipients, String subject,
                   String message) {
        this.sender = sender;
        this.recipients = recipients;
        this.subject = subject;
        this.message = message;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.date = new Date();
    }

    public Person getSender() {
        return this.sender;
    }

    public String getSubject() {
        return this.subject;
    }

    public ArrayList<Person> getRecipients() {
        return this.recipients;
    }

    public String getMessage() {
        return this.message;
    }

    public Date getDate() {
        return this.date;
        //System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
    }

    public String toString() {
        return this.getSender().getName() + ": " + this.getSubject();
    }

    public static void main(String[] args) {
        Message m = new Message(new Person(), new ArrayList<Person>(), "Blank",
                    "new Message()");

    }


}
