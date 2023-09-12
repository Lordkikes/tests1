package org.example.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class AddTest {

    @InjectMocks
    private Add add;
    @Mock
    private ValidNumber validNumber;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addTest(){
        when(validNumber.check(3)).thenReturn(false);
        boolean checkNumber = validNumber.check(3);
        assertEquals(false, checkNumber);
    }

    @Test
    void addMockException(){
        when(validNumber.checkZero(0)).thenThrow(new ArithmeticException("No podemos aceptar 0 "));
        Exception exception = null;
        try {
            validNumber.checkZero(0);
        }catch (ArithmeticException e){
            exception = e;
        }
        assertNotNull(exception);
    }

    @Test
    void addRealMethodTest(){
        when(validNumber.check(3)).thenCallRealMethod();
        assertEquals(true, validNumber.check(3));

        when(validNumber.check(3)).thenCallRealMethod();
        assertEquals(false, validNumber.check("3"));
    }



}