package org.example;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class Clutter {
    public static List<String> findStringsContaining(List<String> source, String subString) {
        if (subString == null || subString.isEmpty()) {
            return emptyList();
        }

        return source.stream()
                .filter(item -> matches(item, subString))
                .collect(Collectors.toList());
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
