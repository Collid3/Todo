package todo;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    Scanner scanner = new Scanner(System.in);
    
    String firstName = "", lastName = "", username = "", password = "";
    
    public String returnLoginStatus() {
        String loginStatus;
        
        if (loginUser()) {
            Todo.loggedIn = true;
            loginStatus = "Welcome " + firstName + "," + lastName + " it is great to see you.";
        } else {
            loginStatus = "Incorrect username or password. Try again.";
        }
        
        return loginStatus;
        
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
        
        // REGEX special characters
        Pattern specialCharacters = Pattern.compile("[^A-Za-z0-9]");
        Pattern upperCases = Pattern.compile("[A-Z]");
        
        Matcher charMatcher = specialCharacters.matcher(password);
        boolean hasSpecialCharacter = charMatcher.find();
        
        Matcher capMatcher = upperCases.matcher(password);
        boolean hasCapitalLetter = capMatcher.find();
        
        boolean hasValidLength = password.length() > 8;
        
        // check if password contains digit
        boolean hasDigit = false;

        // Brockie@20 -> ['B', 'r', 'o', 'c'...]  -> {'B' a digit? }
        for (char letter : password.toCharArray()) {
            if (Character.isDigit(letter)) {
                hasDigit = true;
                break;
            }
        }
        
        if(hasValidLength && hasSpecialCharacter && hasDigit && hasCapitalLetter) {
            valid = true;
        }
        
        return valid;
    }
    
    public String registerUser () {
        // generate random Id for a user
        String message = "";
        boolean valid = false;
        boolean failedAttempt = false;
        
        while(!valid) {
            if (failedAttempt) {
                System.out.println("Try again...");
            } else {
                System.out.println("Create An Account");
            }
            
            System.out.print("Username: ");
            username = scanner.nextLine();
            
            System.out.print("Password: ");
            password = scanner.nextLine();
            
            if (!checkUserName(username) && !checkPasswordComplexity(password)) {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 charactersm, a capital letter, a number and a special character.");
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
            
            if (checkUserName(username) && !checkPasswordComplexity(password)) {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 charactersm, a capital letter, a number and a special character.");
            } else if ((checkPasswordComplexity(password) && !checkUserName(username))) {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            } 
            
            if (checkUserName(username) && checkPasswordComplexity(password)) {
                System.out.print("First name: ");
                firstName = scanner.nextLine();

                System.out.print("Last name: ");
                lastName = scanner.nextLine();
                System.out.println("Account Successfully created.");
                valid = true;
            } else if (!failedAttempt) {
                failedAttempt = true;
            }
        }
        
        return message;
    }
    
    private boolean loginUser() {
        boolean match = false;
        String loginUsername, loginPassword;
        
        System.out.print("Username: ");
        loginUsername = scanner.nextLine();

        System.out.print("Password: ");
        loginPassword = scanner.nextLine();
        
        if (username.equals(loginUsername) && password.equals(loginPassword)) {
            match = true;
        }
        
        return match;
    }
}
