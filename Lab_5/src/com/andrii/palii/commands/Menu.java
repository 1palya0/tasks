package com.andrii.palii.commands;

import com.andrii.palii.Scan;
import com.andrii.palii.commands.room.Room;

import java.util.Scanner;


public class Menu {
    Command addToys;
    Command removeToys;
    Command calculatePrice;
    Command sortToys;
    Command searchToy;
    Command createRoom;
    Command createFile;
    Command printRoom;
    Command printToys;

    public Menu(Room room) {
        this.addToys = new AddToys(room);
        this.removeToys = new RemoveToys(room);
        this.calculatePrice = new CalculatePrice(room);
        this.sortToys = new SortToys(room);
        this.searchToy = new SearchToy(room);
        this.createRoom = new CreateRoom(room);
        this.createFile = new CreateFile(room);
        this.printRoom = new PrintRoom(room);
        this.printToys = new PrintToys(room);
        mainMenu();
    }


    public void mainMenu() {
        Scanner scanner = Scan.getScanner();
        int option;
        while (true) {
            System.out.println("Виберіть режим роботи програми");
            System.out.println("1 - Вибрати кімнату");
            System.out.println("2 - Створити кімнату");
            System.out.println("0 - Вихід");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> {
                    System.out.println("Оберіть кімнату:");
                    chooseRoom();
                    printRoom();
                    System.out.println("\tРедагування кімнати");
                    changeMenu();
                }
                case 2 -> {
                    System.out.println("\tСтворення кімнати");
                    changeMenu();
                }
                case 0 -> {
                    System.out.println("Кінець програми...");
                    System.exit(0);
                }
                default -> System.out.println("Ви обрали неправильний режим роботи програми. Спробуйте ще раз");
            }
        }
    }

    private void printRoom() {
        printRoom.execute();
    }


    public void changeMenu() {
        Scanner scanner = Scan.getScanner();
        int option;
        do {
            System.out.println("\t1 - Додати іграшки до кімнати");
            System.out.println("\t2 - Вилучити іграшки з кімнати");
            System.out.println("\t3 - Обчислити ціну кімнати");
            System.out.println("\t4 - Сортування іграшок за розміром");
            System.out.println("\t5 - Пошук іграшок, що відповідають заданим параметрам");
            System.out.println("\t0 - Вихід у головне меню ");
            System.out.println("\t6 - Зберегти шаблон кімнати у файл");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {
                option = 0;
            }
            switch (option) {
                case 1 -> {
                    System.out.println("Оберіть іграшки\n");
                    add();
                    printRoom();
                }
                case 2 -> {
                    System.out.println("Оберіть іграшки,які хочете забрати з кімнати:");
                    remove();
                    printRoom();
                }
                case 3 -> calculate();
                case 4 -> sort();
                case 5 -> search();
                case 6 -> createFile();
                case 0 -> mainMenu();
                default -> System.out.println("Ви обрали неправильний режим роботи програми. Спробуйте ще раз");
            }
        } while (option != 0);
    }

    public void add() {
        addToys.execute();
    }

    public void remove() {
        removeToys.execute();
    }

    public void calculate() {
        calculatePrice.execute();

    }

    public void sort() {
        sortToys.execute();
    }

    public void search() {
        searchToy.execute();
    }

    private void chooseRoom() {
        Scanner scanner = Scan.getScanner();
        System.out.println("\t1 - Кімната №1 ");
        System.out.println("\t2 - Кімната №2 ");
        System.out.println("\t3 - Кімната №3 ");
        System.out.println("\t4 - Кімната №4 ");
        int option = Integer.parseInt(scanner.nextLine());
        createRoom();
    }

    public void createRoom() {
        createRoom.execute();
    }

    public void createFile() {
        createFile.execute();
    }


}