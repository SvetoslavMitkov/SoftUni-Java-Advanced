package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        if (n == 0){
            System.out.println("0");
            return;
        }

        ArrayDeque<String> binaryCode = new ArrayDeque<>();

        while (n > 0){
            int binary = n % 2;
            binaryCode.push(String.valueOf(binary));
            n = n / 2;
        }
        System.out.println(String.join("",binaryCode));

    }
}
