package todo;
import java.util.Scanner;


public class Todo {
    public static boolean loggedIn = false;
    public static int noOfTasks;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.println(login.registerUser());
        System.out.println("Login");
        while (!loggedIn) {
            System.out.println(login.returnLoginStatus());
        }
        
        System.out.println("");
        
        // this keeps the app running
        while (loggedIn) {
            System.out.println("Select a number to choose a Menu");
            System.out.println("1. Add task");
            System.out.println("2. Show report (Coming soon)");
            System.out.println("3. Exit");
            System.out.print("Enter choice here: ");
            int option = scanner.nextInt();
            // go to new line since nextInt does not return a new line. You will see it a lot in this program
            scanner.nextLine();
            
            switch (option) {
                case 1 -> {
                    System.out.print("Number of Tasks: ");
                    noOfTasks = scanner.nextInt();
                    scanner.nextLine();
                    Task task = new Task(noOfTasks);
                    break;
                }
                case 2 -> System.out.println("Coming soon");
                case 3 -> System.exit(0);
            }
        }
    };
}
