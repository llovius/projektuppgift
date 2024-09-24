package se.lars.projektuppgift;

import java.util.Scanner;

public class Proj1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // SKRIV IN ANTAL PLAYERS

        boolean hasIntInput = false;
        int nrPlayers = 0;
        while (!hasIntInput) {
            System.out.println("Väkommen, ange antal spelare");
            if (scanner.hasNextInt()) {
                nrPlayers = scanner.nextInt();
                if (nrPlayers > 1 && nrPlayers <= 10) {
                    hasIntInput = true;
                }
               scanner.nextLine();
            } else {
        //        scanner.nextLine();
            }
        }

        Player[] players = new Player[nrPlayers];

        // Verkar vara tvungen att gå via play1 och for-satsen för att inte players[i] ska vara null
        // Trots new satsen ovan. Känns inte konsekvent...

        for (int i = 0; i < nrPlayers; i++) {
            Player play1 = new Player();
            players[i] = play1;
        }

        // Namnge deltagarna

        for (int i = 0; i < nrPlayers; i++) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            System.out.println("Ge namnet på spelare nr" + (i + 1) + ":");
            String namn = scanner.nextLine();
            players[i].setName(namn);
        }


        // scanner.nextLine();

        boolean mer = true;
        int[] kalle;
//        int[] res = new int[players.length];
        int[] res = new int[nrPlayers];
        while (mer) {
            int resMax = 0;

            for (int i = 0; i < nrPlayers; i++) {
                res[i] = Player.geText(players[i], scanner);
                if (res[i] > resMax) {
                    resMax = res[i];
                }
            }
            System.out.println("         Bästa resultat " + resMax);
            System.out.println("==============================================================");
            System.out.print("Grattis");
            for (int i = 0; i < nrPlayers; i++) {
                if (res[i] == resMax) {
                    System.out.print(" " + players[i].getName());
                }
            }
            System.out.println("");
            System.out.println("==============================================================");

            System.out.println("");
            System.out.print("Vill du köra mer? tryck 1");

            if (scanner.nextInt() != 1) {
                mer = false;
                scanner.nextLine();
            }
        }
    }


}

