package com.rps.matchers;

import com.rps.model.Animal;
import com.rps.model.Cat;
import com.rps.model.Person;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ObjectMatcherTest {

    @Test
    public void verify_toString_returns_requiredString() {
        Person person = new Person("John", "Wick");
        String personToString = person.toString();
        assertThat("John Wick", hasToString(personToString));
    }

    @Test
    public void verify_class_typeCompatibleWith_otherClass() {
        assertThat(Cat.class, typeCompatibleWith(Animal.class));
    }

    @Test
    public void verify_class_type() {
        Person personOne = new Person("John", "Wick");
        assertThat(personOne, instanceOf(Person.class));
    }

    @Test
    public void verify_twoObjectReferences_areSame() {
        Person personOne = new Person("John", "Wick");
        Person personTwo = personOne;
        assertThat(personOne, equalTo(personTwo));
        assertThat(personOne, sameInstance(personTwo));
    }

    @Test
    public void verify_twoBeans_haveSameValues() {
        Person personOne = new Person("Praveen", "Sam");
        Person personTwo = new Person("Praveen", "Sam");
        assertThat(personOne, not(equalTo(personTwo)));
        assertThat(personOne, samePropertyValuesAs(personTwo));
    }

}
