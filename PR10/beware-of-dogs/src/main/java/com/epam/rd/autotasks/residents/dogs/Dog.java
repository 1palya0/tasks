package com.epam.rd.autotasks.residents.dogs;

public class Dog <Dog>{

    protected String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog " + name;
    }
}
