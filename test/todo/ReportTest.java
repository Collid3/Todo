/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package todo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class ReportTest {
    
    int[] taskNumbers = {0, 1, 2, 3};
    String[] taskIDs = {"CR:0:ITH", "CR:1:SON", "CR:2:SON", "AD:3:ZER"};
    String[] taskDescriptions = {"Create Login to authenticate users", "Allow users to add tasks", "Display all information to the user", "Part 3 of the poe"};
    String[] Developers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
    String[] taskNames = {"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
    int[] taskDurations = {5, 8, 2, 11};
    String[] taskStatuses = {"To Do", "Doing", "Done", "To Do"};
    Report report = new Report(taskNames, Developers, taskNumbers, taskIDs, taskStatuses, taskDurations, taskDescriptions);
    
    @Test
    public void testLongestDuration() {
        report.longestDurationTask(Developers, taskDurations);
        String expected = "Glenda Oberholzer, 11";
        
        assertEquals(expected, report.longestDurationTask(Developers, taskDurations));
    }
    
    @Test
    public void testDeleteTask() {
        
        String taskName = "Create Reports";
        String message = "Entry \"" + taskName + "\" successfully deleted";

        
        System.out.println("Here");
        assertEquals(message, report.deleteTask(taskName, Developers, taskNames, taskIDs, taskStatuses, taskDurations, taskNumbers, taskDescriptions));
    }
    
    @Test
    public void testSearchTask() {
        String taskName = "Create Login";
        String expected = "Create Login, Mike Smith, To Do";
        
        assertEquals(expected, report.searchTask(taskName, taskNames, Developers, taskStatuses));
    }
    
    @Test
    public void testTaskDeveloperTask() {
        String developer = "Samantha Paulson";
        
        String expected = "Create Reports, Done";
        
        assertEquals(expected, report.searchDeveloperTasks(developer, Developers, taskNames, taskStatuses));
    }
}
