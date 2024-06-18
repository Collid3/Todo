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
public class LoginTest {
    Login login = new Login();

    @Test
    public void testCorrectUserNameFormat() {
        String username = "ky_12";
        boolean expected = true;
        
        assertEquals(expected, login.checkUserName(username));
    }
    
    @Test
    public void testWrongUserNameFormat() {
        String username = "kyle!!!!!!!";
        boolean expected = false;
        
        assertEquals(expected, login.checkUserName(username));
    }

    @Test
    public void testCorrectPasswordComplexity() {
        String password = "Ch&&sec@ke99!";
        boolean expected = true;
        
        assertEquals(expected, login.checkPasswordComplexity(password));
    }

    @Test
    public void testWrongPasswordComplexity() {
        String password = "password";
        boolean expected = false;
        
        assertEquals(expected, login.checkPasswordComplexity(password));
    }

    @Test
    public void testLoginSuccessful() {
        String actualUsername = "ky_12";
        String actualPassword = "Brockie@20";
        
        String username = "ky_12";
        String password = "Brockie@20";
        boolean expected = true;
        
        assertEquals(expected, login.loginUser(actualUsername, username, actualPassword,password));
    }

    @Test
    public void testLoginFailed() {
        String actualUsername = "ky_12";
        String actualPassword = "Brockie@20";
        
        String username = "ky_12";
        String password = "Brockie";
        boolean expected = false;
        
        assertEquals(expected, login.loginUser(actualUsername, username, actualPassword,password));
    }
    
}
