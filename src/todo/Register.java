package todo;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.sql.*;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Register {
    public void view() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String username = null, password = null, firstName = null, lastName = null;
        boolean correctUsernameFormat = false, correctPasswordFormat = false;
        
        while (!correctUsernameFormat) {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            
            if (checkUserName(username)) {
                correctUsernameFormat = true;
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
            }
        }
        
        while (!correctPasswordFormat) {
            System.out.print("Enter password: ");
            password = scanner.nextLine();
            
            if (checkPasswordComplexity(password)) {
                correctPasswordFormat = true;
            } else {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character");
            }
        }
        
        while(firstName == null) {
            System.out.print("Enter your first name: ");
            firstName = scanner.nextLine();
        }
         
        while (lastName == null) {
            System.out.print("Enter your last name: ");
            lastName = scanner.nextLine();
        }
        
        System.out.println(registerUser(username, password, firstName, lastName));
    }
    
    public boolean checkUserName(String username) {
        boolean valid = false;
        
        if (username.length() <= 5 && username.contains("_")) {
            valid = true;
        }

        return valid;
    }
    
    public boolean checkPasswordComplexity (String password) {
        boolean valid = false;
        
        Pattern specialCharacters = Pattern.compile("[^A-Za-z0-9]");
        Pattern upperCases = Pattern.compile("[A-Z]");
        
        Matcher charMatcher = specialCharacters.matcher(password);
        boolean hasSpecialCharacter = charMatcher.find();
        
        Matcher capMatcher = upperCases.matcher(password);
        boolean hasCapitalLetter = capMatcher.find();
        
        boolean hasValidLength = password.length() > 8;
        
        // check if password contains digit
        boolean hasDigit = false;

        for (char letter : password.toCharArray()) {
            if (Character.isDigit(letter)) {
                hasDigit = true;
            }
        }
        
        if(hasValidLength && hasSpecialCharacter && hasDigit && hasCapitalLetter) {
            valid = true;
        }
        
        return valid;
    }
    
    public String registerUser (String username, String password, String firstName, String lastName) throws SQLException {        
        if (!checkUserName(username)) {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        } else {
            System.out.println("Username successfully captured");
        }
        
        if (!checkPasswordComplexity(password)){
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character";
        } else {
            System.out.println("Password successfully captured");
            System.out.println("Saving info to the database...");
            
            // generate random Id for a user
            String uniqueID = UUID.randomUUID().toString();
            
            // save user info to the database
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "jerry", "Incorrect#11");
                
                String query = "INSERT INTO user VALUES ('"+uniqueID + "','" + username + "', '" + password +"', '" + firstName + "', '" + lastName + "')";
                PreparedStatement statement = connection.prepareStatement(query);
                
                statement.executeUpdate();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Something went wrong. Pleasae try again");
            }
            
            return "Username and password correctly formatted. Account successfully created";
        }
        
    }
    
}
