package com.epam.training.task1.util.initialization;

/**
 * CarriageInitializer is the class-initializer which initializes carriages by randoming different values
 *
 * 09 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task1.exception.NegativeNumberException;
import com.epam.training.task1.exception.WrongTypeOfComfortException;
import com.epam.training.task1.model.entity.carriage.freight.FreightCarriage;
import com.epam.training.task1.model.entity.carriage.passenger.Comfort;
import com.epam.training.task1.model.entity.carriage.passenger.PassengerCarriage;
import java.util.Random;

public class CarriageInitializer {
    //constant values
    private static final int VALUE_FOR_RAND = 1;
    private static final int LEFT_BORDER_PASSENGERS = 0;
    private static final int RIGHT_BORDER_PASSENGERS = 100;
    private static final double RIGHT_BORDER_LUGGAGE = 50.0;
    private static final double LEFT_BORDER_LUGGAGE = 0.0;
    private static final Comfort[] TYPES_OF_COMFORT = Comfort.values();

    //initialization of passenger carriage
    public static void initPassengerCarriage(PassengerCarriage passengerCarriage) throws NegativeNumberException,
            WrongTypeOfComfortException {
        Random random = new Random();
        passengerCarriage.setNumberOfPassengers(random.nextInt(RIGHT_BORDER_PASSENGERS - LEFT_BORDER_PASSENGERS
                + VALUE_FOR_RAND) + LEFT_BORDER_PASSENGERS);
        passengerCarriage.setTypeOfComfort(TYPES_OF_COMFORT[random.nextInt(TYPES_OF_COMFORT.length)].toString());
    }

    //initialization of freight carriage
    public static void initFreightCarriage(FreightCarriage freightCarriage) throws NegativeNumberException {
        Random random = new Random();
        freightCarriage.setLuggageWeight(random.nextDouble()*(RIGHT_BORDER_LUGGAGE - LEFT_BORDER_LUGGAGE));
    }
}

