package com.piggymetrics.notification.utilities;

public class Util {
    private Util() {}

    public static boolean changeBoolean(boolean parameter){
        return !parameter;
    }

    public static String reverse(String parameter) {
        if (parameter == null) {
            return null;
        }
        return new StringBuilder(parameter).reverse().toString();
    }
}
