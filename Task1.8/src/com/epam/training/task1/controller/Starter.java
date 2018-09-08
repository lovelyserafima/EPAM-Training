package com.epam.training.task1.controller;

/**
 * Starter is the class-tester of business-logic.
 *
 * -version 3.2
 * 29 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task1.exception.NegativeNumberException;
import com.epam.training.task1.exception.WrongRangeOfRandomException;
import com.epam.training.task1.exception.WrongTypeOfComfortException;
import com.epam.training.task1.model.entity.PassengerTrain;
import com.epam.training.task1.logic.TrainCharacteristic;
import com.epam.training.task1.logic.Searcher;
import com.epam.training.task1.logic.Sorter;
import com.epam.training.task1.util.initialization.IntegerInitializer;
import com.epam.training.task1.util.initialization.PassengerTrainInitializer;
import org.apache.log4j.Logger;


public class Starter {
    //logging information
    private static final Logger LOG = Logger.getLogger(Starter.class);

    public static void main(String[] args) {
        try {
            LOG.info("Application started...");
            LOG.info("Making passenger train...");

            //making passenger train
            PassengerTrain passengerTrain = new PassengerTrain();

            LOG.info("Passenger train was made...");
            LOG.info("Initialization of passenger train...");

            //initialization passenger train with specific number of carriages
            int numberOfCarriages = 10;
            PassengerTrainInitializer.initPassengerTrain(passengerTrain, numberOfCarriages);

            LOG.info("Initialization was successfully done...");
            LOG.info("Printing information about passenger train:");

            //printing information about passenger train
            LOG.info(passengerTrain);
            LOG.info("Testing business-logic...");

            if (!passengerTrain.isEmpty()) {
                //total number of passengers in train;
                LOG.info("Total number of passengers = "
                        + TrainCharacteristic.countTotalNumberOfPassengers(passengerTrain));

                //total luggage weight
                LOG.info("Total luggage weight = " + TrainCharacteristic.countTotalLuggageWeight(passengerTrain));

                //sorting
                LOG.info("Passenger train after sorting carriages by type of comfort:");
                Sorter.sortPassengerCarriagesByTypeOfComfort(passengerTrain);
                LOG.info(passengerTrain);

                //find carriages with specific range
                int leftBorder = IntegerInitializer.initNumber(0, 100);
                int rightBorder = IntegerInitializer.initNumber(leftBorder, 100);
                LOG.info("Carriages with number of passengers in range: [" + leftBorder + ", " + rightBorder + "]:");
                Searcher.findCarriagesWithSpecificNumberOfPassengers(passengerTrain, leftBorder, rightBorder);
            }
        } catch (WrongTypeOfComfortException e) {
            LOG.info(e.getMessage());
            LOG.error(e.getMessage() + e.getTypeOfComfort(), e);
        } catch (NegativeNumberException e) {
            LOG.info(e.getMessage());
            LOG.error(e.getMessage() + e.getNumber(), e);
        } catch (WrongRangeOfRandomException e) {
            LOG.info(e.getMessage());
            LOG.error(e.getMessage(), e);
        } finally {
            LOG.info("The application was stopped! Thank you for working with us:)");
        }
    }
}

