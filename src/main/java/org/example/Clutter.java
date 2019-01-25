package org.example;

import java.util.Arrays;
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
        return Arrays.stream(item.split(" "))
                .anyMatch(word -> word.compareToIgnoreCase(subString) == 0);
    }
}
