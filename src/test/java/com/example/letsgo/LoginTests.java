package com.example.letsgo;

import com.example.letsgo.service.SecurityService;
import com.example.letsgo.web.SecurityController;
import jakarta.servlet.http.HttpSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SecurityController.class)
public class LoginTests {
    @Autowired MockMvc mockMvc;
    @MockBean private SecurityService securityService;
    @Autowired HttpSession httpSession;

    @Test
    public void testInvalidLogin() throws Exception {
        String username = "invalid";
        String password = "credential";
        HttpSession session = new MockHttpSession();

        when(securityService.login(username, password, session)).thenReturn(session);

        mockMvc.perform(post("/login")
                        .param("username", username)
                        .param("password", password))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }


    @Test
    public void testValidAdminLogin() throws Exception {
        String username = "admin";
        String password = "admin";
        HttpSession session = new MockHttpSession();

        when(securityService.login(username, password, session)).thenReturn(session);

        mockMvc.perform(post("/login")
                        .param("username", username)
                        .param("password", password))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin"));
    }


}
