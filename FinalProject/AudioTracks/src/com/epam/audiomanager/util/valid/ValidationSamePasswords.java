package com.epam.audiomanager.util.valid;

public class ValidationSamePasswords {
    public static boolean arePasswordsEqual(String firstPassword, String secondPassword){
        return firstPassword.equals(secondPassword);
    }
}
