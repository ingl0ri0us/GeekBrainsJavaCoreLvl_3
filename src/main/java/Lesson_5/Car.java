package Lesson_5;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private CyclicBarrier barrier;
    private CountDownLatch latch;
    private Semaphore semaphore;
    private ArrayList<Car> finishList;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier barrier, CountDownLatch latch, Semaphore semaphore, ArrayList<Car> finishList) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.barrier = barrier;
        this.latch = latch;
        this.semaphore = semaphore;
        this.finishList = finishList;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this, semaphore);
        }
        latch.countDown();
        System.out.println(this.name + " финишировал!!");
        finishList.add(this);
    }
}
