package Multithreading.Locks.ReentrantReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedData {

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    int data = 5;

    public void readData(){
    try {
        readWriteLock.readLock().lock();
        System.out.println("Reading data= " + this.data + " " +  Thread.currentThread().getName());
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    finally {
        readWriteLock.readLock().unlock();
    }
    }

    public void writeData(int data){
        try{
            readWriteLock.writeLock().lock();
            System.out.println("Writing data " + Thread.currentThread().getName());
            this.data = data;
            Thread.sleep(2000);
            System.out.println("updated data= " + this.data + " " + Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
