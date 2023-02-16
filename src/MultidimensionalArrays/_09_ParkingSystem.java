package MultidimensionalArrays;

import java.util.Scanner;

public class _09_ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensions = scanner.nextLine();
        int rows = Integer.parseInt(dimensions.split(" ")[0]);
        int cols = Integer.parseInt(dimensions.split(" ")[1]);

        String[][] parkingLot = new String[rows][cols];
        extracted(parkingLot);

        String input = scanner.nextLine();
        while(!input.equals("stop")){
            int entryRowZ = Integer.parseInt(input.split(" ")[0]);
            int X = Integer.parseInt(input.split(" ")[1]);
            int Y = Integer.parseInt(input.split(" ")[2]);
            if (!parkingLot[X][Y].equals("P")){
                parkingLot[X][Y] = "P";
                int distance = Math.abs(entryRowZ - X) + Y + 1;
                System.out.println(distance);
            }else{
                boolean isValid = false;
                for (int i = 1; i < parkingLot[0].length; i++) {
                   if (!parkingLot[X][i].equals("P")){
                       parkingLot[X][i] = "P";
                       int distance = Math.abs(entryRowZ - X) + i + 1;
                       System.out.println(distance);
                       isValid = true;
                       break;
                   }
                }
                if (!isValid) System.out.printf("Row %d full%n", X);
            }
            input = scanner.nextLine();
        }
    }

    private static void extracted(String[][] parkingLot) {
        for (int row = 0; row < parkingLot.length; row++) {
            for (int col = 0; col < parkingLot[0].length; col++) {
                parkingLot[row][col] = ".";
            }
        }
    }
}
