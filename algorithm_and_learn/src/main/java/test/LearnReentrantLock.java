package test;

public class LearnReentrantLock {

    public static void main(String[] args) {
        foo();
    }

    public static final Object o = new Object();

    public static int a = 0;

    public static void foo() {
        System.out.println("foo a " + a);
        synchronized (o) {
            a++;
            System.out.println("foo a++ finished " + a);

            if (a == 100) {
                return;
            }
            foo();
        }
    }

}
