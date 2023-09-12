package org.example.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class WebServiceTest {

    private WebService webService;

    @Mock
    private Callback callback;

    @BeforeEach
    public void setUp(){
        webService = new WebService();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void checkLoginErrorTest() {
        assertFalse(webService.checkLogin("user", "password"));
    }

    @Test
    void checkLoginSuccessTest() {
        assertTrue(webService.checkLogin("Alberto", "1234"));
    }

    @Test
    void testLogin() {
        // Setup viene del @BeforeEach

        // Run the test
        webService.login("Alberto", "1234", callback);

        // Verify the results
        verify(callback).onSuccess("Usuario correcto");
    }

    @Test
    void loginErrorTest(){
        webService.login("kike", "33333", callback);
        verify(callback).onFail("Error");
    }
}
