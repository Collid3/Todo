package todo;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {
    String firstName = null, lastName = null;
    
    public String returnLoginStatus() throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String username, password;
        String loginStatus = null;
        
        while(loginStatus == null) {
            System.out.print("Enter first name: ");
            username = scanner.nextLine();
            
            System.out.print("Enter password: ");
            password = scanner.nextLine();
            
            if (loginUser(username, password)) {
                loginStatus = "Welcome " + firstName + "," + lastName + " it is great to see you.";
            } else {
                loginStatus = "Incorrect username or password. Please try again.";
            }
        }
        
        return loginStatus;
        
    }
    
    private boolean loginUser(String username, String password) throws ClassNotFoundException {
        boolean loginStatus = false;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "jerry", "Incorrect#11");
            Statement statement = connection.createStatement();
            
            String query = "SELECT * FROM user WHERE username ='" + username + "'";
            ResultSet result = statement.executeQuery(query);
            
            while (result.next()) {
                String dbUsername = result.getString("username");
                String dbPassword = result.getString("password");
                firstName = result.getString("firstname");
                lastName = result.getString("lastname");
                
                if (dbUsername.equals(username) && dbPassword.equals(password)) {
                    loginStatus = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        return loginStatus;
    }
}
