package ExamPreparations;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _02_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensions = scanner.nextLine();
        int N = Integer.parseInt(dimensions.split(" ")[0]);
        int M = Integer.parseInt(dimensions.split(" ")[1]);

        if (N <= 0 || M <= 0 )return;

        String [][] map = new String[N][M];
        int[] position = {-1, -1};

        for (int i = 0; i < N; i++) {
            String[] data = scanner.nextLine().split(" ");
            map[i] = data;
        }

        startPosition(map, position);
        Deque<String> pathQueue = new ArrayDeque<>();

        String command = scanner.nextLine();
        while(!command.equals("Finish")){
            switch (command){
                case "up":
                    if (position[0] - 1 >= 0){
                        if (!map[position[0] - 1][position[1]].equals("T")){
                            position[0] = position[0] - 1;
                            pathQueue.offer(command);
                        }
                }
                    break;
                case "down":
                    if (position[0] + 1 < map.length) {
                        if (!map[position[0] + 1][position[1]].equals("T")) {
                            position[0] = position[0] + 1;
                            pathQueue.offer(command);
                        }
                    }
                    break;
                case "right":
                    if ((position[1] + 1 < map[0].length)){
                        if (!map[position[0]][position[1] + 1].equals("T")){
                            position[1] = position[1] + 1;
                            pathQueue.offer(command);
                        }
                    }
                    break;
                case "left":
                    if (position[1] - 1 >= 0){
                        if (!map[position[0]][position[1] - 1].equals("T")){
                            position[1] = position[1] - 1;
                            pathQueue.offer(command);
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        if(map[position[0]][position[1]].equals("X")){
            System.out.println("I've found the treasure!");
            String path = String.join(", ",pathQueue);
            System.out.print("The right path is ");
            System.out.println(path);
        }else{
            System.out.println("The map is fake!");
        }
    }

    private static void startPosition(String[][] map, int[] position) {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col].equals("Y")){
                 position[0] = row;
                 position[1] = col;
                 return;
                }
            }
        }
    }

}
