package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _02_PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dimensions = scanner.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int columns = Integer.parseInt(dimensions.split("\\s+")[1]);
        int[][] matrix = new int [rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] inputData = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = inputData[j];
            }
        }
        int numToSearch = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int currentNum = matrix[i][j];
                if (currentNum == numToSearch){
                    System.out.println(i + " " + j);
                    isFound = true;
                }
            }
        }
        if(!isFound){
            System.out.println("not found");
        }
    }
}
