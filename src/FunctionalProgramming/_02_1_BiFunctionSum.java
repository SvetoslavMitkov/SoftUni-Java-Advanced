package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class _02_1_BiFunctionSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BiFunction<Integer, String, Integer> parseAndAdd = (acc, currentString) -> acc + Integer.parseInt(currentString);

        List<String> numsAsString = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        int sum = 0;

        for (String s : numsAsString) {
            sum = parseAndAdd.apply(sum, s);
        }

        System.out.println("Count: " + numsAsString.size());
        System.out.println("Sum: " + sum);

    }
}
