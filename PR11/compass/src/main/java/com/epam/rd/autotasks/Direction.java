package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;




    public static Direction ofDegrees(int degrees) {
        if (degrees > 315 || degrees < 0) { degrees = degrees % 360; }
        if (degrees < 0) { degrees = 360 - Math.abs(degrees); }
        for (Direction d : Direction.values()) {
            if (degrees == d.degrees) { return d; }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        if (degrees > 315 || degrees < 0) { degrees = degrees % 360; }
        if (degrees < 0) { degrees = 360 - Math.abs(degrees); }
        for (Direction d:Direction.values()) {
            if(d.degrees==degrees || Math.abs(d.degrees - degrees) < 25){
                return Direction.ofDegrees(d.degrees);
            }
        }
        return Direction.N;
    }

    public Direction opposite() {
        return Direction.ofDegrees(degrees + 180);
    }
    public int differenceDegreesTo(Direction direction) {
        if (Math.abs(degrees-direction.degrees) >= 315) {
            return 360 - direction.degrees;
        }
        return Math.abs(degrees - direction.degrees);
    }


}

