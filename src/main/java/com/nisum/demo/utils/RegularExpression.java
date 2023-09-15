package com.nisum.demo.utils;

public class RegularExpression {

    public static final String REG_EXPRESSION_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static final  String REG_EXPRESSION_PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$";
}
