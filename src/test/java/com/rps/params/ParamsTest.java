package com.rps.params;

import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Month;
import java.util.EnumSet;
import java.util.stream.Stream;

import static java.time.Month.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParamsTest {

    /**
     * More than two params using csv source
     */
    @ParameterizedTest(name = "{0} starts with {1}")
    @CsvSource({"geography,geo", "history,hist"})
    public void verify_names_startsWith(String name, String prefix) {
        assertThat(name, startsWith(prefix));
    }

    /**
     * More than two params using csv file source
     */
    @ParameterizedTest(name = "{0} starts with {1}")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void verify_names_startsWith_fromFile(String name, String prefix) {
        assertThat(name, startsWith(prefix));
    }

    /**
     * More than two params using method source
     */
    @ParameterizedTest(name = "{0} starts with {1} and ends with {2}")
    @MethodSource("supplyInputsForEndsWithCase")
    public void verify_names_with_prefix_and_suffix(String name, String prefix, String suffix) {
        assertThat(name, allOf(
                startsWithIgnoringCase(prefix),
                endsWith(suffix)
        ));
    }

    private static Stream<Arguments> supplyInputsForEndsWithCase() {
        return Stream.of(
                Arguments.of("Engineering Mathematics", "Eng", "Mathematics"),
                Arguments.of("Professional Ethics", "Professional", "ics"),
                Arguments.of("Software Engineering", "Soft", "Engineering")
        );
    }

    /**
     * Number Value Source
     */
    @ParameterizedTest(name = "number {0} is even")
    @ValueSource(ints = {2, 4, 6, 10, 98})
    public void verify_numbers_are_even(int number) {
        assertTrue(isEven(number));
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Null Source
     */
    @ParameterizedTest(name = "Null is blank")
    @NullSource
    public void null_isBlank(String value) {
        assertTrue(Strings.isBlank(value));
    }

    /**
     * Empty Source
     */
    @ParameterizedTest(name = "Empty is blank")
    @EmptySource
    public void emptyString_isBlank(String value) {
        assertTrue(Strings.isBlank(value));
    }

    /**
     * Null and Empty Source
     */
    @ParameterizedTest(name = "{0} is blank")
    @NullAndEmptySource
    @ValueSource(strings = {"", "   "})
    public void nullAndEmpty_areBlank(String value) {
        assertTrue(Strings.isBlank(value));
    }

    /**
     * Enum Source
     */
    @ParameterizedTest(name = "{0} is a month")
    @EnumSource(Month.class)
    public void twelve_months(Month month) {
        int monthNumber = month.getValue();
        assertTrue(monthNumber >= 1 && monthNumber <= 12);
    }

    /**
     * Enum Source Mode - EXCLUDE
     */
    @ParameterizedTest(name = "{index}. {0} has 31 days")
    @EnumSource(
            value = Month.class,
            names = {"FEBRUARY", "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"},
            mode = EnumSource.Mode.EXCLUDE)
    public void months_with_more_days(Month month) {
        int daysInMonth = getDaysInMonth(month, false);
        assertThat(daysInMonth, equalTo(31));
    }

    private int getDaysInMonth(Month month, boolean isLeapYear) {
        return month.length(isLeapYear);
    }

    /**
     * Enum Source Mode - MATCH_ANY
     */
    @ParameterizedTest(name = "{0} ends with BER")
    @EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
    public void fourMonths_areEndingWith_ber(Month month) {
        EnumSet<Month> months = EnumSet.of(SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER);
        assertThat(month, in(months));
    }

}
