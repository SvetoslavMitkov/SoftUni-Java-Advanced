package ExamPreparations;

import java.util.*;
import java.util.stream.Collectors;

public class _01_PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        List<Integer> ingredients = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        Deque<Integer> liquidsQueue = new ArrayDeque<>();
        Deque<Integer> ingredientsStack = new ArrayDeque<>();
        liquids.forEach(e -> liquidsQueue.offer(e));
        ingredients.forEach(e -> ingredientsStack.push(e));

        int biscuitCooked = 0;
        int cakeCooked = 0;
        int pastryCooked = 0;
        int pieCooked = 0;

        while(liquidsQueue.size() > 0 && ingredientsStack.size() > 0){
            int currentLiquid = liquidsQueue.peek();
            int currentIngredient = ingredientsStack.peek();
            int sum = currentIngredient + currentLiquid;
            boolean cookCheck = sum == 25 || sum == 50 || sum ==75 || sum == 100;

            if (cookCheck) {
                switch (sum) {
                    case 25:
                        liquidsQueue.poll();
                        ingredientsStack.pop();
                        biscuitCooked += 1;
                        break;
                    case 50:
                        liquidsQueue.poll();
                        ingredientsStack.pop();
                        cakeCooked += 1;
                        break;
                    case 75:
                        liquidsQueue.poll();
                        ingredientsStack.pop();
                        pastryCooked += 1;
                        break;
                    case 100:
                        liquidsQueue.poll();
                        ingredientsStack.pop();
                        pieCooked += 1;
                        break;
                }
            }else {
                liquidsQueue.poll();
                ingredientsStack.pop();
                ingredientsStack.push(currentIngredient + 3);
            }
        }

        if (biscuitCooked > 0 && cakeCooked > 0 && pastryCooked > 0 && pieCooked > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (liquidsQueue.isEmpty()){
                System.out.println("Liquids left: none");
        }else{
                printLiquidsLeft(liquidsQueue);
        }
        if (ingredientsStack.isEmpty()){
                System.out.println("Ingredients left: none");
        }else{
               printIngredientsLeft(ingredientsStack);
        }
        System.out.printf("Biscuit: %d%n", biscuitCooked);
        System.out.printf("Cake: %d%n", cakeCooked);
        System.out.printf("Pie: %d%n", pieCooked);
        System.out.printf("Pastry: %d%n", pastryCooked);

        }

    private static void printLiquidsLeft (Deque<Integer> liquidsQueue){
        StringBuilder liquidsSB = new StringBuilder();
        List<Integer> liquidsLeft = liquidsQueue.stream().collect(Collectors.toList());
        liquidsSB.append("Liquids left: ");
        liquidsLeft.forEach(e -> liquidsSB.append(e + ","));
        liquidsSB.delete(liquidsSB.length() - 2, liquidsSB.length() - 1);
        System.out.println(liquidsSB);
    }
    private static void printIngredientsLeft (Deque<Integer> ingredientsStack){
        StringBuilder ingredientsSB = new StringBuilder();
        List<Integer> ingredientsLeft = ingredientsStack.stream().collect(Collectors.toList());
        ingredientsSB.append("Ingredients left: ");
        ingredientsLeft.forEach(e -> ingredientsSB.append(e + ", "));
        ingredientsSB.delete(ingredientsSB.length() - 2, ingredientsSB.length() - 1);
        System.out.println(ingredientsSB);
    }
}
