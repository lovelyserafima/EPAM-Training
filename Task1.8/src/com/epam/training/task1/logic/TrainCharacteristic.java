package com.epam.training.task1.logic;

/**
 * TrainCharacteristic is the class of business-logic which solves the following tasks:
 * -calculating total number of passengers
 * -calculating total luggage weight
 *
 * 22 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task1.model.entity.PassengerTrain;
import com.epam.training.task1.model.entity.carriage.Carriage;
import com.epam.training.task1.model.entity.carriage.freight.FreightCarriage;
import com.epam.training.task1.model.entity.carriage.passenger.PassengerCarriage;
import org.apache.log4j.Logger;

public class TrainCharacteristic {
    private static final Logger LOG = Logger.getLogger(TrainCharacteristic.class);

    //count total numbers of passengers
    public static int countTotalNumberOfPassengers(PassengerTrain passengerTrain){
        int totalNumberOfPassengers = 0;
        for (Carriage carriage: passengerTrain.getCarriages()){
            if (carriage instanceof PassengerCarriage){
                totalNumberOfPassengers +=
                        ((PassengerCarriage) carriage).getNumberOfPassengers();
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Counting number of passengers = " + totalNumberOfPassengers);
                }
            }
        }
        return totalNumberOfPassengers;
    }

    //count total luggageWeight
    public static double countTotalLuggageWeight(PassengerTrain passengerTrain){
        double totalLuggageWeight = 0.0;
        for (Carriage carriage: passengerTrain.getCarriages()){
            if (carriage instanceof FreightCarriage){
                totalLuggageWeight += ((FreightCarriage) carriage).getLuggageWeight();
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Counting luggage weight = " + totalLuggageWeight);
                }
            }
        }
        return totalLuggageWeight;
    }
}

