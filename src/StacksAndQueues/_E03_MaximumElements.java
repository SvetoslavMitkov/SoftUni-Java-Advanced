package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _E03_MaximumElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            switch (input[0]){
                case "1":
                    numbersStack.push(Integer.parseInt(input[1]));
                    break;
                case "2":
                    numbersStack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(numbersStack));
                    break;
            }
        }
    }


}
