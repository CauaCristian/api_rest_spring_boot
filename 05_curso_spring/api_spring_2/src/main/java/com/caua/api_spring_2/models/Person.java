package com.caua.api_spring_2.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "person")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,length = 80)
    private String name;
    @Column(name = "last_name",nullable = false,length = 80)
    private String lastName;
    @Column(nullable = false,length = 100)
    private String address;
    @Column(nullable = false,length = 6)
    private String gender;

    public Person() {

    }

    public Person(long id, String name, String lastName, String address, String gender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(lastName, person.lastName) && Objects.equals(address, person.address) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, address, gender);
    }
}
