package com.epam.training.task2.exception;

public class RestoreFileException extends Exception {
    public RestoreFileException() {
    }

    public RestoreFileException(String message) {
        super(message);
    }

    public RestoreFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestoreFileException(Throwable cause) {
        super(cause);
    }

    public RestoreFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
