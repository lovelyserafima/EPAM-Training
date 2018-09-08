package com.epam.training.task1.exception;

/**
 * NegativeNumberException is the class-exception which throws the exception if user tries to work with negative numbers
 * which can't be < 0 logically.
 *
 * 17 July 2018
 * @author Arthur Lyup
 */

public class NegativeNumberException extends Exception {
    private double number;

    public NegativeNumberException(){}

    public NegativeNumberException(String msg){
        super(msg);
    }

    public NegativeNumberException(String msg, double number){
        super(msg);
        this.number = number;
    }

    public NegativeNumberException(String msg, Exception e){
        super(msg, e);
    }

    public double getNumber(){
        return number;
    }
}
