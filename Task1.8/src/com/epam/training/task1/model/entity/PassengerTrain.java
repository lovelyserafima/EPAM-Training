package com.epam.training.task1.model.entity;

/**
 * PassengerTrain is the class-entity which has information about passenger train:
 * -name(String)
 * -carriages(List of Carriage)
 *
 * It has methods for adding carriages and checking whether passenger train is empty or not.
 *
 * 17 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task1.model.entity.carriage.Carriage;
import java.util.ArrayList;
import java.util.List;

public class PassengerTrain {
    //fields
    private String name;
    private List<Carriage> carriages = new ArrayList<>();

    //the empty constructor
    public PassengerTrain(){}

    //constructor with args
    public PassengerTrain(String name, ArrayList<Carriage> carriages) {
        this.name = name;
        this.carriages = carriages;
    }

    //getters and setters
    public List<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //adding carriages
    public void addCarriages(Carriage... carriages){
        for (Carriage carriage: carriages){
            this.carriages.add(carriage);
        }
    }

    //checks whether passenger train is empty
    public boolean isEmpty(){
        return carriages.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (null == o){ return false;}
        if (getClass() != o.getClass()){ return false;}

        PassengerTrain passengerTrain = (PassengerTrain) o;
        if (null == name){ return name == passengerTrain.name;}
        else {
            if (!name.equals(passengerTrain.name)){ return false;}
        }
        if (null == carriages){ return carriages == passengerTrain.carriages;}
        else {
            if (!carriages.equals(passengerTrain.carriages)){ return false;}
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime + ((null == name) ? 0 : name.hashCode()) + ((null == carriages) ? 0 : carriages.hashCode());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":\n" +
                "name='" + name + '\'' +
                ", carriages:" + carriages;
    }
}

