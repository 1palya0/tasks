package com.andrii.palii.commands;

import com.andrii.palii.commands.room.Room;
import com.andrii.palii.commands.room.Toys;

public class CalculatePrice implements Command {
    Room room;


    public CalculatePrice(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        double allPrice=0;
        for(Toys s:room.chosen)
            allPrice+=s.getPrice();
        System.out.printf("Ціна кімнати: %.2f\n",allPrice);
    }
}
