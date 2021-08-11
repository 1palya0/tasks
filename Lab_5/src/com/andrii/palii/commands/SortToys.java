package com.andrii.palii.commands;

import com.andrii.palii.commands.room.Room;

public class SortToys implements Command{
   Room room;

    public SortToys(Room room) {
        this.room = room;
    }


    @Override
    public void execute() {
        room.sortToys();
    }
}
