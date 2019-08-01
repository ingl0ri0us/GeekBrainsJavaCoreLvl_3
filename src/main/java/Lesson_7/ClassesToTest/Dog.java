package Lesson_7.ClassesToTest;

import Lesson_7.Tester.AfterSuite;
import Lesson_7.Tester.BeforeSuite;
import Lesson_7.Tester.Test;

public class Dog {
    private String name;
    private int age;
    private double weight;
    private String color;
    private boolean isStupid = false;
    private int numberOfPaws = 4;

    @BeforeSuite
    private void run() {
        System.out.println("Dog runs");
    }
    @Test(priority = 1)
    private void isStupid() {
        System.out.println(isStupid ? "Dog is stupid" : "Dog is smart");
    }
    @Test(priority = 2)
    private void howManyPaws() {
        System.out.println("Dog has " + numberOfPaws + " paws");
    }

    @Test(priority = 3)
    private void info() {
        System.out.println(name + " " + age + " " + weight + " " + color);
    }

    @AfterSuite
    private void eatFood(int food) {
        System.out.println("Dog eats " + food + " pieces of food");
    }

    public Dog(String name, int age, double weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
