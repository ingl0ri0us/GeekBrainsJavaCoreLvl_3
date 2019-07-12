package Lesson_1.Fruits;

public class Main {
    public static void main(String[] args) {
        Box<Orange> orangeBox1 = new Box<Orange>();
        Box<Orange> orangeBox2 = new Box<Orange>();
        Box<Apple> appleBox1 = new Box<Apple>();
        Box<Apple> appleBox2 = new Box<Apple>();

        fillWithOranges(orangeBox1, 5);
        fillWithOranges(orangeBox2, 5);
        fillWithApples(appleBox1, 5);
        fillWithApples(appleBox2, 6);

        System.out.println(orangeBox1.getBoxWeight());
        System.out.println(orangeBox2.getBoxWeight());
        System.out.println(appleBox1.getBoxWeight());
        System.out.println(appleBox2.getBoxWeight());

        System.out.println(orangeBox1.isWeightEqual(orangeBox2));
        System.out.println(orangeBox1.isWeightEqual(appleBox2));

        putFromOneToAnother(orangeBox1, orangeBox2);
        putFromOneToAnother(orangeBox2, appleBox1);
    }

    private static void fillWithOranges(Box box, int numberOfFruits) {
        for (int i = 0; i < numberOfFruits; i++) {
            box.addFruitToBox(new Orange((i+1)*2));
        }
    }
    private static void fillWithApples(Box box, int numberOfFruits) {
        for (int i = 0; i < numberOfFruits; i++) {
            box.addFruitToBox(new Apple((i+2)*2));
        }
    }
    private static void putFromOneToAnother(Box fromBox, Box toBox) {
        boolean sameFruits = fromBox.getType().equals(toBox.getType());
        if (sameFruits) {
            toBox.putManyFruits(fromBox.getAllFruits());
            fromBox.emptyBox();
            System.out.println("Фрукты пересыпаны.");
        } else {
            System.out.println("Невозможно пересыпать, фрукты в коробках должы быть одинковыми.");
        }
    }
}
