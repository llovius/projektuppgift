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
                else {
                    System.out.println("Orimligt spelarantal - försök igen!");
                }
            }
            scanner.nextLine();
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
            System.out.println("Ge namnet på spelare nr" + (i + 1) + ":");
            String namn = scanner.nextLine();
            players[i].setName(namn);
        }

        // Spelet kan börja

        boolean mer = true;
        int[] res = new int[nrPlayers];
        while (mer) {
            int resMax = 0;
            for (int i = 0; i < nrPlayers; i++) {
                res[i] = Player.geText(players[i], scanner);
                if (res[i] > resMax) {
                    resMax = res[i];
                }
            }
            System.out.println("==============================================================");
            System.out.print("         Bästa resultat " + resMax + "   |   ");
            System.out.print("Grattis");
            for (int i = 0; i < nrPlayers; i++) {
                if (res[i] == resMax) {
                    System.out.print(" " + players[i].getName());
                }
            }
            System.out.println("\n==============================================================");
            boolean hasNo01 = true;
            while (hasNo01) {
                System.out.println("\nVill du: köra mer?/(tryck 1) | Lägga ner?/(tryck 0):");
                if (scanner.hasNextInt()) {
                    int intRead = scanner.nextInt();
                    if (intRead == 0) {
                        mer = false;
                        hasNo01 = false;
                    } else if (intRead == 1) {
                        hasNo01 = false;
                    }
                }
                scanner.nextLine();
            }
        }
    }
}


