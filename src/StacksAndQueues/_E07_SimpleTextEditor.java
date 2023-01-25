package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _E07_SimpleTextEditor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder textSB = new StringBuilder();
        ArrayDeque<String> textStates = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String command = input.split("\\s+")[0];

            switch (command){
                case "1":
                    textStates.push(textSB.toString());
                    String stringToAppend = input.split("\\s+")[1];
                    textSB.append(stringToAppend);
                    break;
                case "2":
                    textStates.push(textSB.toString());
                    int count = Integer.parseInt(input.split("\\s+")[1]);
                    textSB.delete(textSB.length() - count, textSB.length());
                    break;
                case "3":
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    System.out.println(textSB.charAt(index - 1));
                    break;
                case "4":
                    if (!textStates.isEmpty()) {
                        String last = textStates.pop();
                        textSB = new StringBuilder(last);
                    }
                    break;
            }
        }
    }
}
