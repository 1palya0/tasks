package com.andrii.palii;


import com.andrii.palii.battle.BattleArena;
import com.andrii.palii.model.Droid;
import com.andrii.palii.model.Weapon;

import java.util.Scanner;

public class Main {

    private Droid firstDroid;
    private Droid secondDroid;

    public void droidFight(Droid firstDroid, Droid secondDroid) {
        this.firstDroid = firstDroid;
        this.secondDroid = secondDroid;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num=0;
        while(num!=5) {
            System.out.println("-------------------");
            System.out.println("Droid № " + num++);
            System.out.println("Enter info about droid");
            System.out.println("Enter name: ");
            System.out.print("weapon = ");
            int weaponType =scan.nextInt();
        }
        BattleArena battleArena = new BattleArena(droid1, droid2);

        Droid winner = battleArena.startFight();
        System.out.println("The winner is " + winner.getName());
    }
}

