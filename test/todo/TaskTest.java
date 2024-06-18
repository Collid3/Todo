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
public class TaskTest {
    int noOfTasks = 2;
    Task task = new Task(noOfTasks);
    
    String taskName1 = "Login Feature";
    int taskNo1 = 0;
    String taskDescription1 = "Create Login to authenticate users";
    String developerDetails1 = "Robyn Harrison";
    int taskDuration1 = 8;
    String taskID1 = "LO:0:SON";
    String taskStatus1 = "To Do";
    
    String taskName2 = "Add Task Feature";
    int taskNo2 = 1;
    String taskDescription2 = "Create Add Task feature where users will can add specific amount of tasks";
    String developerDetails2 = "Mike Smith";
    int taskDuration2 = 10;
    String taskID2 = "AD:1:ITH";
    String taskStatus2 = "Doing";
    
    
    @Test
    public void testCorrectTaskDescription() {
        boolean expected = true;
        
        assertEquals(expected, task.checkTaskDescription(taskDescription1));
    }
    
    @Test
    public void testWrongTaskDescription() {
        boolean expected = false;
        
        assertEquals(expected, task.checkTaskDescription(taskDescription2));
    }
    
    @Test
    public void testCorrectTaskID() {        
        assertEquals(taskID1, task.createTaskID(taskName1, taskNo1, developerDetails1));
    }
    
    @Test
    public void testReturnTotalHours() {
        int[] taskDurations = {taskDuration1, taskDuration2};
        int expected = taskDuration1 + taskDuration2;
        assertEquals(expected, task.returnTotalHours(taskDurations));
    }
    
}
