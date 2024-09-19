package se.lars.projektuppgift;

import java.util.Random;

public class Player {
    private String name;
    private int trow1, trow2;

    public void setName(String name) {
        this.name = name;
    }

    public void setTrow1(int trow1) {
        this.trow1 = trow1;
    }

    public void setTrow2(int trow2) {
        this.trow2 = trow2;
    }

    public String getName() {
        return name;
    }

    public int throwDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public int presenteraResultat() {
        System.out.println("Spelare " + name + ":   " + trow1 + " " + trow2 + "   =   " + (trow1 + trow2));
        return trow1 + trow2;
    }
}
