package com.andrii.palii.commands;

import com.andrii.palii.commands.room.Room;

public class PrintToys implements Command {
    Room room;
    public PrintToys(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        room.printToys();
    }
}
