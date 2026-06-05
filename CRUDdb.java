import java.sql.*;

class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class UserManager {
    private Connection con;
    UserManager() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "{placeholder}");
        System.out.println("Connected Successfully!");
    }

    // CREATE
    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO users VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, user.id);
        ps.setString(2, user.name);
        ps.executeUpdate();
        System.out.println("User created");
    }

    // READ
    public void viewUsers() throws SQLException {
        String query = "SELECT * FROM users";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + " Name: " + rs.getString("name"));
        }
    }

    // UPDATE
    public void updateUser(int id, String newName) throws SQLException {
        String query = "UPDATE users SET name = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, newName);
        ps.setInt(2, id);
        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("\nUser updated");
        else
            System.out.println("User not found");
    }

    // DELETE
    public void deleteUser(int id) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("\nUser deleted");
        else
            System.out.println("User not found");
    }

    public void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}

public class CRUDdb {
    public static void main(String[] args) {
        UserManager manager = null;
        try {
            manager = new UserManager();

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

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (manager != null)
                    manager.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
