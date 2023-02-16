package ExamPreparations;

import java.util.Scanner;

public class _02_Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        fillMatrix(matrix, scanner);
        int[] position = getStartPosition(matrix);
        int[] firstBurrow = {0, 0};
        int[] secondBurrow = {0, 0};
        burrowsSearch(matrix, firstBurrow, secondBurrow);

        int foodEaten = 0;

        boolean outOfTerritory = false;
        boolean snakeFed = false;

        while(!outOfTerritory && !snakeFed){
            String command = scanner.nextLine();
            switch (command){
                case "up":
                    if (position[0] - 1 < 0){
                        outOfTerritory = true;
                        System.out.println("Game over!");
                        break;
                    }else{
                        matrix[position[0]][position[1]] = ".";
                        position[0] -= 1;
                        if (matrix[position[0]][position[1]].equals("*")){
                            foodEaten += 1;
                            matrix[position[0]][position[1]] = ".";
                            if (foodEaten >= 10){
                                System.out.println("You won! You fed the snake.");
                                snakeFed = true;
                                matrix[position[0]][position[1]] = "S";
                                break;
                            }
                        }
                        goThroughBurrow(matrix, position, firstBurrow, secondBurrow);
                    }
                    break;
                case "down":
                    if (position[0] + 1 > matrix.length - 1){
                        outOfTerritory = true;
                        System.out.println("Game over!");
                        break;
                    }else{
                        matrix[position[0]][position[1]] = ".";
                        position[0] += 1;
                        if (matrix[position[0]][position[1]].equals("*")){
                            foodEaten += 1;
                            matrix[position[0]][position[1]] = ".";
                            if (foodEaten >= 10){
                                System.out.println("You won! You fed the snake.");
                                snakeFed = true;
                                matrix[position[0]][position[1]] = "S";
                                break;
                            }
                        }
                        goThroughBurrow(matrix, position, firstBurrow, secondBurrow);
                    }
                    break;
                case "left":
                    if (position[1] - 1 < 0){
                        outOfTerritory = true;
                        System.out.println("Game over!");
                        break;
                    }else{
                        matrix[position[0]][position[1]] = ".";
                        position[1] -= 1;
                        if (matrix[position[0]][position[1]].equals("*")){
                            foodEaten += 1;
                            matrix[position[0]][position[1]] = ".";
                            if (foodEaten >= 10){
                                System.out.println("You won! You fed the snake.");
                                snakeFed = true;
                                matrix[position[0]][position[1]] = "S";
                                break;
                            }
                        }
                        goThroughBurrow(matrix, position, firstBurrow, secondBurrow);
                    }
                    break;
                case "right":
                    if (position[1] + 1 > matrix.length - 1){
                        outOfTerritory = true;
                        System.out.println("Game over!");
                        break;
                    }else{
                        matrix[position[0]][position[1]] = ".";
                        position[1] += 1;
                        if (matrix[position[0]][position[1]].equals("*")){
                            foodEaten += 1;
                            matrix[position[0]][position[1]] = ".";
                            if (foodEaten >= 10){
                                System.out.println("You won! You fed the snake.");
                                snakeFed = true;
                                matrix[position[0]][position[1]] = "S";
                                break;
                            }
                        }
                        goThroughBurrow(matrix, position, firstBurrow, secondBurrow);
                    }
                    break;
            }
        }

        System.out.printf("Food eaten: %d%n", foodEaten);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }

    private static void goThroughBurrow(String[][] matrix, int[] position, int[] firstBurrow, int[] secondBurrow) {
        if (matrix[position[0]][position[1]].equals("B")){
            if (position[0] == firstBurrow[0] && position[1] == firstBurrow[1] ){
                position[0] = secondBurrow[0];
                position[1] = secondBurrow[1];
                matrix[firstBurrow[0]][firstBurrow[1]] = ".";
            }else{
                position[0] = firstBurrow[0];
                position[1] = firstBurrow[1];
                matrix[secondBurrow[0]][secondBurrow[1]] = ".";
            }
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
    private static int[] getStartPosition(String[][] matrix) {
        int[] position = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("S")) {
                    position[0] = row;
                    position[1] = col;
                    break;
                }
            }
        }return position;
    }

    private static void burrowsSearch(String[][] matrix, int[] firstBurrow, int[] secondBurrow) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix.length; cols++) {
                String current = matrix[rows][cols];
                if (current.equals("B")){
                    if (firstBurrow[0] == 0 && firstBurrow[1] == 0) {
                        firstBurrow[0] = rows;
                        firstBurrow[1] = cols;
                    }else{
                        secondBurrow[0] = rows;
                        secondBurrow[1] = cols;
                    }
                }
            }
        }
    }

}
