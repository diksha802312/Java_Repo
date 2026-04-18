package Multithreading.ProducerConsumer;

import Multithreading.ProducerConsumer.SharedResource;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        SharedResource sharedResource = new SharedResource(queue, 1);

        Thread t1 = new Thread(()-> sharedResource.produce());
        Thread t2 = new Thread(()-> sharedResource.produce());

        Thread t3 = new Thread(()-> sharedResource.consume());
        Thread t4 = new Thread(()-> sharedResource.consume());

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
