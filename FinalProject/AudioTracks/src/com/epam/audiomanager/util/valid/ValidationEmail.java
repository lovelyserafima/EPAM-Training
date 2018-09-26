package com.epam.audiomanager.util.valid;

public class ValidationEmail {
    private static final String CHECK_EMAIL = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@" +
            "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

    public static boolean isCorrectEmail(String email){
        return email.matches(CHECK_EMAIL);
    }
}
