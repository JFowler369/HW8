public class Person {

    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Person() {
        this.name = "John Smith";
        this.email = "JSmith@fakeemail.com";
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

}
