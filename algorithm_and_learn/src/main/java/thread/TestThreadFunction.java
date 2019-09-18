package thread;

public class TestThreadFunction {

    public static int count = 0;

    public static final Object object = new Object();

    public static void main(String[] arg) {

Thread t1 = new Thread(new Runnable() {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (object) {
                count++;
                System.out.println("t111111 " + count);
            }
            Thread.yield();
        }
    }
});

Thread t2 = new Thread(new Runnable() {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (object) {
                count++;
                System.out.println("t2 " + count);
            }
            Thread.yield();
        }
    }
});

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count: " + count);

    }

//    public static int count = 0;
//    public static final Object object = new Object();
//Thread t1 = new Thread(new Runnable() {
//    @Override
//    public void run() {
//        for (int i = 0; i < 1000; i++) {
//            synchronized (object) {
//                count++;
//                System.out.println("t111111 " + count);
//            }
//        }
//    }
//});
//Thread t2 = new Thread(new Runnable() {
//    @Override
//    public void run() {
//        for (int i = 0; i < 1000; i++) {
//            synchronized (object) {
//                count++;
//                System.out.println("t2 " + count);
//            }
//        }
//    }
//});
}
