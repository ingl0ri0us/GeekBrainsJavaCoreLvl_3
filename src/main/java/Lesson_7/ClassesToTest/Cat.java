package Lesson_7.ClassesToTest;

import Lesson_7.Tester.AfterSuite;
import Lesson_7.Tester.BeforeSuite;
import Lesson_7.Tester.Test;

public class Cat {
    private String name;
    private int age;
    private double weight;
    private String color;
    private boolean isStupid = true;
    private int numberOfPaws = 4;

    @BeforeSuite
    private void run() {
        System.out.println("Cat runs");
    }
    @Test(priority = 3)
    private void isStupid() {
        System.out.println(isStupid ? "Cat is stupid" : "Cat is smart");
    }
    @Test(priority = 2)
    private void howManyPaws() {
        System.out.println("Cat has " + numberOfPaws + " paws");
    }
    @Test(priority = 1)
    private void info() {
        System.out.println(name + " " + age + " " + weight + " " + color);
    }
    @AfterSuite
    private void eatFood(int food) {
        System.out.println("Cat eats " + food + " pieces of food");
    }

    public Cat(String name, int age, double weight, String color) {
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
