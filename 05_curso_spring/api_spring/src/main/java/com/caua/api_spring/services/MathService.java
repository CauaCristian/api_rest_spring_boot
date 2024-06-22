package com.caua.api_spring.services;

public class MathService {
    public MathService() {
    }

    public Double sum(Double numberOne, Double numberTwo) throws Exception {
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne,Double numberTwo) throws Exception {
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne,Double numberTwo) throws Exception {
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo) throws Exception {
        return numberOne / numberTwo;
    }

    public Double mean(Double numberOne, Double numberTwo) throws Exception {
        return numberOne + numberTwo / 2;
    }

    public Double squareRoot(Double number) throws Exception {
        return Math.sqrt(number);
    }

}
