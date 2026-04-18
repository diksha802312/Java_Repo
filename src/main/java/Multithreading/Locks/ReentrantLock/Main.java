package Multithreading.Locks.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String args[]){
        ReentrantLock lock = new ReentrantLock();

        SharedResource sharedResources1 = new SharedResource();
        SharedResource sharedResources2 = new SharedResource();

        Thread t1 = new Thread(() -> {
            sharedResources1.producer(lock);
        });

        Thread t2 = new Thread(() -> {
            sharedResources1.producer(lock);
        });

        t1.start();
        t2.start();
    }
}
