package com.epam.training.task1.logic;

/**
 * Searcher is the class of business-logic which solves the following tasks:
 * -search carriages with specific range of numbers of passengers
 *
 * 17 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task1.model.entity.PassengerTrain;
import com.epam.training.task1.model.entity.carriage.Carriage;
import com.epam.training.task1.model.entity.carriage.passenger.PassengerCarriage;
import org.apache.log4j.Logger;

public class Searcher {
    private static final Logger LOG = Logger.getLogger(Searcher.class);

    //find carriages with specific range of numbers of passengers
    public static void findCarriagesWithSpecificNumberOfPassengers(PassengerTrain passengerTrain, int leftBorder, int
            rightBorder) {
        boolean flag = false;
        for (Carriage carriage: passengerTrain.getCarriages()){
            if (carriage instanceof PassengerCarriage &&
                    isCarriageInRange((PassengerCarriage) carriage, leftBorder, rightBorder)){
                flag = true;
                LOG.info(carriage);
            }
        }
        if (!flag){
            LOG.info("No carriages with this range.");
        }
    }

    //checks whether carriage satisfies range
    private static boolean isCarriageInRange(PassengerCarriage passengerCarriage, int leftBorder, int rightBorder){
        return passengerCarriage.getNumberOfPassengers() >= leftBorder
                && passengerCarriage.getNumberOfPassengers() <= rightBorder;
    }
}

