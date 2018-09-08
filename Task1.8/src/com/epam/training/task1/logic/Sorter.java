package com.epam.training.task1.logic;

/**
 * Sorter is the class of business-logic which solves the following tasks:
 * -sorts passenger carriages by types of comfort.
 *
 * 17 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task1.model.entity.PassengerTrain;
import java.util.Collections;

public class Sorter {
    //sorting
    public static void sortPassengerCarriagesByTypeOfComfort(PassengerTrain passengerTrain){
        Collections.sort(passengerTrain.getCarriages());
    }
}

