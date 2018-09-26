package com.epam.audiomanager.util.valid;

public class ValidationPassword {
    private static final String CHECK_PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";

    public static boolean isCorrectPassword(String password){
        return password.matches(CHECK_PASSWORD);
    }
}
