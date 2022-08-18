package org.example;

import java.util.HashSet;
import java.util.Set;

public class Calculator {
    public int Add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public void longCalculation() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Integer> digitSet(int number) {
        Set<Integer> integers = new HashSet<Integer>();
        String numberString = String.valueOf(number);

        for (int i = 0; i < numberString.length(); i++) {

            if (numberString.charAt(i) != '-') {
                integers.add(Integer.parseInt(numberString, i, i + 1, 10));
            }

        }
        return integers;
    }


}
