package ru.netology;

import java.lang.*;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private String name;

    final static int minQuantityOfMessage = 1;
    final static int maxQuantityOfMessage = 4;

    public MyCallable(String name) {
        this.name = name;
    }

    private int getRandomValue(int minQuantityOfMessage, int maxQuantityOfMessage) {
        maxQuantityOfMessage -= minQuantityOfMessage;
        return (int) (Math.random() * ++maxQuantityOfMessage) + minQuantityOfMessage;
    }

    public Integer call() throws Exception {
        int randomQuantityOfMessages = getRandomValue(minQuantityOfMessage, maxQuantityOfMessage);
        Integer tasksCount = 1;
        for (int i = 0; i < randomQuantityOfMessages; i++) {
            System.out.println("Hi there! My name is " + name + ". It's my message #" + i);
            Thread.sleep(500);
            tasksCount++;
        }
        return tasksCount;

    }
}
