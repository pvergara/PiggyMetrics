package com.piggymetrics.notification.utilities;

import java.util.Collection;
import java.util.stream.Collectors;

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

    public static <T> Collection<T> sort(Collection<T> parameters) {
        return parameters.stream().sorted().collect(Collectors.toList());
    }
}
