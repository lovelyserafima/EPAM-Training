package com.epam.training.task1.util.initialization;

/**
 * IntegerInitializer is the class-initializer which initializes integer number in range of two numbers.
 *
 * 17 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task1.exception.NegativeNumberException;
import com.epam.training.task1.exception.WrongRangeOfRandomException;
import java.util.Random;

public class IntegerInitializer {
    //constant values
    private static final int VALUE_FOR_RAND = 1;

    //initialization number
    public static int initNumber(int firstNumber, int secondNumber) throws NegativeNumberException,
            WrongRangeOfRandomException {
        if (firstNumber < 0){
            throw new NegativeNumberException("Number of passengers can't be < 0!: ", firstNumber);
        }
        if (secondNumber < 0){
            throw new NegativeNumberException("Number of passengers can't be < 0!: ", secondNumber);
        }
        if (firstNumber > secondNumber){
            throw new WrongRangeOfRandomException("Wrong range of random!: [" + firstNumber + ", " + secondNumber
                    + "]");
        }
        return new Random().nextInt(secondNumber - firstNumber + VALUE_FOR_RAND) + firstNumber;
    }
}
