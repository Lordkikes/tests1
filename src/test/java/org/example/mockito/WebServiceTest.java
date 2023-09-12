package org.example.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WebServiceTest {

    private WebService webService;

    @BeforeEach
    public void setUp(){
        webService = new WebService();
    }

    @Test
    void checkLoginErrorTest() {
        assertFalse(webService.checkLogin("user", "password"));
    }

    @Test
    void checkLoginSuccessTest() {
        assertTrue(webService.checkLogin("Alberto", "1234"));
    }
}
