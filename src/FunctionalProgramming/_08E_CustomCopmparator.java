package FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _08E_CustomCopmparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        Comparator<Integer> sort = ((a, b) -> {
            if (a % 2 == 0 && b % 2 != 0) {
                return -1;
            }
            else if (a % 2 != 0 && b % 2 == 0){
                return 1;
            }else{
                return a.compareTo(b);
            }
        });
        numbers.sort(sort);
        numbers.forEach(e -> System.out.printf("%d ",e));
    }
}
