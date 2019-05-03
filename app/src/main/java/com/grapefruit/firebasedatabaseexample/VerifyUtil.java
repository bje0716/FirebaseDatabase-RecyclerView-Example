package com.grapefruit.firebasedatabaseexample;

import android.widget.EditText;

public class VerifyUtil {

    // verify string if empty
    public static boolean verifyString(String targetString) {
        if (targetString == null || targetString.length() == 0) return false;
        return true;
    }

    public static boolean verifyStrings(String... targetStrings) {
        for (int ti = 0; ti < targetStrings.length; ti++) {
            if (!verifyString(targetStrings[ti])) return false;
        }
        return true;
    }

    public static boolean verifyStringsFromEditText(EditText... targetEditTexts) {
        for (int ti = 0; ti < targetEditTexts.length; ti++) {
            if (!verifyString(targetEditTexts[ti].getText().toString())) return false;
        }
        return true;
    }
}
