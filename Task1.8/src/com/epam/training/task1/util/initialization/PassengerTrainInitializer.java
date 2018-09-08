package com.epam.training.task1.util.initialization;

/**
 * PassengerTrainInitializer is the class-initializer which initialize passenger trains by randoming different values.
 *
 * 18 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task1.exception.NegativeNumberException;
import com.epam.training.task1.exception.WrongTypeOfComfortException;
import com.epam.training.task1.model.entity.PassengerTrain;
import com.epam.training.task1.model.entity.carriage.freight.FreightCarriage;
import com.epam.training.task1.model.entity.carriage.passenger.PassengerCarriage;
import org.apache.log4j.Logger;
import java.util.Random;

public class PassengerTrainInitializer {
    //constant values
    private static final int MIN_NATURAL_NUMBER = 1;
    private static final int RIGHT_BORDER_NUMBER = 1000;
    private static final int LEFT_BORDER_NUMBER = 0;
    private static final String[] NAMES = {"Rusich", "Yauza", "Oka", "Moscow", "Wind", "Lightning", "Tit", "Volga",
            "Bullfinch", "Meteor", "Capital", "Megapolis", "Lena", "Talgo", "Peregrine Falcon", "Swallow", "Dove"};
    //logging information
    private static final Logger LOG = Logger.getLogger(PassengerTrainInitializer.class);

    //initialization of passenger train
    public static void initPassengerTrain(PassengerTrain passengerTrain, int numberOfCarriages)
            throws WrongTypeOfComfortException, NegativeNumberException {
        if (numberOfCarriages < MIN_NATURAL_NUMBER){
            throw new NegativeNumberException("Number of carriages can't be < 0!: ", numberOfCarriages);
        }
        passengerTrain.setName(NAMES[getRandomInt(0, NAMES.length)]);
        Random random = new Random();
        LOG.info( "Initialization of carriages...");
        for (int i = 0; i < numberOfCarriages; i++){
            if (random.nextBoolean()){
                PassengerCarriage passengerCarriage = new PassengerCarriage();
                passengerCarriage.setNumber(getRandomInt(LEFT_BORDER_NUMBER, RIGHT_BORDER_NUMBER));
                CarriageInitializer.initPassengerCarriage(passengerCarriage);
                passengerTrain.addCarriages(passengerCarriage);
            } else {
                FreightCarriage freightCarriage = new FreightCarriage();
                freightCarriage.setNumber(getRandomInt(LEFT_BORDER_NUMBER, RIGHT_BORDER_NUMBER));
                CarriageInitializer.initFreightCarriage(freightCarriage);
                passengerTrain.addCarriages(freightCarriage);
            }
        }
    }

    //random int number
    private static int getRandomInt(int leftBorder, int rightBorder){
        return new Random().nextInt(rightBorder - leftBorder) + leftBorder;
    }
}

