package Multithreading.EvenOdd;

public class EvenOddPrinter {
    public static void main(String[] args) {
        SharedPrinter sharedPrinter = new SharedPrinter();
        Thread thread1 = new Thread(() ->{
            for(int i = 1 ; i<=10; i+=2)
                sharedPrinter.printOdd(i);
        }, "Odd");

        Thread thread2 = new Thread(() ->{
            for(int i=2; i<=10; i+=2)
                sharedPrinter.printEven(i);
        }, "Even");

        thread1.start();
        thread2.start();
    }
}
