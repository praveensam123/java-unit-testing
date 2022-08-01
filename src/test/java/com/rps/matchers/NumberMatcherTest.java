package com.rps.matchers;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NumberMatcherTest {

    @Test
    public void verify_number_equals_input() {
        assertThat(5, equalTo(5));
    }

    @Test
    public void verify_number_greaterThan_input() {
        assertThat(5, greaterThan(3));
    }

    @Test
    public void verify_number_greaterThanOrEqualTo_input() {
        assertThat(5, greaterThanOrEqualTo(3));
        assertThat(5, greaterThanOrEqualTo(5));
    }

    @Test
    public void verify_number_lessThan_input() {
        assertThat(5, lessThan(7));
    }

    @Test
    public void verify_number_lessThanOrEqualTo_input() {
        assertThat(5, lessThanOrEqualTo(7));
        assertThat(5, lessThanOrEqualTo(5));
    }

    @Test
    public void verify_number_approximateTo_input() {
        double deviation = 0.4;
        assertThat(4.6000000000, not(closeTo(5, deviation)));
        assertThat(4.6000000001, closeTo(5, deviation));
        assertThat(5.0000000000, closeTo(5, deviation));
        assertThat(5.3999999999, closeTo(5, deviation));
        assertThat(5.4000000000, not(closeTo(5, deviation)));
    }
}
