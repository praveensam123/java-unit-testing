package com.rps.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {

    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }

}
