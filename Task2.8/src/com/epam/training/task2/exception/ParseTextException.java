package com.epam.training.task2.exception;

/**
 * ParseTextException is the exception class which throws the exception when user tries to parse the empty text.
 *
 * 5 August 2018
 * @author Arthur Lyup
 */

public class ParseTextException extends Exception {
    public ParseTextException() {
    }

    public ParseTextException(String message) {
        super(message);
    }

    public ParseTextException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParseTextException(Throwable cause) {
        super(cause);
    }

    public ParseTextException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
