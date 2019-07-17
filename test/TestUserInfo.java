package test;

import Model.UserInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestUserInfo {

    private UserInfo testInfo;
    private String Initial_Pw = null;

    @BeforeEach
    void setUp() {
        int initial_Id = 0;
        testInfo = new UserInfo(initial_Id, "kangjz","123");
    }

    @Test
    void testConstructor_null() {
        assertEquals(0, testInfo.getUsername());
        assertEquals(null, testInfo.getPassword());
    }

    @Test
    void testConstructor() {
        String newPw;
        String newId;

        testInfo.setUsername("123");
        newId = testInfo.getUsername();
        testInfo.setUsername("123456");
        newPw = testInfo.getPassword();

        assertEquals(123, newId);
        assertEquals("123456", newPw);

    }

}
