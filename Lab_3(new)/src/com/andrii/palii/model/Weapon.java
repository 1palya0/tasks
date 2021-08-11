package com.andrii.palii.model;

public class Weapon {
    final int Pistol=1;
    final int Sword=2;
    final int Rifle=3;
    protected String name;
    protected int damage;
    protected int type;

    public void pistol1(){
        name="Pistol";
        damage =15;
        this.type=this.Pistol;
    }

    public void sword1(){
        name="Sword";
        damage=10;
        this.type=this.Sword;
    }

    public void rifle1(){
        name="Rifle";
        damage=20;
        this.type=this.Rifle;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getType() {
        return type;
    }
}
