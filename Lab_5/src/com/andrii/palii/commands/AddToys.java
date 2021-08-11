package com.andrii.palii.commands;

import com.andrii.palii.Scan;
import com.andrii.palii.commands.room.Room;
import com.andrii.palii.commands.room.Toys;

import java.util.Scanner;


public class AddToys implements Command {
    Room room;

    public AddToys(Room room) { this.room = room; }

    @Override
    public void execute() {
        Scanner scanner = Scan.getScanner();
        room.printToys();
        int choose;
        choose = Integer.parseInt(scanner.nextLine());
        Toys toys=room.toysData.get(choose-1);
        room.addToys(toys);
    }
}

