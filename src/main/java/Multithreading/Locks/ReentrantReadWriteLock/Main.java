package Multithreading.Locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String args[]) {
        SharedData sharedData = new SharedData();

        Thread t1 = new Thread(() -> {
            sharedData.readData();
        });

        Thread t2 = new Thread(() -> {
            sharedData.readData();
        });

        Thread t3 = new Thread(() -> {
            sharedData.writeData(10);
        });

        Thread t4 = new Thread(() -> {
            sharedData.writeData(20);
        });

        t3.start();
        t4.start();
        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
    }
}
