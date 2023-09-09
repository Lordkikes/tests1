package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;
    private Calculator calculatorNull;
    private static Calculator calculatorStatic;

    @BeforeAll
    public static void beforeAllTests(){
        calculatorStatic = new Calculator();
        System.out.println("@BeforeAll -> beforeAllTests()");
    }

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

    @AfterAll
    public static void afterAllTests(){
        calculatorStatic = new Calculator();
        System.out.println("@AfterAll -> afterAllTests()");
    }

    @Test
    public void calculatorNotNullTest(){
        assertNotNull(calculatorStatic, "Calculator debe ser not null");
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

    @Test
    @DisplayName("Metodo dividir -> Funciona")
    void divicion_ValidInput_ValidResultExpected_Name_Test() {
        assertEquals(2, calculator.divicion(6,3));
    }

    @Nested
    class AddTest{
        @Test
        public void add_Positive_Tetst(){
            assertEquals(30, calculator.sumar(20,10));
        }
        @Test
        public void add_Negative_Tetst(){
            assertEquals(-30, calculator.sumar(-20,-10));
        }
        @Test
        public void add_Zero_Tetst(){
            assertEquals(0, calculator.sumar(0,0));
        }
    }

    @Disabled
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @MethodSource("addProviderData")
    public void addParameterizedTes(int a, int b, int sum ){
        assertEquals(sum, calculator.sumar(a, b));
    }

    private static Stream<Arguments> addProviderData(){
        return Stream.of(
                Arguments.of(6,2,8),
                Arguments.of(-6,-2,-8),
                Arguments.of(6,-2,4),
                Arguments.of(-6,2,-4),
                Arguments.of(6,0,6)
        );
    }

    @Test
    void timeOut_Test(){
        assertTimeout(Duration.ofMillis(2000), ()->{
            calculator.longTaskOperation();
        });
    }



}