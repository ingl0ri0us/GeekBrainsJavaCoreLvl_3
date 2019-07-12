package Lesson_1.Fruits;

import java.util.ArrayList;

public class Box <T extends Fruit> {

    private ArrayList<T> container = new ArrayList<T>();

    public double getBoxWeight() {
        double sum = 0.0;
        for (T fruitWeight: container) {
            sum += fruitWeight.getWeight();
        }
        return sum;
    }

    public void addFruitToBox(T fruit) {
        container.add(fruit);
    }
    public void emptyBox() {
        container.clear();
    }
    public ArrayList getAllFruits () {
        return container;
    }
    public void putManyFruits(ArrayList fruits) {
        container.addAll(fruits);
    }

    public boolean isWeightEqual(Box anotherBox) {
        return this.getBoxWeight() == anotherBox.getBoxWeight();
    }
    public Class<?> getType() {
        return container.get(0).getClass();
    }

}
