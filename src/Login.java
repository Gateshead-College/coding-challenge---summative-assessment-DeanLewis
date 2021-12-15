import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    ArrayList<User> users;

    public static void main(String[] args) {
        Login login = new Login();
        login.users = login.getUsers();
        while(true)
        login.checkDetails();
    }

    public ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Deano", "password", "Dean", "Lewis", 1, true));
        users.add(new User("John", "pass", "John", "Deary", 2, true));
        users.add(new User("Jackie", "word", "Jackie", "Dowling", 3, false));
        return users;
    }

    public void checkDetails(){
        System.out.println("Please enter your Username");
        String username = new Scanner(System.in).nextLine();
        System.out.println("Please enter your password");
        String password = new Scanner(System.in).nextLine();
        for(User u : users) {
            if (username.equals(u.username)) {
                if (password.equals(u.password)) {
                    MainMenu mm = new MainMenu();
                    mm.getData();
                    break;
                }
            }
            System.out.println("Incorrect username/password, please try again.");
        }
    }
}
