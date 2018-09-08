package com.epam.training.task1.exception;

/**
 * WrongRangeOfRandomException is the class-exception which throws the exception when user tries to random wrong
 * options.
 *
 * 18 July 2018
 * @author Arthur Lyup
 */

public class WrongRangeOfRandomException extends Exception {
    public WrongRangeOfRandomException() {
    }

    public WrongRangeOfRandomException(String message) {
        super(message);
    }

    public WrongRangeOfRandomException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongRangeOfRandomException(Throwable cause) {
        super(cause);
    }

    public WrongRangeOfRandomException(String message, Throwable cause, boolean enableSuppression, boolean
            writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
