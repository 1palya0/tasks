package com.andrii.palii.commands;

import com.andrii.palii.commands.room.Room;

public class CreateFile implements Command {
    Room room;
    public CreateFile(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        room.createFile();
    }
}
