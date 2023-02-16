package MultidimensionalArrays;

import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String [][] trace = new String[size][size];

        String carNumber = scanner.nextLine();

        fillMatrix(trace,scanner);

        int[] carPosition = {0, 0};

        String command = scanner.nextLine();

        int km = 0;
        int[] tunnelStart = {0, 0};
        int[] tunnelEnd = {0, 0};
        tunnelSearch(trace, tunnelStart, tunnelEnd);

        while (!command.equals("End")){
         switch (command){
             case "left":
                 carPosition [1] = carPosition[1] - 1;
                 break;
             case "right":
                 carPosition [1] = carPosition[1] + 1;
                 break;
             case "up":
                 carPosition [0] = carPosition[0] - 1;
                 break;
             case "down":
                 carPosition [0] = carPosition[0] + 1;
                 break;
         }
            if (trace[carPosition[0]][carPosition[1]].equals("F")){
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                System.out.printf("Distance covered %d km.%n", km + 10);
                trace[carPosition[0]][carPosition[1]] = "C";
                printMatrix(trace);
                return;
            }
            //проверява позицията на която сме се преместили ("." или "Т") и връща изминати км.
            km = getKm(trace, carPosition, km, tunnelStart, tunnelEnd);
            command = scanner.nextLine();
        }
        System.out.printf("Racing car %s DNF.%n", carNumber);
        System.out.printf("Distance covered %d km.%n", km);
        trace[carPosition[0]][carPosition[1]] = "C";
        printMatrix(trace);
    }

    private static int  getKm(String[][] trace, int[] carPosition, int km, int[] tunnelStart, int[] tunnelEnd) {
        //Извиква в себе си метода goThroughTunnel ако текущата позиция е равна на "T".
        if (trace[carPosition[0]][carPosition[1]].equals(".")){
           km += 10;
        }else if (trace[carPosition[0]][carPosition[1]].equals("T")){
            goThroughTunnel(carPosition, tunnelStart, tunnelEnd);
            trace[tunnelStart[0]][tunnelStart[1]] = ".";
            trace[tunnelEnd[0]][tunnelEnd[1]] = ".";
            km += 30;
        }
        return km;
    }

    private static void goThroughTunnel(int[] carPosition, int[] tunnelStart, int[] tunnelEnd) {
        if (carPosition[0] == tunnelStart[0] && carPosition[1] == tunnelStart[1]){
            //ако е вярно значи сме на старта на тунела и излизаме в края
            carPosition[0] = tunnelEnd[0];
            carPosition[1] = tunnelEnd[1];
        }else{
            //влизаме в края и излизаме в началото
            carPosition[0] = tunnelStart[0];
            carPosition[1] = tunnelStart[1];
        }
    }

    private static void tunnelSearch(String[][] trace, int[] tunnelStart, int[] tunnelEnd) {
        for (int rows = 0; rows < trace.length; rows++) {
            for (int cols = 0; cols < trace.length; cols++) {
                String current = trace[rows][cols];
                if (current.equals("T")){
                    if (tunnelStart[0] == 0 && tunnelStart[1] == 0) {
                        tunnelStart[0] = rows;
                        tunnelStart[1] = cols;
                    }else{
                        tunnelEnd[0] = rows;
                        tunnelEnd[1] = cols;
                    }
                }
            }
        }
    }

    private static void fillMatrix (String[][] matrix, Scanner scanner){
        for (int rows = 0; rows < matrix.length; rows++) {
            matrix[rows] = scanner.nextLine().split(" ");
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }

}
