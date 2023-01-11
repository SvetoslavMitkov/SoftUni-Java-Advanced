package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char[] charArr = input.toCharArray();
        ArrayDeque<Integer> indices = new ArrayDeque<>();

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '('){
               indices.push(i);
            }else if(charArr[i] == ')'){
                int startIndex = indices.pop();
                String substring = input.substring(startIndex, i + 1);
                System.out.println(substring);
            }
        }

    }
}
