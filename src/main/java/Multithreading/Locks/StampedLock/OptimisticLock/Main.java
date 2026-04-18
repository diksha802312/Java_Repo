package Multithreading.Locks.StampedLock.OptimisticLock;

import Multithreading.Locks.StampedLock.OptimisticLock.SharedResource;

public class Main {
    public static void main(String args[]) {
        SharedResource sharedResource = new SharedResource();

       Thread t1 = new Thread(() -> {
            sharedResource.producer();
        });

      Thread t2 =  new Thread(() -> {
            sharedResource.producer();
        });

//      Thread t3 = new Thread(() -> {
//            sharedResource.consumer();
//        });

//      t1.setName("thread-A");
//      t2.setName("thread-B");
    //  t3.setName("thread-C");
//      t1.start();
//      t2.start();
      //t3.start();

        SharedResource account = new SharedResource();
        new Thread(() -> account.deposit(100), "Writer-1").start();
        new Thread(account::checkBalance, "Reader-1").start();
        new Thread(account::checkBalanceOptimistic, "Reader-2").start();
    }
}
