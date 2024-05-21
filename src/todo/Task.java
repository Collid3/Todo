package todo;

import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class Task {
    Scanner scanner = new Scanner(System.in);
    
    int[] hours;
    String name, description = "", status, devDetails, taskID;
    int duration;
    int taskNo = 0;
    
    // Add specific amount of tasks
    Task(int noOfTasks) {
        hours = new int[noOfTasks];
        
        while(taskNo < noOfTasks) {
            System.out.println("Add Task " + (taskNo + 1));

            System.out.print("Task Name: ");
            name = scanner.nextLine();

            while (!checkTaskDescription(description)) {
                System.out.print("Task Description: ");
                description = scanner.nextLine();

                if (!checkTaskDescription(description)) {
                    System.out.println("Please enter a task desription of less than 50 characters");
                }
            }

            System.out.print("Developer Full Name: ");
            devDetails = scanner.nextLine();

            System.out.print("Task Duration (Number in Hours): ");
            duration = scanner.nextInt();
            scanner.nextLine();
            
            hours[taskNo] = duration;

            System.out.print("Task Status [1. To Do || 2.Done || 3. Doing ]: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> status = "To Do";
                case 2 -> status = "Done";
                case 3 -> status = "Doing";
            }
            taskID = createTaskID();
            printTaskDetails();
            taskNo++;
            System.out.println("");
        }
        
        System.out.println("Total hours: " + returnTotalHours());
        System.out.println("");
    }
    
    private boolean checkTaskDescription (String Description) {
        boolean valid = false;
            if (!Description.equals("") && Description.length() < 50) {
                valid = true;
            }
        return valid;
    }
    
    private String createTaskID() {
        String TaskID = name.substring(0, 2) + ":" + taskNo + ":" + devDetails.substring(devDetails.length() - 3);
        return TaskID.toUpperCase();
    }
    
    private String printTaskDetails() {
        String taskDetails = "";
        
        JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(dialog, "Task Information\nTask Status: " + status + "\nDeveloper Details: " + devDetails + "\nTask Number: " + taskNo + "\nTask Name: " + name + "\nTask Description: " + description + "\nTaskID: " + taskID + "\nDuration: " + duration + "hour(s)");
        return taskDetails;
    }
    
    private int returnTotalHours() {
        int taskHours = 0;
            for (int hour : hours) {
                taskHours += hour;
            }
        return taskHours;
    }
    
}
