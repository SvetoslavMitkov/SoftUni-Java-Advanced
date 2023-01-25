package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class _04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> addVAT = x -> x * 1.2;

        List<Double> values = Arrays.stream(scanner.nextLine().split(", "))
                .map(d -> Double.parseDouble(d))
                .collect(Collectors.toList());

        System.out.println("Prices with VAT:");
        values.stream().map(x -> addVAT.apply(x)).forEach(x -> System.out.printf("%.2f%n", x));
    }
}
