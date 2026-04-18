package Multithreading.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class SharedResource {
    private BlockingQueue<Integer> queue;
    private int id;

    public SharedResource(BlockingQueue<Integer> queue, int id){
        this.queue = queue;
        this.id = id;
    }

    public void produce() {

        try{
            for(int i=1; i<=10 ; i++){
                queue.put(id*100 + i);
                System.out.println("prudced value " + id*100 + i + " by thread " + Thread.currentThread().getName());
                Thread.sleep(800);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void consume(){
        try{
            while(true){
                int id = (int)queue.take();
                System.out.println("consumed value " + id + " by thread " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
