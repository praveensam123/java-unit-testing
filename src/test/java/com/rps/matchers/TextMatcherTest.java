package com.rps.matchers;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TextMatcherTest {

    @Test
    public void verify_emptyString() {
        assertThat("", emptyString());
        assertThat("", notNullValue());
    }

    @Test
    public void verify_emptyOrNullString() {
        assertThat("", emptyOrNullString());
        assertThat(null, emptyOrNullString());
    }

    @Test
    public void verify_sameStringsWithSameCase_areEqual() {
        String valueOne = "foot";
        String valueTwo = "foot";
        assertThat(valueOne, equalTo(valueTwo));
    }

    @Test
    public void verify_differentStrings_areNotEqual() {
        String valueOne = "foot";
        String valueTwo = "teeth";
        assertThat(valueOne, not(equalTo(valueTwo)));
    }

    @Test
    public void verify_sameStringsWithWhiteSpaces_areEqual() {
        String valueOne = "foot";
        String valueTwo = " foot   ";
        assertThat(valueOne, equalToCompressingWhiteSpace(valueTwo));
    }

    @Test
    public void verify_sameStringsWithDifferentCase_areEqual() {
        String valueOne = "foot";
        String valueTwo = "FOOt";
        assertThat(valueOne, equalToIgnoringCase(valueTwo));
    }

    @Test
    public void verify_string_contains_anotherString() {
        String actualText = "geography";
        String expectedText = "graph";
        assertThat(actualText, containsString(expectedText));
    }

    @Test
    public void verify_string_startsWith_anotherString() {
        String actualText = "geography";
        String expectedText = "geo";
        assertThat(actualText, startsWith(expectedText));
    }

    @Test
    public void verify_string_startsWith_anotherStringIgnoringCase() {
        String actualText = "geography";
        String expectedText = "GEO";
        assertThat(actualText, startsWithIgnoringCase(expectedText));
    }

    @Test
    public void verify_string_endsWith_anotherString() {
        String actualText = "geography";
        String expectedText = "graphy";
        assertThat(actualText, endsWith(expectedText));
    }

    @Test
    public void verify_string_meets_multipleConditions() {
        String actualText = "geography";
        assertThat(actualText, allOf(startsWith("geo"), endsWith("graphy")));
    }

    @Test
    public void verify_string_meets_anyOneCondition() {
        String actualText = "geography";
        assertThat(actualText, anyOf(startsWith("geo"), startsWith("hist")));
    }
}
