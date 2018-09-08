package com.epam.training.task1.exception;

/**
 * WrongTypeOfComfortException is the class-exception which throws the exception when user tries to work with wrong type
 * of comfort.
 *
 * 17 July 2018
 * @author Arthur Lyup
 */

public class WrongTypeOfComfortException extends Exception {
    private String typeOfComfort;

    public WrongTypeOfComfortException(){}

    public WrongTypeOfComfortException(String msg){
        super(msg);
    }

    public WrongTypeOfComfortException(String msg, String typeOfComfort){
        super(msg);
        this.typeOfComfort = typeOfComfort;
    }

    public WrongTypeOfComfortException(String msg, Exception e){
        super(msg, e);
    }

    public String getTypeOfComfort(){
        return typeOfComfort;
    }
}

