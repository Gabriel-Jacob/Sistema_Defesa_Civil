package Threads;
public class Main {
    public static void main(String[] args) {
        // Thread t1 = new Thread1();
        Thread t2 = new Thread2();
        Thread t3 = new Thread3();

        // t1.start();
        t2.start();
        t3.start();
    }
}
