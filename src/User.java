public class User {

    String username;
    String password;
    String forename;
    String surname;
    int employeeID;
    boolean admin;

    public User(String username, String password, String forename, String surname, int employeeID, boolean admin) {
        this.username = username;
        this.password = password;
        this.forename = forename;
        this.surname = surname;
        this.employeeID = employeeID;
        this.admin = admin;
    }
}
