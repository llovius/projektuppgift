package se.lars.projektuppgift;

import java.util.Scanner;

public class Proj1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Player player1 = new Player();
        System.out.println("Ge namnet på spelare:");
        String namn = scanner.next();
        player1.setName(namn);

        Player player2 = new Player();
        System.out.println("Ge namnet på spelare:");
        namn = scanner.next();
        player2.setName(namn);
        scanner.nextLine();

        boolean mer = true;
        while (mer) {
            int res1 = geText(player1, scanner);
            int res2 = geText(player2, scanner);

            System.out.println();
            if (res1 == res2) {
                System.out.println("OTROLIGT OAVGJORT!");
            } else if (res1 > res2) {
                System.out.println("GRATTIS " + player1.getName());
            } else {
                System.out.println("GRATTIS " + player2.getName());
            }

            System.out.println("Köra mer - tryck 1 / Lägga ner -tryck 0");
            if (scanner.nextInt() != 1) {
                mer = false;
                scanner.nextLine();
            }
        }
    }

    public static int geText(Player player, Scanner scanner) {
 //       scanner.nextLine();
        System.out.print("Tryck enter när du är redo att slå " + player.getName());
        scanner.nextLine();
        int slag1 = player.throwDice();
        player.setTrow1(slag1);
        int slag2 = player.throwDice();
        player.setTrow2(slag2);
        return player.presenteraResultat();
    }


}
