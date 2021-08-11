package com.andrii.palii.commands.room;

public class Toys {
    String name;
    String sizeOfToy;
    int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSizeOfToy() {
        return sizeOfToy;
    }

    public void setSizeOfToy(String sizeOfToy) {
        this.sizeOfToy = sizeOfToy;
    }
    @Override
    public String toString() {
        return name +
                " " +",Розмір: " + sizeOfToy+"  "+ price +
                " грн" ;
    }

    public Toys(String name, String sizeOfToy, int price) {
        this.name = name;
        this.sizeOfToy = sizeOfToy;
        this.price = price;
    }
}
