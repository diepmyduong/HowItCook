package com.example.android.howitcook;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * Created by Admin on 1/1/2016.
 */
public class StringHelper {
    public static String removeAccent(String s) {

        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }
}
