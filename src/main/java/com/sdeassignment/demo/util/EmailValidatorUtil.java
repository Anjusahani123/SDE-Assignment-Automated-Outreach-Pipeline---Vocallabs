package com.sdeassignment.demo.util;

public class EmailValidatorUtil {

    public static boolean isValid(String email) {

        return email != null
                && !email.isBlank()
                && email.contains("@");
    }
}
