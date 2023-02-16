package Generics.GenericSwapMethodStrings;

import Generics.GenereicBox.Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Box> boxList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Box box = new Box<>(scanner.nextLine());
            boxList.add(box);
        }
        String indexes = scanner.nextLine();
        int firstIndex = Integer.parseInt(indexes.split("\\s+")[0]);
        int secondIndex = Integer.parseInt(indexes.split("\\s+")[1]);

        List<Box> swappedList = swapIndexes(boxList,firstIndex,secondIndex);
        swappedList.forEach(e -> System.out.println(e));
    }

    private static List<Box> swapIndexes(List<Box> boxList, int firstIndex, int secondIndex) {
        Box firstBox = boxList.get(firstIndex);
        boxList.set(firstIndex,boxList.get(secondIndex));
        boxList.set(secondIndex,firstBox);
        return boxList;
    }
}
