import java.util.ArrayList;

class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

class UserManager {

    ArrayList<User> users = new ArrayList<>();

    // CREATE
    public void addUser(User user) {
        users.add(user);
        System.out.println("User created");
    }

    // READ
    public void viewUsers() {
        for (User user : users) {
            user.display();
        }
    }

    // UPDATE
    public void updateUser(int id, String newName) {
        for (User user : users) {
            if (user.id == id) {
                user.name = newName;
                System.out.println("\nUser updated");
                return;
            }
        }
        System.out.println("User not found");
    }

    // DELETE
    public void deleteUser(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).id == id) {
                users.remove(i);
                System.out.println("\nUser deleted");
                return;
            }
        }
        System.out.println("User not found");
    }
}

public class CRUD {
    public static void main(String[] args) {

        UserManager manager = new UserManager();

        manager.addUser(new User(1, "Abc"));
        manager.addUser(new User(2, "Xyz"));
        System.out.println("\nAfter Create:");
        manager.viewUsers();

        manager.updateUser(1, "Qwerty");
        System.out.println("\nAfter Update:");
        manager.viewUsers();

        manager.deleteUser(2);
        System.out.println("\nAfter Delete:");
        manager.viewUsers();
    }
}
