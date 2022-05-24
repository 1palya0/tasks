package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        String regex = "#([0-9a-fA-F]{6}|[0-9a-fA-F]{3})";
        if(color==null){
            return false;
        }
        return Pattern.matches(regex, color);
    }
}





