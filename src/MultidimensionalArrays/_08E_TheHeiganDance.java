package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _08E_TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chamber = new String[15][15];
        int[] playerPosition = {7, 7};
        double damage = Double.parseDouble(scanner.nextLine());
        double playerHealth = 18500;
        double HeiganHealth = 3000000;
        int cloudDuration = 0;

        fillChamber(chamber);

        while (playerHealth >= 0 && HeiganHealth >= 0) {
            String[] inputArr = scanner.nextLine().split(" ");
            String spell = inputArr[0];
            int spellPositionX = Integer.parseInt(inputArr[1]);
            int spellPositionY = Integer.parseInt(inputArr[2]);
            HeiganHealth -= damage;

            if(cloudDuration <= 0) {
                clearCloudSpell(chamber);
            }

            clearEruption(chamber);

            applySpell(chamber, spell, spellPositionX, spellPositionY);

            if (playerHealth >= 0 && HeiganHealth >= 0) {
                if (tryToMove(chamber, playerPosition));
            }

            playerHealth = getPlayerHealth(chamber, playerPosition, playerHealth);

            if (spell.equals("Cloud")){
                cloudDuration = 3;
            }

            cloudDuration--;
        }
        if (playerHealth <= 0){
            System.out.printf("Heigan: %.2f%n",HeiganHealth);
            String lastSpell = "";
            if (chamber[playerPosition[0]][playerPosition[1]].equals("C")){
                lastSpell = "Plagued Cloud";
            }else if(chamber[playerPosition[0]][playerPosition[1]].equals("E")) {
                lastSpell = "Eruption";
            }
            System.out.printf("Player: Killed by %s%n", lastSpell);
            System.out.printf("Final position: %d, %d", playerPosition[0], playerPosition[1]);
        }else if(HeiganHealth <= 0){
            System.out.println("Heigan: defeated");
            System.out.printf("Player: %.2f%n", playerHealth);
            System.out.printf("Final position: %d, %d", playerPosition[0], playerPosition[1]);
        }

    }

    private static void clearEruption(String[][] chamber) {
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                if (chamber[row][col].equals("E")) {
                    chamber[row][col] = ".";
                }
            }
        }
    }

    private static void fillChamber(String[][] chamber) {
        for (int row = 0; row < 15 ; row++) {
            for (int col = 0; col < 15 ; col++) {
                chamber[row][col] = ".";
            }
        }
    }

    private static void clearCloudSpell(String[][] chamber) {
            for (int row = 0; row < 15; row++) {
                for (int col = 0; col < 15; col++) {
                    if (chamber[row][col].equals("C")){
                        chamber[row][col] = ".";
                }
            }
        }
    }

    private static boolean tryToMove(String[][] chamber, int[] playerPosition) {
        //try to move up
        if (!chamber[playerPosition[0] - 1][playerPosition[1]].equals("C")
                && !chamber[playerPosition[0] - 1][playerPosition[1]].equals("E")) {
            int newPosition = playerPosition[0] - 1;
            playerPosition[0] = newPosition;
            return true;
        }//try to move right
        else if (!chamber[playerPosition[0]][playerPosition[1] + 1].equals("C")
                && !chamber[playerPosition[0]][playerPosition[1] + 1].equals("E")) {
            int newPosition = playerPosition[1] + 1;
            playerPosition[1] = newPosition;
            return true;
        }//try to move down
        else if (!chamber[playerPosition[0] + 1][playerPosition[1]].equals("C")
                && !chamber[playerPosition[0] + 1][playerPosition[1]].equals("E")) {
            int newPosition = playerPosition[0];
            playerPosition[0] = newPosition;
            return true;
        }//try to move left
        else if (!chamber[playerPosition[0]][playerPosition[1] - 1].equals("C")
                && !chamber[playerPosition[0]][playerPosition[1] - 1].equals("E")) {
            int newPosition = playerPosition[1] - 1;
            playerPosition[1] = newPosition;
            return true;
        }
        return false;
    }

    private static double getPlayerHealth(String[][] chamber, int[] playerPosition, double playerHealth) {
        if (chamber[playerPosition[0]][playerPosition[1]].equals("C")) {
            playerHealth -= 3500;
        } else if (chamber[playerPosition[0]][playerPosition[1]].equals("E")) {
            playerHealth -= 6000;
        }
        return playerHealth;
    }

    private static void applySpell(String[][] chamber, String spell,
                                   int spellPositionX, int spellPositionY) {
        if (!(spellPositionX - 1 < 0 || spellPositionX + 1 > 14
        || spellPositionY - 1 < 0 || spellPositionY +1 > 14)){
        for (int row = spellPositionX - 1; row <= spellPositionX + 1; row++) {
            for (int col = spellPositionY - 1; col <= spellPositionY + 1; col++) {
                if (spell.equals("Cloud")){
                    chamber[row][col] = "C";
                }else if(spell.equals("Eruption")) {
                    chamber[row][col] = "E";
                }
                }
            }
        }else{
            System.out.println("Zadachata e kurvenska");
        }
    }
}
