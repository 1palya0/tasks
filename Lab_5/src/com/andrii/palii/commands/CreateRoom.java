package com.andrii.palii.commands;

import com.andrii.palii.commands.room.Room;

public class CreateRoom implements Command {
    Room room;

    public CreateRoom(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        room.createRoom();
    }
}
