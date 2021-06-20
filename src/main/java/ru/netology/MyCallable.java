package ru.netology;
import java.lang.*;
import java.util.concurrent.Callable;


public class MyCallable implements Callable<Integer> {
    private String name;

    public MyCallable (String name) {
        this.name = name;
    }

    public Integer call() throws Exception {
        Thread.sleep(2000);
        System.out.println("Hi there! My name is " + name);
        Integer tasksCount = 1;
        return tasksCount;
    }

}
