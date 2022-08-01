package com.rps.matchers;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ArrayMatcherTest {

    @Test
    public void verify_array_size() {
        String[] colors = { "RED", "GREEN", "YELLOW", "BLUE" };
        assertThat(colors, arrayWithSize(4));
    }

    @Test
    public void verify_array_hasElement() {
        String[] colors = { "RED", "GREEN", "YELLOW", "BLUE" };
        assertThat(colors, hasItemInArray("YELLOW"));
    }

    @Test
    public void verify_array_hasElements() {
        String[] colors = { "RED", "GREEN", "YELLOW", "BLUE" };
        assertThat(colors, arrayContainingInAnyOrder("YELLOW", "RED", "BLUE", "GREEN"));
    }

    @Test
    public void verify_array_hasElements_inOrder() {
        String[] colors = { "RED", "GREEN", "YELLOW", "BLUE" };
        assertThat(colors, arrayContaining("RED", "GREEN", "YELLOW", "BLUE"));
    }
}
