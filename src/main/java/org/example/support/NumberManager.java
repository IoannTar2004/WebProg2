package org.example.support;

import java.util.Locale;

public abstract class NumberManager {
    public static String valueOf(double n) {
        String num = String.valueOf(n);
        if (num.length() > 4) {
            return String.format(Locale.ENGLISH,"%.2f", n);
        } else if (num.charAt(num.length() - 1) == '0') {
            return String.format(Locale.ENGLISH,"%.0f", n);
        }
        return num;
    }
}
