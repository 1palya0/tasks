package com.epam.rd.autotasks;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        char initialCharacter = Character.isUpperCase(shot.charAt(0)) ? 'A' : 'a';
        int firstValue = Integer.parseInt(String.valueOf((shot.charAt(0) - initialCharacter + 1)));
        int secondValue = Integer.parseInt(String.valueOf(shot.charAt(1)));
        firstValue = 8 - firstValue;
        secondValue = 8 - secondValue;
        int position = 8 * secondValue + firstValue;
        shots |= Long.rotateLeft(1, position);

        return checkBit(position, ships);
    }

    public String state() {
        StringBuilder state = new StringBuilder(68);
        for(int i = 7; i >= 0; i--){
            for(int j = 7; j >= 0; j--){
                char cell = '.';
                int position = 8 * i + j;
                boolean hasBitShip = checkBit(position, ships);
                boolean isBitShot = checkBit(position, shots);
                if(hasBitShip && isBitShot){
                    cell = '☒';
                }
                if(hasBitShip && !isBitShot){
                    cell = '☐';
                }
                if(!hasBitShip && isBitShot){
                    cell = '×';
                }
                state.append(cell);
            }
            state.append('\n');
        }
        return state.toString();
    }

    private boolean checkBit(int position, long number){
        long new_num = Long.rotateRight(number, position);;
        return (new_num & 1) > 0;
    }


}
