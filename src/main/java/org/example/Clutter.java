package org.example;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class Clutter {
    public static List<String> findStringsContaining(final List<String> source, final String subString) {
        if (subString == null || subString.isEmpty()) {
            return emptyList();
        }

        final List<String> result = new ArrayList<>();
        for (String item : source) {
            final String[] words = item.split(" ");
            for (String word : words) {
                if (word.compareToIgnoreCase(subString) == 0) {
                    result.add(item);
                }
            }
        }
        return result;
    }
}
