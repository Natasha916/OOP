package quiz_ap;

public class Name {
    private String firstName;
    private String lastName;

    // Constructor
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter and Setter methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Method to get the full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Method to get initials
    public String getInitials() {
        return (firstName.charAt(0) + "" + lastName.charAt(0)).toUpperCase();
    }
}
