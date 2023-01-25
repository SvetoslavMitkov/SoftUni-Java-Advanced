package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _03_CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> isUpperCase = string -> Character.isUpperCase(string.charAt(0)) ;

        List<String> stringList = Arrays.stream(scanner.nextLine().split(" "))
                .filter(s -> isUpperCase.test(s))
                .collect(Collectors.toList());

        System.out.println(stringList.size());
        stringList.forEach(s -> System.out.println(s));
    }
}
