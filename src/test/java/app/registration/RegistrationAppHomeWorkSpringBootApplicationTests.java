package app.registration;

import app.registration.dto.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RegistrationAppHomeWorkSpringBootApplicationTests {

    @Test
    void contextLoads() {
    }

    private User user;

    @BeforeEach
    public void setUp() {

        user = new User("test@ya.ru", "880088888");

    }

    @Test
    @DisplayName("When an object is created by passing parameters, then the test is correct.")
    void userCheckArgument() {
        String username = "test@ya.ru";
        String password = "880088888";

        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
    }

    @Test
    @DisplayName("When login and email do not match, then they are correct.")
    void notEqualEmailAndLogin() {
        assertNotEquals(user.getUsername(), user.getPassword());
    }

    @Test
    @DisplayName("When the email address contains the characters '@' and '.', then the test is correct.")
    void checkEmail() {

        assertTrue(user.getUsername().contains("@"));
        assertTrue(user.getUsername().contains("."));
    }
}
