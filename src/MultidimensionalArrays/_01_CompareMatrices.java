package MultidimensionalArrays;

import java.util.Scanner;

public class _01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] dataInfo1 = input.split("\\s+");
        int rows1 = Integer.parseInt(dataInfo1[0]);
        int columns1 = Integer.parseInt(dataInfo1[1]);
        int[][] matrix1 = new int[rows1][columns1];


        for (int row = 0; row < rows1; row++) {
                String[] numbers = scanner.nextLine().split("\\s+");
            for (int col = 0; col < columns1; col++) {
                matrix1[row][col] = Integer.parseInt(numbers[col]);
            }
        }
        input = scanner.nextLine();
        String[] dataInfo2 = input.split("\\s+");
        int rows2 = Integer.parseInt(dataInfo2[0]);
        int columns2 = Integer.parseInt(dataInfo2[1]);
        int[][] matrix2 = new int[rows2][columns2];
        for (int row = 0; row < rows2; row++) {
            String[] numbers = scanner.nextLine().split("\\s+");
            for (int col = 0; col < columns2; col++) {
                matrix2[row][col] = Integer.parseInt(numbers[col]);
            }
        }
        boolean isEqual = true;

        if (rows1 != rows2 || columns1 != columns2){
            System.out.println("not equal");
            return;
        }

        for (int i = 0; i < rows1; i++) {
            if (!isEqual){
                break;
            }
            for (int j = 0; j < columns1; j++) {
                if (matrix1[i][j] != matrix2[i][j]){
                    isEqual = false;
                    break;
                }
            }
        }
        if (isEqual){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }
}
