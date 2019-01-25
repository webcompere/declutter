package org.example;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class Clutter {
    public static List<String> findStringsContaining(List<String> source, String subString) {
        if (subString == null || subString.isEmpty()) {
            return emptyList();
        }

        List<String> result = new ArrayList<>();
        for (String item : source) {
            if (matches(item, subString)) {
                result.add(item);
            }
        }
        return result;
    }

    private static boolean matches(String item, String subString) {
        String[] words = item.split(" ");
        for (String word : words) {
            if (word.compareToIgnoreCase(subString) == 0) {
                return true;
            }
        }
        return false;
    }
}
