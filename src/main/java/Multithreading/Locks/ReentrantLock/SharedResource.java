package Multithreading.Locks.ReentrantLock;


import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class SharedResource {

    boolean isAvailable = false;

    public void producer(ReentrantLock lock){

        try {
            lock.lock();
            Thread.sleep(2);
            System.out.println("Lock is acquired by " + Thread.currentThread().getName());
            isAvailable = true;
           // sleep(4000);
        }catch (Exception ie)
        {
            System.out.println("Thread is interrupted");
        }
        finally {
            lock.unlock();
            System.out.println("lock is released by " + Thread.currentThread().getName());
        }
    }
}