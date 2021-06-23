package ru.netology;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable<Integer> myCallable1 = new MyCallable("Task 1");
        Callable<Integer> myCallable2 = new MyCallable("Task 2");
        Callable<Integer> myCallable3 = new MyCallable("Task 3");
        Callable<Integer> myCallable4 = new MyCallable("Task 4");

        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Collection<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(myCallable1);
        tasks.add(myCallable2);
        tasks.add(myCallable3);
        tasks.add(myCallable4);

        List <Future<Integer>> futures = threadPool.invokeAll(tasks);

        Integer countMessganges = 0;
        for ( Future future : futures) {
            countMessganges = countMessganges + (Integer)future.get();
        }
        System.out.println( "Quantity of recieved messages is = " + countMessganges);

        Integer futuresForInvokeAny = threadPool.invokeAny(tasks);
        System.out.println("For \"InvokeAny\" we've got only " + futuresForInvokeAny);

        threadPool.shutdown();
    }
}
