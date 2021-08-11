package com.andrii.palii.commands;

import com.andrii.palii.Scan;
import com.andrii.palii.commands.room.Room;

import java.util.Scanner;

public class RemoveToys implements Command{
        Room room;

        public RemoveToys(Room room) {
            this.room = room;
        }

        @Override
        public void execute() {
            Scanner scanner= Scan.getScanner();
            room.printRoom();
            int choose;
            choose = Integer.parseInt(scanner.nextLine());
            room.removeToys(choose);
        }
    }
