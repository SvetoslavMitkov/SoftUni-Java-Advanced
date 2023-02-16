package Generics.GenericBoxIntegers;

import Generics.GenereicBox.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Box box = new Box<>(Integer.parseInt(scanner.nextLine()));
            System.out.println(box.toString());
        }
    }


}
