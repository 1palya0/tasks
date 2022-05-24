package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        String regex="^[a-z0-9]+_[a-z0-9]+@epam.com";
        if(email==null){
            return false;
        }
        return Pattern.matches(regex,email);
    }
}





