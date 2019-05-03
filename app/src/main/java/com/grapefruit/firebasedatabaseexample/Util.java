package com.grapefruit.firebasedatabaseexample;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Util {

    public static String getDate(Long date) {
        return new SimpleDateFormat("yyyy년 MM월 dd일 a hh:ss", Locale.KOREA).format(date);
    }
}
