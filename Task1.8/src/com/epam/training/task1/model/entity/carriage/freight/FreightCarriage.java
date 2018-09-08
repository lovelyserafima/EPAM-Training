package com.epam.training.task1.model.entity.carriage.freight;

/**
 * FreightCarriage is the class-entity which has information about freight carriage of the train:
 * -luggageWeight (double)
 *
 * It extends class Carriage.
 *
 * 17 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task1.exception.NegativeNumberException;
import com.epam.training.task1.model.entity.carriage.Carriage;

public class FreightCarriage extends Carriage {
    //fields
    private double luggageWeight;

    //the empty constructor
    public FreightCarriage(){
        super();
    }

    //constructor with args
    public FreightCarriage(int number, double luggageWeight) {
        super(number);
        this.luggageWeight = luggageWeight;
    }

    //getters and setters
    public double getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(double luggageWeight) throws NegativeNumberException {
        if (luggageWeight < 0){
            throw new NegativeNumberException("Luggage weight can't be < 0!: ", luggageWeight);
        }
        this.luggageWeight = luggageWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (null == o){ return false;}
        if (getClass() != o.getClass()){ return false;}

        FreightCarriage freightCarriage = (FreightCarriage) o;
        if (!super.equals(freightCarriage)){ return false;}
        if (luggageWeight != freightCarriage.luggageWeight){ return false;}
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = super.hashCode();
        result += prime*luggageWeight;
        return result;
    }

    @Override
    public String toString() {
        return "\n" + getClass().getSimpleName() + "{" +
                "number=" + number +
                ", luggageWeight=" + luggageWeight +
                '}';
    }
}

