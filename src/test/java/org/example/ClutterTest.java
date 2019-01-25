package org.example;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.example.Clutter.findStringsContaining;

public class ClutterTest {
    @Test
    public void withEmptyListFindsNothing() {
        assertThat(findStringsContaining(emptyList(), "hello")).isEmpty();
    }

    @Test
    public void withOneMatchingElementFindsIt() {
        assertThat(findStringsContaining(singletonList("hello"), "hello"))
                .containsExactly("hello");
    }

    @Test
    public void withEmptySubstringFindsNothing() {
        assertThat(findStringsContaining(singletonList("hello"), ""))
                .isEmpty();
    }

    @Test
    public void withNullSubstringFindsNothing() {
        assertThat(findStringsContaining(singletonList("hello"), null))
                .isEmpty();
    }

    @Test
    public void withDifferentCaseFindsMatch() {
        assertThat(findStringsContaining(singletonList("hello"), "HELLO"))
                .containsExactly("hello");
    }

    @Test
    public void findsMatchWithinLargerString() {
        assertThat(findStringsContaining(singletonList("good morning hello goodbye"), "hello"))
                .containsExactly("good morning hello goodbye");
    }

    @Test
    public void matchMustBeWholeWord() {
        assertThat(findStringsContaining(singletonList("good morning hello goodbye"), "he"))
                .isEmpty();
    }

    @Test
    public void canFindMultipleMatches() {
        assertThat(findStringsContaining(asList("the end", "the", "middle", "the beginning"), "the"))
                .containsExactly("the end", "the", "the beginning");
    }
}
