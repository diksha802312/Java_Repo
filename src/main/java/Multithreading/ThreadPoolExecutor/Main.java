package Multithreading.ThreadPoolExecutor;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("Task " + r.toString() + " discarded");
            }
        });

        threadPoolExecutor.allowCoreThreadTimeOut(true);

        //submit 6 tasks
        for (int i = 1; i < 9; i++) {
            int taskId = i;
                threadPoolExecutor.execute(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.setStackTrace(e.getStackTrace());
                    }
                    System.out.println("Proceesed task " + +taskId + " by thread " + Thread.currentThread().getName());
                });
        }
        threadPoolExecutor.shutdown();
    }
}
