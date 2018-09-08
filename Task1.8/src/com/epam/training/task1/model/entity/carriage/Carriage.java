package com.epam.training.task1.model.entity.carriage;

/**
 * Carriage is the superclass which has information about default carriage:
 * - number(int)
 * and has two children-classes:
 * -PassengerCarriage
 * -FreightCarriage
 *
 * It implements Comparable<Carriage> to compare carriages by type of carriage (Passenger and Freight).
 *
 * 18 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task1.exception.NegativeNumberException;
import com.epam.training.task1.model.entity.carriage.passenger.PassengerCarriage;

public class Carriage implements Comparable<Carriage> {
    //common field of all carriages
    protected int number;

    //constant values
    protected static final int POSITIVE_RESULT = 1;
    protected static final int NEGATIVE_RESULT = -1;

    //the empty constructor
    public Carriage(){}

    //constructor with args
    public Carriage(int number) {
        this.number = number;
    }

    //getters and setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) throws NegativeNumberException {
        if (number < 0){
            throw new NegativeNumberException("The number of carriage can't be < 0!: ", number);
        }
        this.number = number;
    }

    //checks whether carriage is passenger or not
    @Override
    public int compareTo(Carriage carriage) {
        return carriage instanceof PassengerCarriage ? NEGATIVE_RESULT : POSITIVE_RESULT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (null == o){ return false;}
        if (getClass() != o.getClass()){ return false;}

        Carriage carriage = (Carriage) o;
        if (number != carriage.number){ return false;}
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime*number;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                " number=" + number +
                '}';
    }
}
