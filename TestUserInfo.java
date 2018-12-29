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
        testInfo = new UserInfo();
    }

    @Test
    void testConstructor_null() {
        assertEquals(0, testInfo.getUserId());
        assertEquals(null, testInfo.getPassWd());
    }

    @Test
    void testConstructor() {
        String newPw;
        int newId;

        testInfo.setUserId(123);
        newId = testInfo.getUserId();
        testInfo.setPassWd("123456");
        newPw = testInfo.getPassWd();

        assertEquals(123, newId);
        assertEquals("123456", newPw);

    }

}
