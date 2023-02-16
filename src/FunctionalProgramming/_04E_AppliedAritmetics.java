package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class _04E_AppliedAritmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        Function<List<Integer>,List<Integer>> addFunction = list-> list.stream().map(e -> e + 1).collect(Collectors.toList());
        Function<List<Integer>,List<Integer>> multiplyFunction = list-> list.stream().map(e -> e * 2).collect(Collectors.toList());
        Function<List<Integer>,List<Integer>> subtractFunction = list-> list.stream().map(e -> e - 1).collect(Collectors.toList());

        Consumer<Integer> printFunction = e -> System.out.printf("%d ", e);


        String command = scanner.nextLine();
        while (!command.equals("end")){
            switch (command){
                case "add": numbers = addFunction.apply(numbers);
                break;
                case "multiply": numbers = multiplyFunction.apply(numbers);
                break;
                case "subtract": numbers = subtractFunction.apply(numbers);;
                break;
                case "print": numbers.forEach(printFunction);
            }
            command = scanner.nextLine();
        }
    }
}
