package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _E05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> charStack = new ArrayDeque<>();
        ArrayDeque<Character> charQueue = new ArrayDeque<>();

        String input = scanner.nextLine();
        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{') {
                charStack.push(charArray[i]);
            }else{
                charQueue.offer(charArray[i]);
            }
        }
        if (charStack.size() != charQueue.size()){
            System.out.println("NO");
            return;
        }
        if(charStack.isEmpty()){
            System.out.println("NO");
            return;
        }
        boolean isTrue = false;
        while (!charStack.isEmpty()) {
            char lastOpenBracket = charStack.pop();
            char firstClosedBracket = charQueue.poll();

            switch (lastOpenBracket) {
                case '(':
                if (firstClosedBracket == ')') {
                    isTrue = true;
                }else{
                    System.out.println("NO");
                    return;
                }
                    break;
                case '[':
                    if (firstClosedBracket == ']') {
                        isTrue = true;
                    }else{
                        System.out.println("NO");
                        return;
                    }
                    break;
                case '{':
                    if (firstClosedBracket == '}') {
                        isTrue = true;
                    }else{
                        System.out.println("NO");
                        return;
                    }
                    break;
            }
        }

        if (isTrue)
            System.out.println("YES");

    }
}
