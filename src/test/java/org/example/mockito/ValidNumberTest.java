package org.example.mockito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidNumberTest {

    private ValidNumber validNumber;

    @BeforeEach
    public void setUp(){
        validNumber = new ValidNumber();
    }

    @AfterEach
    public void tearDown(){
        validNumber = null;
    }

    @Test
    void checkTest(){
        assertTrue(validNumber.check(5));
    }

    @Test
    void checkTestNegative(){
        assertFalse(validNumber.check(-5));
    }

    @Test
    void checkStringTest(){
        assertFalse(validNumber.check("5"));
    }

    @Test
    void checkZeroTest(){
        assertEquals(true, validNumber.checkZero(-57));
    }
    @Test
    void checkZeroStringTest(){
        assertEquals(false, validNumber.checkZero("5"));
    }
    @Test
    void checkZero0StringTest(){
        assertThrows(ArithmeticException.class, ()-> validNumber.checkZero(0));
    }

    @Test
    void doubleToIntTest(){
        assertEquals(9, validNumber.doubleToInt(9.999));
    }

    @Test
    void doubleToIntErrorTest(){
        assertEquals(0, validNumber.doubleToInt("9.999"));
    }

}