package com.epam.audiomanager.util.valid;

public class ValidationSamePasswords {
    public static boolean checkSamePasswords(String firstPassword, String secondPassword){
        return firstPassword.equals(secondPassword);
    }
}
