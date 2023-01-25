package SetsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _05E_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")){
            String name = input.split("-")[0];
            String number = input.split("-")[1];

            phonebook.put(name, number);

            input = scanner.nextLine();
        }
        String nameToSearch = scanner.nextLine();
        while (!nameToSearch.equals("stop")){
            if (phonebook.containsKey(nameToSearch)){
                System.out.printf("%s -> %s%n", nameToSearch, phonebook.get(nameToSearch));
            }else{
                System.out.printf("Contact %s does not exist.%n", nameToSearch);
            }
            nameToSearch = scanner.nextLine();
        }
    }
}
