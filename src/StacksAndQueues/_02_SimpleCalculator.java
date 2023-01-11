package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArr = input.split("\\s+");
        ArrayDeque<String> data = new ArrayDeque<>();
        for (String item: inputArr) {
            data.addLast(item);
        }
        int firstNum = Integer.parseInt(data.pop());
        int sum = firstNum;
        while (data.size() > 1) {
            String operator = data.pop();
            int currentNum = Integer.parseInt(data.pop());
            if (operator.equals("+")){
                sum = sum + currentNum;
            }else if (operator.equals("-")){
                sum = sum - currentNum;
            }
        }
        System.out.println(sum);
    }
}
