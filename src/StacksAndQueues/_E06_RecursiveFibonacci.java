package StacksAndQueues;

import java.util.Scanner;

public class _E06_RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        long result = getFibonacci(n);
        System.out.println(result);

    }

    private static long getFibonacci(int n) {
        if (n <= 1){
         return 1;
        }
        return getFibonacci(n-1) + getFibonacci(n-2);
    }
}
