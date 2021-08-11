package com.andrii.palii.commands;

import com.andrii.palii.commands.room.Room;

public class SearchToy implements Command{
        Room room;


        public SearchToy(Room room) {
            this.room = room;
        }

        @Override
        public void execute() { room.searchToy();
        }
    }

