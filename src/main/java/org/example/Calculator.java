package org.example;

public class Calculator {
    private int result;
    public int sumar(int n1, int n2){
        return result = n1 + n2;
    }
    public int restar(int n1, int n2){
        return result = n1 - n2;
    }

    public int divicion(int n1, int n2){
        return result = n1 / n2;
    }
    public int divicionCero(int n1, int n2){
        if (n2 == 0){
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return result = n1 / n2;
    }


}
