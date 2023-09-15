package com.nisum.demo.utils;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

    public static Matcher validarPasswordString(String password, String regExp){
        Pattern pattern = Pattern.compile(regExp);
        return pattern.matcher(password);
    }

    public static String getJWTToken(String username) {
        String secretKey = "4qhq8LrEBfYCaRHohdb9zURb2rf8e7Ud";

        String token = Jwts
                .builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes())).compact();

        return token;
    }
}
