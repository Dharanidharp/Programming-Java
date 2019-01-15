package com.company;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        // Create a new count class to instantiate semaphore values
        Count count = new Count(new BinarySemaphore(1), new BinarySemaphore(0), new Semaphore(0));

        // Create new threads of X Y Z
        Thread xThread = new XClass(count, 'X');
        Thread yThread = new YClass(count, 'Y');
        Thread zThread = new ZClass(count, 'Z');

        // Start the threads
        xThread.start();
        yThread.start();
        zThread.start();

        Thread.sleep(5000);
        System.exit(0);
    }
}