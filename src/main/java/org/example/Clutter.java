package org.example;

import java.util.ArrayList;
import java.util.List;

public class Clutter {
    public static List<String> findStringsContaining(final List<String> source, final String subString) {
        final List<String> result = new ArrayList<>();

        if (subString != null && !subString.isEmpty()) {
            for (String item:source) {
                final String[] words = item.split(" ");
                for (String word:words) {
                    if (word.compareToIgnoreCase(subString) == 0) {
                        result.add(item);
                    }
                }
            }
        }

        return result;
    }
}
