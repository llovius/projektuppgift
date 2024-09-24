package se.lars.projektuppgift;

import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Scanner;

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

    public static int geText(@org.jetbrains.annotations.NotNull Player player, @NotNull Scanner scanner) {
        System.out.print("Tryck enter när du är redo att slå " + player.getName());
        scanner.nextLine();
        int slag1 = player.throwDice();
        player.setTrow1(slag1);
        int slag2 = player.throwDice();
        player.setTrow2(slag2);
        return player.presenteraResultat();
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
