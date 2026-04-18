package Multithreading.Locks.StampedLock.ReadWrite;

import Multithreading.Locks.StampedLock.ReadWrite.SharedResource;

public class Main {
    public static void main(String args[]){
        SharedResource sharedResource = new SharedResource();

        new Thread(()->{
            sharedResource.producer();
        }).start();

        new Thread(()->{
            sharedResource.consumer();
        }).start();
    }
}
