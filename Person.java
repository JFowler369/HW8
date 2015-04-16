/**
 * Represents a Person Object.
 * @author Jesse Fowler
 * @version 1.0
 */
public class Person {

    private String name;
    private String email;

    /** Constructor that takes two Strings for the name and the email of the
      * Person
      * @param name The Name of the Person
      * @param email The email of the Person
      */
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /** No argument Constructor that sets default name and email
      */
    public Person() {
        this.name = "John Smith";
        this.email = "JSmith@fakeemail.com";
    }

    /** Returns the name of the Person
      * @return The name of the Person
      */
    public String getName() {
        return this.name;
    }

    /** Returns the email of the Person
      * @return The email of the Person
      */
    public String getEmail() {
        return this.email;
    }
}
