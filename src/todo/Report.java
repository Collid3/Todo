package todo;

import java.util.Scanner;


public class Report {
    String[] taskNames; String[] Developers; int[] taskNumbers; String[] taskIDs; String[] taskStatuses; int[] taskDurations; String[] taskDescriptions;
    
    Report(String[] taskNames, String[] Developers, int[] taskNumbers, String[] taskIDs, String[] taskStatuses, int[] taskDurations, String[] taskDescriptions ) {
        this.taskNames = taskNames;
        this.Developers = Developers;
        this.taskNumbers = taskNumbers;
        this.taskIDs = taskIDs;
        this.taskStatuses = taskStatuses;
        this.taskDurations = taskDurations;
        this.taskDescriptions = taskDescriptions;
    }
    
    public void main() {
        boolean leaveReportPage = false;
        Scanner scanner = new Scanner(System.in);
        
        // persist display on report page
        while (!leaveReportPage) {
            int option = 0;
            
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.println("");
            allTasksDetails(taskNames, Developers, taskNumbers, taskIDs, taskStatuses, taskDurations, taskDescriptions);
            System.out.println("\n" + longestDurationTask(Developers, taskDurations));
            
            while (option != 6 ) {
                System.out.println("");
                System.out.println("Report Page Menu");
                
                System.out.println("1. All Tasks\n2. Done tasks\n3. Search Task\n4. Search Developer Tasks\n5. Delete Task\n6. Back To Main Menu");

                System.out.print("Enter choice here: ");
                option = scanner.nextInt();
                scanner.nextLine();
                System.out.println("");
                System.out.println("----------------------------------------------------------------------------------------------");

                switch (option) {
                    case 1 -> allTasksDetails(taskNames, Developers, taskNumbers, taskIDs, taskStatuses, taskDurations, taskDescriptions);
                    case 2 -> {
                        System.out.println("Tasks with status Done.");
                        doneTasks(taskStatuses, Developers, taskNames, taskDurations);
                    }
                    case 3 -> {
                        System.out.println("Search for a Task by completing the form");
                        System.out.print("Task Name: ");
                        String searchWord = scanner.nextLine();

                        System.out.println("\nSearch Results for \"" + searchWord + "\".");
                        System.out.println(searchTask(searchWord, taskNames, Developers, taskStatuses));
                    }
                    case 4 -> {
                        System.out.println("\nSearch Developer Tasks by completing the form");
                        System.out.print("Developer Name: ");
                        String developerName = scanner.nextLine();

                        System.out.println("");
                        searchDeveloperTasks(developerName, Developers, taskNames, taskStatuses);
                    }
                    case 5 -> {
                        System.out.println("\nDelete Tasks by completing the form");
                        System.out.print("Task Name: ");
                        String taskName = scanner.nextLine();

                        System.out.println("");
                        System.out.println(deleteTask(taskName, Developers, taskNames, taskIDs, taskStatuses, taskDurations, taskNumbers, taskDescriptions));
                        System.out.println("");
                        allTasksDetails(taskNames, Developers, taskNumbers, taskIDs, taskStatuses, taskDurations, taskDescriptions);
                    }
                    case 6 -> leaveReportPage = true;
                }
                
            }
            
        }
    }
    
    public void doneTasks(String[] taskStatuses, String[] Developers, String[] taskNames, int[] taskDurations) {
        for (int i = 0; i < taskStatuses.length; i++) {
            if (taskStatuses[i].equals("Done")) {
                System.out.format("%s\t%s\t%s\n", Developers[i], taskNames[i], taskDurations[i]);
            }
        }
    }
    
    public String longestDurationTask(String[] Developers, int[] taskDurations) {
        int longestDuration = 0;
        int index = 0;
        
        for (int i = 0; i < taskDurations.length; i++) {
            if (taskDurations[i] > longestDuration) {
                longestDuration = taskDurations[i];
            }
            index = i;
        }
        
        return "Longest Duration task: " + Developers[index] + ", " + taskDurations[index];
    }
    
    public void allTasksDetails(String[] taskNames, String[] Developers, int[] taskNumbers, String[] taskIDs, String[] taskStatuses, int[] taskDurations, String[] taskDescriptions) {
        System.out.println("All Tasks Report");
        for (int i = 0; i < taskStatuses.length; i++) {
            System.out.printf("\nTask Status: %s\nDeveloper Details: %s\nTask Number: %d\nTask Name: %s\nTask Description: %s\nTask ID: %s\nTask Duration: %s\n", taskStatuses[i], Developers[i], taskNumbers[i], taskNames[i], taskDescriptions[i], taskIDs[i], taskDurations[i]);
        }
    }
    
    public String deleteTask (String taskName, String[] Developers, String[] taskNames, String[] taskIDs, String[] taskStatuses, int[] taskDurations, int[] taskNumbers, String[] taskDescriptions) {
        int index = 0;
        String[] newDevelopers = new String[taskNames.length - 1];
        String[] newTaskNames = new String[taskNames.length - 1];
        String[] newTaskIDs = new String[taskNames.length - 1];
        String[] newTaskStatuses = new String[taskNames.length - 1];
        int[] newTaskDurations = new int[taskNames.length - 1];
        int[] newTaskNumbers = new int[taskNames.length - 1];
        String[] newTaskDescriptions = new String[taskNames.length - 1];
        
        for (String originalTaskName : taskNames) {
            if (!originalTaskName.equals(taskName)) {
                newDevelopers[index] = Developers[index];
                newTaskNames[index] = taskNames[index];
                newTaskIDs[index] = taskIDs[index];
                newTaskStatuses[index] = taskStatuses[index];
                newTaskDurations[index] = taskDurations[index];
                newTaskNumbers[index] = taskNumbers[index];
                newTaskDescriptions[index] = taskDescriptions[index];
                
                index++;
            }
        }
        
        // update original
        Task.Developers = newDevelopers;
        Task.taskNames = newTaskNames;
        Task.taskIDs = newTaskIDs;
        Task.taskStatuses = newTaskStatuses;
        Task.taskDurations = newTaskDurations;
        Task.taskNumbers = newTaskNumbers;
        Task.taskDescriptions = newTaskDescriptions;
        
        this.Developers = newDevelopers;
        this.taskNames = newTaskNames;
        this.taskIDs = newTaskIDs;
        this.taskStatuses = newTaskStatuses;
        this.taskDurations = newTaskDurations;
        this.taskNumbers = newTaskNumbers;
        this.taskDescriptions = newTaskDescriptions;
        
        return "Entry \"" + taskName + "\" successfully deleted";
    }
    
    public String searchTask(String taskName, String[] taskNames, String[] Developers, String[] taskStatuses) {
        String response = "";
        int index = 0;
        
        for (String name : taskNames) {
            if (name.equals(taskName)) {
                response =  taskNames[index] + ", " + Developers[index] + ", " + taskStatuses[index];
            }
            index++;
        }
        return response;
    }
    
    public String searchDeveloperTasks(String developerName, String[] Developers, String[] taskNames, String[] taskStatuses) {
        int index = 0;
        
        System.out.println("Developer Tasks");
        for (int i = 0; i < Developers.length; i++) {
            
            if (Developers[i].equals(developerName)) {
                System.out.printf("%s\t%s",taskNames[index], taskStatuses[index]);
                index = i;
            }
        }
        
        // Response used for testing
        String response = taskNames[index] + ", " + taskStatuses[index];
        return response;
    }
}
