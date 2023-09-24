package com.nisum.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

    public static Matcher validarPasswordString(String password, String regExp){
        Pattern pattern = Pattern.compile(regExp);
        return pattern.matcher(password);
    }

}
