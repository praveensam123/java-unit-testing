package com.rps.matchers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CollectionMatcherTest {

    @Test
    public void verify_collection_isEmpty() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
    }

    @Test
    public void verify_collection_size() {
        List<String> colors = Arrays.asList("RED", "GREEN", "YELLOW", "BLUE");
        assertThat(colors, hasSize(4));
    }

    @Test
    public void verify_collection_elements() {
        List<String> colors = Arrays.asList("RED", "GREEN", "YELLOW", "BLUE");
        assertThat(colors, containsInAnyOrder("BLUE", "GREEN", "RED", "YELLOW"));
    }

    @Test
    public void verify_collection_elements_inOrder() {
        List<String> colors = Arrays.asList("RED", "GREEN", "YELLOW", "BLUE");
        assertThat(colors, contains("RED", "GREEN", "YELLOW", "BLUE"));
    }

    @Test
    public void verify_collection_meetsCondition() {
        List<Integer> colors = Arrays.asList(2, 4, 6);
        assertThat(colors, everyItem(greaterThan(1)));
    }
}
