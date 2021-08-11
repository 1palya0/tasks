package com.andrii.palii.commands;

import com.andrii.palii.commands.room.Room;

public class PrintRoom implements Command {
    Room room;

    public PrintRoom(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        room.printRoom();
    }
}