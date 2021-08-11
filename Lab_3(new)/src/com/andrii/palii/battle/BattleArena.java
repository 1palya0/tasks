package com.andrii.palii.battle;
import com.andrii.palii.model.Droid;

import java.util.Random;

public class BattleArena {

    private Droid firstDroid;
    private Droid secondDroid;
    private Droid thirdDroid;
    private Droid fourthDroid;
    private Droid assaulter;
    private Droid target;

    public BattleArena(Droid firstDroid, Droid secondDroid) {
        this.firstDroid = firstDroid;
        this.secondDroid = secondDroid;
    }

    public Droid startFight() {

        int round = 1;

        do {
            printRoundInformation(round);
            setOpponents();

            int damage = assaulter.getDamage();
            target.getHit(damage);

            System.out.println(target.getName() + " was hit by " + assaulter.getName() + " with damage=" + damage);
            round++;
        } while (target.isAlive());

        return assaulter;
    }

    private void printRoundInformation(int round) {
        System.out.println("_____________________");
        System.out.println("Round " + round);
    }

    private void setOpponents() {
        if (new Random().nextBoolean()) {
            assaulter = firstDroid;
            target = secondDroid;
        } else {
            assaulter = secondDroid;
            target = firstDroid;
        }
    }
}
