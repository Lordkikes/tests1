package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureCalculatorTest {

    private TemperatureCalculator temperatureCalculator;

    @BeforeEach
    public void setUp(){
        temperatureCalculator = new TemperatureCalculator();
        System.out.println("@BeforeEach -> setUp()");
    }

    @AfterEach
    public void tearDown(){
        temperatureCalculator = null;
        System.out.println("@AfterEach -> tearDown()");
    }
    @Test
    void toFarenheit_Test() {
        assertEquals(-9.4, temperatureCalculator.toFarenheit(-23), 0.01);
    }
}