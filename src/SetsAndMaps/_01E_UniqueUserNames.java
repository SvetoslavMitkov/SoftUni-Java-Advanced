package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01E_UniqueUserNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            usernames.add(input);

        }
        usernames.forEach(e -> System.out.println(e));
    }
}
