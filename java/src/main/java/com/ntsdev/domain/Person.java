package com.ntsdev.domain;


import org.springframework.data.annotation.Id;

/**
 * A Person object for Spring Data to persist and hydrate.
 */
public class Person {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    public Person(){
        super();
    }

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
