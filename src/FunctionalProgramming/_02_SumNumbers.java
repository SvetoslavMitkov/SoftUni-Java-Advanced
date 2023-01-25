package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> adding = x -> Integer.parseInt(x);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(n -> adding.apply(n)).collect(Collectors.toList());

        int sum = numbers.stream().mapToInt(x -> x).sum();


        System.out.printf("Count = %d%n", numbers.size());
        System.out.printf("Sum = %d%n", sum);
    }
}
