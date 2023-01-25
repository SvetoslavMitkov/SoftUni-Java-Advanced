package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _E04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int X = scanner.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
           // String[] numbers = scanner.nextLine().split("\\s+");
            queue.offer(scanner.nextInt());
        }
        for (int i = 0; i < S; i++) {
            queue.poll();
        }
        if (!queue.isEmpty()) {
            if (queue.contains(X)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(queue));
            }
        }else{
            System.out.println("0");
        }
    }
}
