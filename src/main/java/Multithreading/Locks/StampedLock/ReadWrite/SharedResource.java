package Multithreading.Locks.StampedLock.ReadWrite;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    StampedLock lock = new StampedLock();

    boolean isAvailable = false;

    public void producer(){
        long stamp = lock.readLock();
        try{
            System.out.println("Read lock aquired by " + Thread.currentThread().getName());
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            lock.unlockRead(stamp);
        }
    }

    public void consumer(){
        long stamp = lock.writeLock();
        try{
            System.out.println("Write lock acquired by " + Thread.currentThread().getName());
            isAvailable = false;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlockWrite(stamp);
        }
    }
}
