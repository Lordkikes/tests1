package org.example;

import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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

    @Test
    public void add_ValidInput_ValidExpected_Test(){
        assertEquals(11, calculator.sumar(7, 4));
    }

    @Test
    public void substract_ValidInput_ValidExpected_Test(){
        assertEquals(3, calculator.restar(7, 4));
    }

    @Test
    public void substract_ValidInput_ValidNegativeResultExpected_Test(){
        assertEquals(-2, calculator.restar(7, 9));
    }
    @Test
    void divicion_ValidInput_ValidNegativeResultExpected_Test() {
        assertEquals(2, calculator.divicion(6,3));
    }

    @Test
    @Disabled("creado para ejemplo de fail")
    void divicion_InValidInput_Test() {
        assertEquals(2, calculator.divicion(6,0));
        fail("Fallo detectado manualmente - No se puede dividir por 0");
    }

    @Test
    void divicion_InValidInput_ExpectedExceptionTest() {
        assertThrows(ArithmeticException.class, ()->calculator.divicionCero(2,0), "No se puede dividir por cero");

    }

}