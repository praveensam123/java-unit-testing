package com.rps.matchers;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MapMatcherTest {

    @Test
    public void verify_map_hasKey() {
        Map<String, String> bookNames = new HashMap<>();
        bookNames.put("bookName", "Java - Complete Reference");
        assertThat(bookNames, hasKey("bookName"));
    }

    @Test
    public void verify_map_hasValue() {
        Map<String, String> bookNames = new HashMap<>();
        bookNames.put("bookName", "Java - Complete Reference");
        assertThat(bookNames, hasValue("Java - Complete Reference"));
    }

    @Test
    public void verify_map_hasEntry() {
        Map<String, String> bookNames = new HashMap<>();
        bookNames.put("bookName", "Java - Complete Reference");
        assertThat(bookNames, hasEntry("bookName", "Java - Complete Reference"));
    }
}
