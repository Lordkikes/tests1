package org.example.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class AddTest {

    @InjectMocks
    private Add add;
    @Mock
    private ValidNumber validNumber;

    @Mock
    private Print print;

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

    @Test
    void addDoubleToIntThenAnswerTest(){
        Answer<Integer> answer = new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                return 7;
            }
        };

        when(validNumber.doubleToInt(7.7)).thenAnswer(answer);
        assertEquals(14, add.addInt(7.7));
    }


    //Arrange
    //Act
    //Assert
    @Test
    void patterTest(){
        //Arrange
        when(validNumber.check(4)).thenReturn(true);
        when(validNumber.check(5)).thenReturn(true);

        //Act
        int result = add.add(4, 5);

        //Assert
        assertEquals(9, result);

    }

    //Given
    //When
    //Then
    @Test
    void patterBDDTest(){
        //Given
        given(validNumber.check(4)).willReturn(true);
        given(validNumber.check(5)).willReturn(true);

        //When
        int result = add.add(4, 5);

        //Then
        assertEquals(9, result);
    }

    @Test
    void argumentMatcherTest(){
        //Given
        given(validNumber.check(anyInt())).willReturn(true);

        //When
        int result = add.add(4, 5);

        //Then
        assertEquals(9, result);
    }

    @Test
    void addPrinTest(){
        //Given
        given(validNumber.check(4)).willReturn(true);
        //When
        add.addPrint(4, 4);
        //Then
        //verify(validNumber).check(4);
        verify(validNumber, times(2)).check(4);
    }



}