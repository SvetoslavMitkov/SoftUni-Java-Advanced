package DefiningClasses.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;

    private int numberOfBadges;

    private List<Pokemon> pokemonList;

        //конструктор -> Alt + Insert - създава обект от класа с зададените фийлдове
    public Trainer(String name, int numberOfBadges) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemonList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

}
