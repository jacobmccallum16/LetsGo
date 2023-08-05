package com.example.letsgo;

import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static junit.framework.TestCase.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LetsGoApplicationTests {

    @Autowired private MockMvc mockMvc;


    // Testing user "Test Rider" who has only has an active rider account
    @Test
    public void testLoginRiderUsername() throws Exception {
        System.out.println("---Logging in to a rider account with username---");
        String usernameEmail = "testrider";
        String password = "testrider";
        MultiValueMap<String, String> requestBody1 = new LinkedMultiValueMap<>();
        requestBody1.add("username", usernameEmail);
        requestBody1.add("password", password);

        System.out.println("Logging with these credentials: { username: \"" + usernameEmail + "\", password: \"" + password + "\"}");
        MvcResult result1 = mockMvc.perform(post("/login").params(requestBody1))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Logged in successfully, now using assertEquals() to evaluate the resulting HttpSession object");
        HttpSession session = result1.getRequest().getSession();
        assertEquals("USER", session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals("Rider", session.getAttribute("ROLE"));
        assertEquals("Test", session.getAttribute("firstName"));
        assertEquals("Rider", session.getAttribute("lastName"));
        assertEquals("Test Rider", session.getAttribute("fullName"));
        assertEquals(20, session.getAttribute("userId"));
        assertEquals("Active", session.getAttribute("userStatus"));
        assertEquals(21, session.getAttribute("riderId"));
        assertEquals("Active", session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));


        System.out.println("Logging out");
        MvcResult result2 = mockMvc.perform(get("/logout"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Using assertEquals() to test that the user logged out and the HttpSession object was invalidated");
        session = result2.getRequest().getSession();
        assertEquals(null, session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals(null, session.getAttribute("ROLE"));
        assertEquals(null, session.getAttribute("firstName"));
        assertEquals(null, session.getAttribute("lastName"));
        assertEquals(null, session.getAttribute("fullName"));
        assertEquals(null, session.getAttribute("userId"));
        assertEquals(null, session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));

        System.out.println("Success!");
    }
    @Test
    public void testLoginRiderEmail() throws Exception {
        System.out.println("---Logging in to a rider account with email---");
        String usernameEmail = "testrider@gmail.com";
        String password = "testrider";
        MultiValueMap<String, String> requestBody1 = new LinkedMultiValueMap<>();
        requestBody1.add("username", usernameEmail);
        requestBody1.add("password", password);

        System.out.println("Logging with these credentials: { username: \"" + usernameEmail + "\", password: \"" + password + "\"}");
        MvcResult result1 = mockMvc.perform(post("/login").params(requestBody1))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Logged in successfully, now using assertEquals() to evaluate the resulting HttpSession object");
        HttpSession session = result1.getRequest().getSession();
        assertEquals("USER", session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals("Rider", session.getAttribute("ROLE"));
        assertEquals("Test", session.getAttribute("firstName"));
        assertEquals("Rider", session.getAttribute("lastName"));
        assertEquals("Test Rider", session.getAttribute("fullName"));
        assertEquals(20, session.getAttribute("userId"));
        assertEquals("Active", session.getAttribute("userStatus"));
        assertEquals(21, session.getAttribute("riderId"));
        assertEquals("Active", session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));


        System.out.println("Logging out");
        MvcResult result2 = mockMvc.perform(get("/logout"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Using assertEquals() to test that the user logged out and the HttpSession object was invalidated");
        session = result2.getRequest().getSession();
        assertEquals(null, session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals(null, session.getAttribute("ROLE"));
        assertEquals(null, session.getAttribute("firstName"));
        assertEquals(null, session.getAttribute("lastName"));
        assertEquals(null, session.getAttribute("fullName"));
        assertEquals(null, session.getAttribute("userId"));
        assertEquals(null, session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));

        System.out.println("Success!");
    }


    // Testing user "Test Driver" who has only has an active driver account
    @Test
    public void testLoginDriverUsername() throws Exception {
        System.out.println("---Logging in to a driver account with username---");
        String usernameEmail = "testdriver";
        String password = "testdriver";
        MultiValueMap<String, String> requestBody1 = new LinkedMultiValueMap<>();
        requestBody1.add("username", usernameEmail);
        requestBody1.add("password", password);

        System.out.println("Logging with these credentials: { username: \"" + usernameEmail + "\", password: \"" + password + "\"}");
        MvcResult result1 = mockMvc.perform(post("/login").params(requestBody1))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Logged in successfully, now using assertEquals() to evaluate the resulting HttpSession object");
        HttpSession session = result1.getRequest().getSession();
        assertEquals("USER", session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals("Driver", session.getAttribute("ROLE"));
        assertEquals("Test", session.getAttribute("firstName"));
        assertEquals("Driver", session.getAttribute("lastName"));
        assertEquals("Test Driver", session.getAttribute("fullName"));
        assertEquals(21, session.getAttribute("userId"));
        assertEquals("Active", session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(25, session.getAttribute("driverId"));
        assertEquals("Active", session.getAttribute("driverStatus"));

        System.out.println("Logging out");
        MvcResult result2 = mockMvc.perform(get("/logout"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Using assertEquals() to test that the user logged out and the HttpSession object was invalidated");
        session = result2.getRequest().getSession();
        assertEquals(null, session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals(null, session.getAttribute("ROLE"));
        assertEquals(null, session.getAttribute("firstName"));
        assertEquals(null, session.getAttribute("lastName"));
        assertEquals(null, session.getAttribute("fullName"));
        assertEquals(null, session.getAttribute("userId"));
        assertEquals(null, session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));

        System.out.println("Success!");
    }
    @Test
    public void testLoginDriverEmail() throws Exception {
        System.out.println("---Logging in to a driver account with email---");
        String usernameEmail = "testdriver@gmail.com";
        String password = "testdriver";
        MultiValueMap<String, String> requestBody1 = new LinkedMultiValueMap<>();
        requestBody1.add("username", usernameEmail);
        requestBody1.add("password", password);

        System.out.println("Logging with these credentials: { username: \"" + usernameEmail + "\", password: \"" + password + "\"}");
        MvcResult result1 = mockMvc.perform(post("/login").params(requestBody1))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Logged in successfully, now using assertEquals() to evaluate the resulting HttpSession object");
        HttpSession session = result1.getRequest().getSession();
        assertEquals("USER", session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals("Driver", session.getAttribute("ROLE"));
        assertEquals("Test", session.getAttribute("firstName"));
        assertEquals("Driver", session.getAttribute("lastName"));
        assertEquals("Test Driver", session.getAttribute("fullName"));
        assertEquals(21, session.getAttribute("userId"));
        assertEquals("Active", session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(25, session.getAttribute("driverId"));
        assertEquals("Active", session.getAttribute("driverStatus"));

        System.out.println("Logging out");
        MvcResult result2 = mockMvc.perform(get("/logout"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Using assertEquals() to test that the user logged out and the HttpSession object was invalidated");
        session = result2.getRequest().getSession();
        assertEquals(null, session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals(null, session.getAttribute("ROLE"));
        assertEquals(null, session.getAttribute("firstName"));
        assertEquals(null, session.getAttribute("lastName"));
        assertEquals(null, session.getAttribute("fullName"));
        assertEquals(null, session.getAttribute("userId"));
        assertEquals(null, session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));

        System.out.println("Success!");
    }

    // Testing user "Test RiderDriver" who is both a driver and a rider
    @Test
    public void testLoginRiderDriver() throws Exception {
        System.out.println("---Logging in to a dual rider-driver account with email---");
        String usernameEmail = "testriderdriver@gmail.com";
        String password = "testriderdriver";
        MultiValueMap<String, String> requestBody1 = new LinkedMultiValueMap<>();
        requestBody1.add("username", usernameEmail);
        requestBody1.add("password", password);

        System.out.println("Logging with these credentials: { username: \"" + usernameEmail + "\", password: \"" + password + "\"}");
        MvcResult result1 = mockMvc.perform(post("/login").params(requestBody1))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Logged in successfully, now using assertEquals() to evaluate the resulting HttpSession object");
        HttpSession session = result1.getRequest().getSession();
        assertEquals("USER", session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        // dual rider-driver accounts will log in to their driver account by default.
        assertEquals("Driver", session.getAttribute("ROLE"));
        assertEquals("Test", session.getAttribute("firstName"));
        assertEquals("RiderDriver", session.getAttribute("lastName"));
        assertEquals("Test RiderDriver", session.getAttribute("fullName"));
        assertEquals(22, session.getAttribute("userId"));
        assertEquals("Active", session.getAttribute("userStatus"));
        assertEquals(23, session.getAttribute("riderId"));
        assertEquals("Active", session.getAttribute("riderStatus"));
        assertEquals(26, session.getAttribute("driverId"));
        assertEquals("Active", session.getAttribute("driverStatus"));

        System.out.println("Logging out");
        MvcResult result2 = mockMvc.perform(get("/logout"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Using assertEquals() to test that the user logged out and the HttpSession object was invalidated");
        session = result2.getRequest().getSession();
        assertEquals(null, session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals(null, session.getAttribute("ROLE"));
        assertEquals(null, session.getAttribute("firstName"));
        assertEquals(null, session.getAttribute("lastName"));
        assertEquals(null, session.getAttribute("fullName"));
        assertEquals(null, session.getAttribute("userId"));
        assertEquals(null, session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));

        System.out.println("Success!");
    }


    // Testing user "Test Admin" who is just an admin. All admins have user accounts at least.
    // Technically, in the database all users have rider and driver accounts too, but they're only
    // treated as existing once they get activated, and the entire web app functionality treats
    // accounts that are not active as being accounts that don't exist but could be created easily.
    @Test
    public void testLoginAdmin() throws Exception {
        System.out.println("---Logging in to an admin account with email---");
        String usernameEmail = "testadmin@gmail.com";
        String password = "testadmin";
        MultiValueMap<String, String> requestBody1 = new LinkedMultiValueMap<>();
        requestBody1.add("username", usernameEmail);
        requestBody1.add("password", password);

        System.out.println("Logging with these credentials: { username: \"" + usernameEmail + "\", password: \"" + password + "\"}");
        MvcResult result1 = mockMvc.perform(post("/login").params(requestBody1))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Logged in successfully, now using assertEquals() to evaluate the resulting HttpSession object");
        HttpSession session = result1.getRequest().getSession();
        assertEquals("ADMIN", session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals("Admin", session.getAttribute("ROLE"));
        assertEquals("Test", session.getAttribute("firstName"));
        assertEquals("Admin", session.getAttribute("lastName"));
        assertEquals("Test Admin", session.getAttribute("fullName"));
        assertEquals(23, session.getAttribute("userId"));
        assertEquals("Active", session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));

        System.out.println("Logging out");
        MvcResult result2 = mockMvc.perform(get("/logout"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Using assertEquals() to test that the user logged out and the HttpSession object was invalidated");
        session = result2.getRequest().getSession();
        assertEquals(null, session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals(null, session.getAttribute("ROLE"));
        assertEquals(null, session.getAttribute("firstName"));
        assertEquals(null, session.getAttribute("lastName"));
        assertEquals(null, session.getAttribute("fullName"));
        assertEquals(null, session.getAttribute("userId"));
        assertEquals(null, session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));

        System.out.println("Success!");
    }


    // Testing user "Test RiderDriverAdmin" who is a driver, a rider, and an admin.
    @Test
    public void testLoginRiderDriverAdmin() throws Exception {
        System.out.println("---Logging in to a rider-driver-admin account with email---");
        String usernameEmail = "testriderdriveradmin@gmail.com";
        String password = "testriderdriveradmin";
        MultiValueMap<String, String> requestBody1 = new LinkedMultiValueMap<>();
        requestBody1.add("username", usernameEmail);
        requestBody1.add("password", password);

        System.out.println("Logging with these credentials: { username: \"" + usernameEmail + "\", password: \"" + password + "\"}");
        MvcResult result1 = mockMvc.perform(post("/login").params(requestBody1))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Logged in successfully, now using assertEquals() to evaluate the resulting HttpSession object");
        HttpSession session = result1.getRequest().getSession();
        assertEquals("ADMIN", session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        // Admin role is prioritized over Rider and Driver ROLEs.
        // This doesn't change much except where the user gets sent if they click on anything
        // that links to "/homepage". The ROLE attribute determines what the homepage is,
        // and when users switch to their other accounts the ROLE gets set to the account they've
        // switched to.
        assertEquals("Admin", session.getAttribute("ROLE"));
        assertEquals("Test", session.getAttribute("firstName"));
        assertEquals("RiderDriverAdmin", session.getAttribute("lastName"));
        assertEquals("Test RiderDriverAdmin", session.getAttribute("fullName"));
        assertEquals(24, session.getAttribute("userId"));
        assertEquals("Active", session.getAttribute("userStatus"));
        assertEquals(25, session.getAttribute("riderId"));
        assertEquals("Active", session.getAttribute("riderStatus"));
        assertEquals(28, session.getAttribute("driverId"));
        assertEquals("Active", session.getAttribute("driverStatus"));

        System.out.println("Logging out");
        MvcResult result2 = mockMvc.perform(get("/logout"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Using assertEquals() to test that the user logged out and the HttpSession object was invalidated");
        session = result2.getRequest().getSession();
        assertEquals(null, session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals(null, session.getAttribute("ROLE"));
        assertEquals(null, session.getAttribute("firstName"));
        assertEquals(null, session.getAttribute("lastName"));
        assertEquals(null, session.getAttribute("fullName"));
        assertEquals(null, session.getAttribute("userId"));
        assertEquals(null, session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));
        System.out.println("Success!");
    }


    // Testing the "admin" "admin" bypass. Obviously it's not super secure,
    // but it's neat to see that it's working.
    // This bypass checks the database first, so if there is a user with these account
    // credentials the bypass would log into that user's account!
    @Test
    public void testLoginAdminAdmin() throws Exception {
        System.out.println("---Logging in with the \"admin\" \"admin\" bypass---");
        String usernameEmail = "admin";
        String password = "admin";
        MultiValueMap<String, String> requestBody1 = new LinkedMultiValueMap<>();
        requestBody1.add("username", usernameEmail);
        requestBody1.add("password", password);

        System.out.println("Logging with these credentials: { username: \"" + usernameEmail + "\", password: \"" + password + "\"}");
        MvcResult result1 = mockMvc.perform(post("/login").params(requestBody1))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Logged in successfully with \"admin\" \"admin\" bypass, now using assertEquals() to evaluate the resulting HttpSession object");
        HttpSession session = result1.getRequest().getSession();
        assertEquals("ADMIN", session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals("Admin", session.getAttribute("ROLE"));
        assertEquals("Admin", session.getAttribute("firstName"));
        assertEquals("Admin", session.getAttribute("lastName"));
        assertEquals("Admin", session.getAttribute("fullName"));
        assertEquals(null, session.getAttribute("userId"));
        assertEquals(null, session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));

        System.out.println("Logging out");
        // logout
        MvcResult result2 = mockMvc.perform(get("/logout"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Using assertEquals() to test that the user logged out and the HttpSession object was invalidated");
        session = result2.getRequest().getSession();
        assertEquals(null, session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals(null, session.getAttribute("ROLE"));
        assertEquals(null, session.getAttribute("firstName"));
        assertEquals(null, session.getAttribute("lastName"));
        assertEquals(null, session.getAttribute("fullName"));
        assertEquals(null, session.getAttribute("userId"));
        assertEquals(null, session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));

        System.out.println("Success!");
    }


    // login fail, testing an invalid login
    @Test
    public void testLoginInvalid() throws Exception {
        System.out.println("---Trying to log in to an account that doesn't exist---");
        String usernameEmail = "invalid";
        String password = "invalid";
        MultiValueMap<String, String> requestBody1 = new LinkedMultiValueMap<>();
        requestBody1.add("username", usernameEmail);
        requestBody1.add("password", password);

        System.out.println("Logging with these credentials: { username: \"" + usernameEmail + "\", password: \"" + password + "\"}");
        MvcResult result1 = mockMvc.perform(post("/login").params(requestBody1))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Login failed, now using assertEquals() to evaluate the resulting HttpSession object");
        HttpSession session = result1.getRequest().getSession();
        // the ROLE "Guest" generally functions the same as not having a role at all
        assertEquals("Guest", session.getAttribute("ROLE"));
        assertEquals(true, session.getAttribute("LOGIN_FAIL"));

        assertEquals(null, session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("firstName"));
        assertEquals(null, session.getAttribute("lastName"));
        assertEquals(null, session.getAttribute("fullName"));
        assertEquals(null, session.getAttribute("userId"));
        assertEquals(null, session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));

        System.out.println("The failure to log in was a success!");
    }


    // This was the original test so I don't want to delete it since it worked
    @Test
    public void testValidLoginCD() throws Exception {
        System.out.println("---Logging in to a rider, driver, and user account with username---");
        System.out.println("---(this was the first successful test!)---");
        String username = "cd";
        String password = "cd";
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("username", username);
        requestBody.add("password", password);

        System.out.println("Logging with these credentials: { username: \"" + username + "\", password: \"" + password + "\"}");
        MvcResult result1 = mockMvc.perform(post("/login").params(requestBody))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Logged in successfully, now using assertEquals() to evaluate the resulting HttpSession object");
        HttpSession session = result1.getRequest().getSession();

        assertEquals("ADMIN", session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals("Admin", session.getAttribute("ROLE"));
        assertEquals("C", session.getAttribute("firstName"));
        assertEquals("D", session.getAttribute("lastName"));
        assertEquals("C D", session.getAttribute("fullName"));
        assertEquals(3, session.getAttribute("userId"));
        assertEquals("Active", session.getAttribute("userStatus"));
        assertEquals(3, session.getAttribute("riderId"));
        assertEquals("Active", session.getAttribute("riderStatus"));
        assertEquals(3, session.getAttribute("driverId"));
        assertEquals("Active", session.getAttribute("driverStatus"));

        System.out.println("Logging out");
        MvcResult result2 = mockMvc.perform(get("/logout"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Using assertEquals() to test that the user logged out and the HttpSession object was invalidated");
        session = result2.getRequest().getSession();
        assertEquals(null, session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals(null, session.getAttribute("ROLE"));
        assertEquals(null, session.getAttribute("firstName"));
        assertEquals(null, session.getAttribute("lastName"));
        assertEquals(null, session.getAttribute("fullName"));
        assertEquals(null, session.getAttribute("userId"));
        assertEquals(null, session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));

        System.out.println("Success!");
    }

    // Testing user "Test Rider" with weird email capitalization
    @Test
    public void testLoginRiderUnusualEmailCapitalization() throws Exception {
        System.out.println("---Logging in to a rider account with weirdly capitalized email---");
        String usernameEmail = "TeStRiDeR@GmAiL.CoM";
        String password = "testrider";
        MultiValueMap<String, String> requestBody1 = new LinkedMultiValueMap<>();
        requestBody1.add("username", usernameEmail);
        requestBody1.add("password", password);

        System.out.println("Logging with these credentials: { username: \"" + usernameEmail + "\", password: \"" + password + "\"}");
        MvcResult result1 = mockMvc.perform(post("/login").params(requestBody1))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Login successful because emails are case insensitive");
        System.out.println("Now using assertEquals() to evaluate the resulting HttpSession object");
        HttpSession session = result1.getRequest().getSession();
        assertEquals("USER", session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals("Rider", session.getAttribute("ROLE"));
        assertEquals("Test", session.getAttribute("firstName"));
        assertEquals("Rider", session.getAttribute("lastName"));
        assertEquals("Test Rider", session.getAttribute("fullName"));
        assertEquals(20, session.getAttribute("userId"));
        assertEquals("Active", session.getAttribute("userStatus"));
        assertEquals(21, session.getAttribute("riderId"));
        assertEquals("Active", session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));

        System.out.println("Logging out");
        MvcResult result2 = mockMvc.perform(get("/logout"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Using assertEquals() to test that the user logged out and the HttpSession object was invalidated");
        session = result2.getRequest().getSession();
        assertEquals(null, session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals(null, session.getAttribute("ROLE"));
        assertEquals(null, session.getAttribute("firstName"));
        assertEquals(null, session.getAttribute("lastName"));
        assertEquals(null, session.getAttribute("fullName"));
        assertEquals(null, session.getAttribute("userId"));
        assertEquals(null, session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));

        System.out.println("Success!");
    }

    // Testing user "Test Rider" with weird email capitalization
    @Test
    public void testLoginRiderUnusualUsernameCapitalization() throws Exception {
        System.out.println("---Logging in to a rider account with weirdly capitalized username---");
        String usernameEmail = "TeStRiDeR";
        String password = "testrider";
        MultiValueMap<String, String> requestBody1 = new LinkedMultiValueMap<>();
        requestBody1.add("username", usernameEmail);
        requestBody1.add("password", password);

        System.out.println("Logging with these credentials: { username: \"" + usernameEmail + "\", password: \"" + password + "\"}");
        MvcResult result1 = mockMvc.perform(post("/login").params(requestBody1))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Log in successful because usernames are case insensitive too apparently. Maybe the repository is coercing the string to lowercase?");
        System.out.println("Now using assertEquals() to evaluate the resulting HttpSession object");
        HttpSession session = result1.getRequest().getSession();
        assertEquals("USER", session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals("Rider", session.getAttribute("ROLE"));
        assertEquals("Test", session.getAttribute("firstName"));
        assertEquals("Rider", session.getAttribute("lastName"));
        assertEquals("Test Rider", session.getAttribute("fullName"));
        assertEquals(20, session.getAttribute("userId"));
        assertEquals("Active", session.getAttribute("userStatus"));
        assertEquals(21, session.getAttribute("riderId"));
        assertEquals("Active", session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));

        System.out.println("Logging out");
        MvcResult result2 = mockMvc.perform(get("/logout"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        System.out.println("Using assertEquals() to test that the user logged out and the HttpSession object was invalidated");
        session = result2.getRequest().getSession();
        assertEquals(null, session.getAttribute("AUTH"));
        assertEquals(null, session.getAttribute("LOGIN_FAIL"));
        assertEquals(null, session.getAttribute("ROLE"));
        assertEquals(null, session.getAttribute("firstName"));
        assertEquals(null, session.getAttribute("lastName"));
        assertEquals(null, session.getAttribute("fullName"));
        assertEquals(null, session.getAttribute("userId"));
        assertEquals(null, session.getAttribute("userStatus"));
        assertEquals(null, session.getAttribute("riderId"));
        assertEquals(null, session.getAttribute("riderStatus"));
        assertEquals(null, session.getAttribute("driverId"));
        assertEquals(null, session.getAttribute("driverStatus"));

        System.out.println("Success!");
    }

}
