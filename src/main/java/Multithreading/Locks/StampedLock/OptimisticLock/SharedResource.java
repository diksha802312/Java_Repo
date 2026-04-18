package Multithreading.Locks.StampedLock.OptimisticLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    StampedLock lock = new StampedLock();

    int a = 5;
    public void producer(){
        long stamp = lock.tryOptimisticRead();

        try{
            System.out.println("Taken optimistic read " + Thread.currentThread().getName());
            a = 6;
            Thread.sleep(2000);
            if(lock.validate(stamp)){
               // a= 6;
                System.out.println("Updated the value successfully a= " + a + " " + Thread.currentThread().getName());
                //Thread.sleep(4000);
            }
            else {
                System.out.println("Rolling back " + Thread.currentThread().getName());
                a = 5;

            }
        }catch ( Exception e){
            e.printStackTrace();
        }
    }

    public void consumer() {
        long stamp = lock.writeLock();
        try{
            a = 10;
            System.out.println("write the value of a= " + a  + " " + Thread.currentThread().getName());
        }catch ( Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlockWrite(stamp);
        }
    }


    //bank example
    private int balance = 0;

    // Writer: update balance
    public void deposit(int amount) {
        long stamp = lock.writeLock(); // acquire write lock
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", balance = " + balance);
        } finally {
            lock.unlockWrite(stamp); // release write lock
        }
    }

    // Reader: read balance
    public void checkBalance() {
        long stamp = lock.readLock(); // acquire read lock
        try {
            System.out.println(Thread.currentThread().getName() + " checked balance: " + balance);
        } finally {
            lock.unlockRead(stamp); // release read lock
        }
    }

    // Optimistic read: lightweight read
    public void checkBalanceOptimistic() {
        long stamp = lock.tryOptimisticRead(); // optimistic read
        int tempBalance = balance; // read without blocking

        // Validate if no write happened during the read
        if (!lock.validate(stamp)) {
            // fallback to normal read
            stamp = lock.readLock();
            try {
                tempBalance = balance;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName() + " optimistically checked balance: " + tempBalance);
    }
}
