package todo;
import java.util.Scanner;


public class Todo {
    public static boolean loggedIn = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        

        System.out.println(login.registerUser());
        System.out.println("Login");
        while (!loggedIn) {
            System.out.println(login.returnLoginStatus());
        }
        
        // this keeps the app running
        while (loggedIn) {
            System.out.println("\nMain Menu. Select a number");
            System.out.println("1. Add task\n2. Show report\n3. Exit");
            System.out.print("Enter choice: ");
            int option = scanner.nextInt();
            // go to new line since nextInt does not return a new line. You will see it a lot in this program
            scanner.nextLine();
            System.out.println("");
            
            switch (option) {
                case 1 -> {
                    int noOfTasks;
                    System.out.print("Number of Tasks: ");
                    noOfTasks = scanner.nextInt();
                    scanner.nextLine();
 
                    Task task = new Task(noOfTasks);
                    task.main();
                }
                case 2 -> {
                Report report = new Report(Task.taskNames, Task.Developers, Task.taskNumbers, Task.taskIDs, Task.taskStatuses, Task.taskDurations, Task.taskDescriptions);
                report.main();
                }
                case 3 -> System.exit(0);
            }
        }
    }
}
