package todo;
import java.sql.SQLException;
import java.util.Scanner;


public class Todo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Register register = new Register();
        Login login = new Login();
        
        Scanner scanner = new Scanner(System.in);
        String option = null;
        boolean loggedIn = false;
        
        while (option == null) {
            int choice;
            
            System.out.println("Select to open menu");
            
            System.out.println("1. Register");
            System.out.println("2. Login");
            
            System.out.print("Enter here: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1 -> {
                    option = "register";
                    System.out.println("Create an account");
                }
                case 2 -> {
                    option = "login";
                    System.out.println("Login page");
                }
                default -> System.out.println("Invalid option");
            }
        }
        
        switch (option) {
            case "register" -> register.view();
            case "login" -> {
                while(!loggedIn ) {
                    String status = login.returnLoginStatus();
                    System.out.println(status);
                    
                    if(status.contains("Welcome") ) {
                        loggedIn = true;
                    }
                }
            }
            default -> option = null;
                
        }
    };
}
