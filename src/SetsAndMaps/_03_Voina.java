package SetsAndMaps;

import java.util.*;

public class _03_Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstDeck = new LinkedHashSet<>();
        Set<Integer> secondDeck = new LinkedHashSet<>();

        int[] input1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] input2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int num : input1) {
            firstDeck.add(num);
        }
        for (int num : input2) {
            secondDeck.add(num);
        }
        for (int i = 0; i < 50; i++) {
        if ((firstDeck.isEmpty()) || secondDeck.isEmpty()) {
            break;
        }
            int firstCard = firstDeck.iterator().next();
            firstDeck.remove(firstCard);
            int secondCard = secondDeck.iterator().next();
            secondDeck.remove(secondCard);
            if (firstCard > secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
             }else{
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
        }
            if (firstDeck.size() > secondDeck.size()){
                System.out.println("First player win!");
            }else if (secondDeck.size() > firstDeck.size()){
                System.out.println("Second player win!");
            }else{
                System.out.println("Draw!");
            }

    }

}
