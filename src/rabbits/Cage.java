package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit){
        if (this.data.size() < this.capacity){
            this.data.add(rabbit);
        }
    }

    public void removeRabbit(String name){
        if(this.data.contains(name)){
         this.data.remove(name);
        }
    }

    public Rabbit sellRabbit(String name){
        int index = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                index = i;
                this.data.get(i).setAvailable(false);
            }
        }
        return this.data.get(index);
    }

    public List<Rabbit> sellRabbitBySpecies(String species){
            List<Rabbit> rabbitsOfSpecies = new ArrayList<>();
        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species)){
                rabbit.setAvailable(false);
               rabbitsOfSpecies.add(rabbit);
            }
        }
        return rabbitsOfSpecies;
    }

    public int count (){
        return this.data.size();
    }

    public String report(){
        List<Rabbit> availableRabbits = new ArrayList<>();
        for (Rabbit rabbit : data) {
            if(rabbit.isAvailable()){
             availableRabbits.add(rabbit);
            }
        }
        StringBuilder reportSB = new StringBuilder();
        reportSB.append(String.format("Rabbits available at %s:%n", this.name));
        availableRabbits.forEach(e -> reportSB.append(e.toString() + String.format("%n")));
        return reportSB.toString();
    }
}
