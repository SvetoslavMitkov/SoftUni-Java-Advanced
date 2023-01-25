package SetsAndMaps;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> parkingLot = new LinkedHashSet<>();

        while (!input.equals("END")){
            String direction = input.split(", ")[0];
            String carNumber = input.split(", ")[1];

            if (direction.equals("IN")){
                parkingLot.add(carNumber);
            }else if (direction.equals("OUT")){
                if (!parkingLot.isEmpty()){
                    parkingLot.remove(carNumber);
                }
            }
            input = scanner.nextLine();
        }
        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            for (String carNumber : parkingLot) {
                System.out.println(carNumber);
            }
        }

    }

}
