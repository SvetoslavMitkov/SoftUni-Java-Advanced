package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class _01_SortEvenNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
               .map(Integer::parseInt).collect(Collectors.toList());

       List<Integer> filteredNumbers = numbers.stream()
               .filter(e -> e % 2 == 0).collect(Collectors.toList());

       List<Integer> sortedNumbers = filteredNumbers
               .stream().sorted().collect(Collectors.toList());

        System.out.println(filteredNumbers.toString().replaceAll("[^a-zA-Z0-9_,\\s]",""));
        System.out.println(sortedNumbers.toString().replaceAll("[^a-zA-Z0-9_,\\s]",""));

    }
}
