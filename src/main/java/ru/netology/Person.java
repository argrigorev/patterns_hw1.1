package ru.netology;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age == null ? OptionalInt.empty() : OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (age != null) {
            age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(this.hasAge() ? this.age - 20 : 0)
                .setAddress(this.hasAddress() ? this.address : "Неизвестно");
    }

    @Override
    public String toString() {
        return name + " " + surname +
                (hasAge() ? ", возраст: " + age : "") +
                (hasAddress() ? ", адрес: " + address : "");
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}