package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() - 1 <= this.capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present present : data) {
            if (present.getName().equals(name)) {
                data.remove(present);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent(){
        this.data.sort((l, r) -> (int) (r.getWeight() - l.getWeight()));
        return this.data.get(0);
    }

    public Present getPresent(String name){
        for (Present present : data) {
            if (present.getName().equals(name)) {
                return present;
            }
        }
        return null;
    }

    public String report(){
        StringBuilder reportSB = new StringBuilder();
        reportSB.append(String.format("%s bag contains:%n", this.color));
        this.data.forEach(e ->
                reportSB.append(String.format("Present %s (%.2f) for a %s%n"
                        ,e.getName(), e.getWeight(),e.getGender())));
        return  reportSB.toString();
    }
}
