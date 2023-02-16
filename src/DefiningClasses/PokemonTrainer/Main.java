package DefiningClasses.PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();


        String input = scanner.nextLine();
        while (!input.equals("Tournament")){
            String[] inputArr = input.split("\\s+");
            String trainerName = inputArr[0];
            String pokemonName = inputArr[1];
            String pokemonElement = inputArr[2];
            int pokemonHealth = Integer.parseInt(inputArr[3]);

            Pokemon currentPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer currentTrainer = new Trainer(trainerName, 0);
            if (!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, currentTrainer);
                currentTrainer.getPokemonList().add(currentPokemon);
            }else{
                trainers.get(trainerName).getPokemonList().add(currentPokemon);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("End")){
            String element = input;

            for (Trainer trainer : trainers.values()) {
                boolean hasElement = false;
                for (Pokemon pokemon :trainer.getPokemonList()) {
                    if (pokemon.getElement().equals(element)) {
                        trainer.setNumberOfBadges(trainer.getNumberOfBadges() + 1);
                        hasElement = true;
                    }
                }
                if (!hasElement){
                    for (int i = 0; i < trainer.getPokemonList().size(); i++) {
                        Pokemon currentPokemon = trainer.getPokemonList().get(i);
                        currentPokemon.setHealth(currentPokemon.getHealth() - 10);
                        if (currentPokemon.getHealth() <= 0){
                            trainer.getPokemonList().remove(currentPokemon);
                            i--;
                        }
                    }
                }
            }
            input = scanner.nextLine();
            }

        List<Trainer> collect = trainers.values().stream().sorted((l, r) -> r.getNumberOfBadges() - l.getNumberOfBadges())
                .collect(Collectors.toList());
        collect.forEach(e -> System.out.printf("%s %d %d %n", e.getName(),e.getNumberOfBadges(),
                e.getPokemonList().size()) );

    }
}
