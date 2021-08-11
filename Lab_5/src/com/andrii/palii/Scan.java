package com.andrii.palii;

import java.util.Scanner;

public class Scan {

    final private static Scanner scanner = new Scanner(System.in);

    private Scan() {
    }

    public static Scanner getScanner() {
        return scanner;
    }

}
