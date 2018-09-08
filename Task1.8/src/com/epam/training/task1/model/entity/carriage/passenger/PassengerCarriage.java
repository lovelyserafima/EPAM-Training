package com.epam.training.task1.model.entity.carriage.passenger;

/**
 * PassengerCarriage is the class-entity which has information about passenger carriage of the train:
 * -number of passengers (integer)
 * -type of comfort (enum)
 *
 * It extends class Carriage.
 *
 * 18 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task1.exception.NegativeNumberException;
import com.epam.training.task1.exception.WrongTypeOfComfortException;
import com.epam.training.task1.model.entity.carriage.Carriage;

public class PassengerCarriage extends Carriage {
    //fields
    private int numberOfPassengers;
    private Comfort typeOfComfort;

    //the empty constructor
    public PassengerCarriage(){
        super();
    }

    //constructor with args
    public PassengerCarriage(int number, int numberOfPassengers, String typeOfComfort) {
        super(number);
        this.numberOfPassengers = numberOfPassengers;
        this.typeOfComfort = Comfort.valueOf(typeOfComfort.toUpperCase());
    }

    //getters and setters
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) throws NegativeNumberException {
        if (numberOfPassengers < 0){
            throw new NegativeNumberException("The number of passenger can't be < 0!: ", numberOfPassengers);
        }
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getTypeOfComfort() {
        return typeOfComfort.toString();
    }

    //special init for type of comfort (enum type)
    public void setTypeOfComfort(String typeOfComfort) throws WrongTypeOfComfortException {
        typeOfComfort = typeOfComfort.toUpperCase();
        switch (typeOfComfort){
            case "SEAT":
                this.typeOfComfort = Comfort.SEAT;
                break;
            case "COMMON":
                this.typeOfComfort = Comfort.COMMON;
                break;
            case "RESERVED_SEAT":
                this.typeOfComfort = Comfort.RESERVED_SEAT;
                break;
            case "COMPARTMENT":
                this.typeOfComfort = Comfort.COMPARTMENT;
                break;
            case "SUITE":
                this.typeOfComfort = Comfort.SUITE;
                break;
            default:
                throw new WrongTypeOfComfortException("Wrong type of comfort!: ", typeOfComfort);
        }
    }

    //compares carriages by type of comfort
    @Override
    public int compareTo(Carriage carriage){
        if (carriage instanceof PassengerCarriage) {
            return this.typeOfComfort.getLevelOfComfort()
                    < ((PassengerCarriage) carriage).typeOfComfort.getLevelOfComfort()
                    ? NEGATIVE_RESULT : POSITIVE_RESULT;
        }
        return POSITIVE_RESULT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (null == o){ return false;}
        if (getClass() != o.getClass()){ return false;}

        PassengerCarriage passengerCarriage = (PassengerCarriage) o;
        if (!super.equals(passengerCarriage)){ return  false;}
        if (numberOfPassengers != passengerCarriage.numberOfPassengers){ return false;}
        if (null == typeOfComfort){ return typeOfComfort == passengerCarriage.typeOfComfort;}
        else{
            if(!typeOfComfort.equals(passengerCarriage.typeOfComfort)){ return false;}
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = super.hashCode();
        result += prime*numberOfPassengers + ((null == typeOfComfort) ? 0 : typeOfComfort.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "\n" + getClass().getSimpleName() + "{" +
                "number=" + number +
                ", numberOfPassengers=" + numberOfPassengers +
                ", typeOfComfort=" + typeOfComfort +
                '}';
    }
}

