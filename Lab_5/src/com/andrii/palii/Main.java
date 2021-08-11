package com.andrii.palii;


import com.andrii.palii.commands.Menu;
import com.andrii.palii.commands.room.Room;

import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Room room=new Room();
        Menu menu=new Menu(room);
    }
}
