package org.example;

public class Calculator {
    public int Add(int a, int b) {
        return a + b ;
    }

    public int multiply(int a, int b) {
        return a * b ;
    }

    public void longCalculation(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
