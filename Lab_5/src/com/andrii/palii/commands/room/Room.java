package com.andrii.palii.commands.room;


import com.andrii.palii.Scan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Room {
    public List<Toys> toysData;
    public List<Toys> chosen;
    public List<Toys> filteredToys;

    public Room() throws FileNotFoundException {
        this.toysData = setToys();
        this.chosen = new ArrayList<>();
        this.filteredToys = new ArrayList<>();
    }
    private List<Toys> setToys() throws FileNotFoundException {
        List<Toys> toys = new ArrayList<>();
        String fileName = "data.txt";
        File file = new File(fileName);
        try (Scanner s = new Scanner(new FileReader(file))) {
            while (s.hasNext()) {
                String name = s.nextLine();
                String sizeOfToy = s.nextLine();
                int price = Integer.parseInt(s.nextLine());
                toys.add(new Toys(name, sizeOfToy, price));
            }
            return toys;
        }
    }




    public void createRoom() {
        for (int i = 0; i < 10; i++) {
            chosen.add(i, toysData.get((int) (Math.random() *12)));
        }
    }

    public void printRoom() {
        printList(chosen);
    }

    public void addToys(Toys toys) {
        chosen.add(toys);
    }

    public void removeToys(int i) {
        chosen.remove(i-1);
    }

    public void printList(List<Toys> list) {
        int i = 1;
        for (Toys s : list) {
            System.out.println(i + "." + s);
            i++;
        }
    }

    public void printToys() {
        printList(toysData);
    }


    public void sortToys() {
        filteredToys=chosen;
        filteredToys.sort(Comparator.comparing(Toys::getSizeOfToy));
        printList(filteredToys);
    }

    public void searchToy() {
        double min ;
        double max ;
        int i = 1;
        Scanner scanner = Scan.getScanner();
        System.out.println("Введіть діапазон ціни:");
        min = Double.parseDouble(scanner.nextLine());
        max = Double.parseDouble(scanner.nextLine());
        for (Toys s : chosen) {
            if (s.getPrice() > min && s.getPrice() < max) {
                System.out.println(i + "." + s);
                i++;
            }
        }
    }



    public void createFile() {
        Scanner scanner = Scan.getScanner();
        System.out.print("Введіть назву файлу: ");
        String fileName = scanner.nextLine();
        try ( PrintWriter writer = new PrintWriter(new File(fileName)) ) {
            double allPrice=0;
            writer.write( "\tКімната \n");
            for ( Toys entry : chosen ) {
                writer.write( entry.toString() + "\n");
                allPrice+=entry.getPrice();
            }
            writer.write("\nЦіна кімнати: "+allPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

