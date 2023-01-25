package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double,Integer> numbers = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split("\\s+");
        for (String num : input) {
            if (numbers.containsKey(Double.parseDouble(num))) {
                numbers.put(Double.parseDouble(num), numbers.get(Double.parseDouble(num)) + 1);
            }else{
                numbers.put(Double.parseDouble(num), 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : numbers.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
