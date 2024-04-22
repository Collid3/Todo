/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package todo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class TodoTest {
    
    public TodoTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Todo.main(args);
        fail("The test case is a prototype.");
    }
    
     @Test
    public void testCorrectUsernameFormat() {
        System.out.println("checkUserName");
        String username = "kyl_1";
        Register instance = new Register();
        boolean expResult = true;
        boolean result = instance.checkUserName(username);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIncorrectUsernameFormat() {
        System.out.println("checkUserName");
        String username = "kyle!!!!!!!";
        Register instance = new Register();
        boolean expResult = false;
        boolean result = instance.checkUserName(username);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testCorrectPasswordFormat() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch&&sec@ke99!";
        Register instance = new Register();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testIncorrectPasswordFormat() {
        System.out.println("checkPasswordComplexity");
        String password = "password";
        Register instance = new Register();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
