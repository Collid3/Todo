package todo;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class Task {
    Scanner scanner = new Scanner(System.in);
    public static String[] Developers;
    public static String[] taskNames;
    public static String[] taskIDs;
    public static String[] taskStatuses;
    public static int[] taskDurations;
    public static int[] taskNumbers;
    public static String[] taskDescriptions;
    
    String name, description = "", status, devDetails, taskID;
    int duration;
    int taskNo = 0;
    int noOfTasks;
    
    // Add specific amount of tasks
    Task(int noOfTasks) {
        this.noOfTasks = noOfTasks;
        Developers = new String[noOfTasks];
        taskNames = new String[noOfTasks];
        taskIDs = new String[noOfTasks];
        taskStatuses = new String[noOfTasks];
        taskNumbers = new int[noOfTasks];
        taskDescriptions = new String[noOfTasks];
        taskDurations = new int[noOfTasks];
        taskNumbers[taskNo] = taskNo;
    }
    
    public void main() {
        createTask(noOfTasks);
    }
    
    public boolean checkTaskDescription (String Description) {
        return !Description.equals("") && Description.length() < 50;
    }
    
    public String createTaskID(String username, int taskNo, String devDetails) {
        // first 2 characters from username, task number, and last 3 characters from developer details
        String TaskID = username.substring(0, 2) + ":" + taskNo + ":" + devDetails.substring(devDetails.length() - 3);
        return TaskID.toUpperCase();
    }
    
    private void printTaskDetails() {        
        JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(dialog, "Task Information\nTask Status: " + status + "\nDeveloper Details: " + devDetails + "\nTask Number: " + taskNo + "\nTask Name: " + name + "\nTask Description: " + description + "\nTaskID: " + taskID + "\nDuration: " + duration + "hour(s)");
    }
    
    public int returnTotalHours(int[] taskDurations) {
        int taskHours = 0;
            for (int taskDuration : taskDurations) {
                taskHours += taskDuration;
            }
        return taskHours;
    }
    
    public void createTask(int noOfTasks) {
        while(taskNo < noOfTasks) {
            System.out.println("Add Task " + (taskNo + 1));

            System.out.print("Task Name: ");
            name = scanner.nextLine();
            Task.taskNames[taskNo] = name;
            
            System.out.print("Task Description: ");
            description = scanner.nextLine();
            taskDescriptions[taskNo] = description;

            if (!checkTaskDescription(description)) {
                System.out.println("Please enter a task description of less than 50 characters");
                break;
            }

            System.out.print("Developer Full Name: ");
            devDetails = scanner.nextLine();
            Task.Developers[taskNo] = devDetails;

            System.out.print("Task Duration (Number in Hours): ");
            duration = scanner.nextInt();
            Task.taskDurations[taskNo] = duration;
            scanner.nextLine();
            

            System.out.print("Task Status [1. To Do || 2.Done || 3. Doing ]: ");
            status = scanner.nextLine();
            Task.taskStatuses[taskNo] = status;
            
            taskID = createTaskID(name, taskNo, devDetails);
            Task.taskIDs[taskNo] = taskID;
            
            printTaskDetails();
            taskNo++;
            System.out.println("");
        }
        
        System.out.println("Total hours: " + returnTotalHours(taskDurations));
        System.out.println("");
    }
}
