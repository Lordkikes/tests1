package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;
    private Calculator calculatorNull;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
        System.out.println("@BeforeEach -> setUp()");
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
        System.out.println("@AfterEach -> tearDown()");
    }

    @Test
    public void calculatorNotNullTest(){
        assertNotNull(calculator, "Calculator debe ser not null");
        System.out.println("@Test -> calculatorNotNullTest()");
    }

    @Test
    public void calculatorNullTest(){
        assertNull(calculatorNull);
        System.out.println("@Test -> calculatorNullTest()");
    }

    @Test
    public void addAssertTest(){
        //1. SetUp lo que necesito para el test

        int resultadoEsperado = 30;
        int resultadoActual;

        //2. Accion a ejecutar en el test
        resultadoActual = calculator.sumar(10, 20);

        //3. Assert para validar el test
        assertEquals(resultadoEsperado, resultadoActual);
        System.out.println("@Test -> addAssertTest()");
    }

    @Test //igual que el anterior pero optimizado
    public void addTest(){
        assertEquals(30, calculator.sumar(10, 20));
    }

}