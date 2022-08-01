package com.rps.matchers;

import com.rps.model.Person;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

public class BeanMatcherTest {

    @Test
    public void verify_properties_of_a_bean() {
        Person person = new Person("Praveen", "Sam");
        assertThat(person, hasProperty("firstName"));
        assertThat(person, hasProperty("lastName"));
    }

    @Test
    public void verify_propertyValues_of_a_bean() {
        Person person = new Person("Praveen", "Sam");
        assertThat(person, hasProperty("firstName", equalTo("Praveen")));
        assertThat(person, hasProperty("lastName", equalTo("Sam")));
    }
}
