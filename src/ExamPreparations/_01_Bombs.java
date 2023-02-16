package ExamPreparations;

import java.util.*;
import java.util.stream.Collectors;

public class _01_Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> effectsList =  Arrays.stream(scanner.nextLine().split(", "))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        List<Integer> casingList = Arrays.stream(scanner.nextLine().split(", "))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        Deque<Integer> effectsQueue = new ArrayDeque<>();
        Deque<Integer> casingStack = new ArrayDeque<>();

        effectsList.forEach(e -> effectsQueue.offer(e));
        casingList.forEach(e -> casingStack.push(e));

        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeDecoyBombs = 0;
        boolean bombPouchFilled = false;

        while(!effectsQueue.isEmpty() && !casingStack.isEmpty() && !bombPouchFilled){
            int currentEffect = effectsQueue.peek();
            int currentCasing = casingStack.peek();

            int sum = currentEffect + currentCasing;
            if (sum == 40 || sum == 60 || sum == 120){
             switch(sum){
                 case 40:
                     daturaBombs += 1;
                     effectsQueue.poll();
                     casingStack.pop();
                     if(daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >=3){
                         bombPouchFilled = true;
                     }
                     break;
                 case 60:
                     cherryBombs += 1;
                     effectsQueue.poll();
                     casingStack.pop();
                     if(daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >=3){
                         bombPouchFilled = true;
                     }
                     break;
                 case 120:
                    smokeDecoyBombs += 1;
                     effectsQueue.poll();
                     casingStack.pop();
                     if(daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >=3){
                         bombPouchFilled = true;
                     }
                     break;
             }
            }else{
                casingStack.pop();
                casingStack.push(currentCasing - 5);
            }
        }
        if (bombPouchFilled){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else{
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (effectsQueue.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else{
            List<Integer> effectsLeft = effectsQueue.stream().collect(Collectors.toList());
            System.out.print("Bomb Effects: ");
            StringBuilder effectsSB = new StringBuilder();
            effectsLeft.forEach(e -> effectsSB.append(e + ", "));
            effectsSB.delete(effectsSB.length() - 2, effectsSB.length() - 1);
            System.out.println(effectsSB);
        }
        if (casingStack.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else{
            List<Integer> casingLeft = casingStack.stream().collect(Collectors.toList());
            System.out.print("Bomb Casings: ");
            StringBuilder casingSB = new StringBuilder();
            casingLeft.forEach(e -> casingSB.append(e + ", "));
            casingSB.delete(casingSB.length() - 2, casingSB.length() - 1);
            System.out.println(casingSB);
        }
        System.out.printf("Cherry Bombs: %d%n", cherryBombs);
        System.out.printf("Datura Bombs: %d%n", daturaBombs);
        System.out.printf("Smoke Decoy Bombs: %d%n", smokeDecoyBombs);
    }
}
