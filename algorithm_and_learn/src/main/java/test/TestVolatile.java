package test;

public class TestVolatile {

    public static int a3 = 0;

    public static int count = 1000000000;

    public static int examCount = 10;

    public static void main(String[] arg) {
        test1();
        //test2();
    }

    /**
     * 测试volatile关键字对读写性能的影响
     * */
    public static void test1() {
        TestVolatile test = new TestVolatile();

        long a1Count = 0;
        long a2Count = 0;
        long a3Count = 0;

        for (int j = 0; j < examCount; j++) {
            long t = System.currentTimeMillis();
            long cost = 0;

            for (int i = 0; i < count; i++) {
                int v = test.a1;
                v++;
            }

            cost = (System.currentTimeMillis() - t);
            a1Count += cost;
            System.out.println("a1 " + cost);


            t = System.currentTimeMillis();

            for (int i = 0; i < count; i++) {
                int v = test.a2++;
                v++;
            }

            cost = (System.currentTimeMillis() - t);
            a2Count += cost;
            System.out.println("a2 " + cost);


            t = System.currentTimeMillis();

            for (int i = 0; i < count; i++) {
                a3++;
            }

            cost = (System.currentTimeMillis() - t);
            a3Count += cost;
            System.out.println("a3 " + cost);
        }

        System.out.println("avg--------------");

        System.out.println("" + 1f * a1Count / examCount);
        System.out.println("" + 1f * a2Count / examCount);
        System.out.println("" + 1f * a3Count / examCount);
    }

    public int a1 = 0;
    public volatile int a2 = 0;

    /**
     * 测试volatile是否具备原子性
     * */
    public static void test2() {

        TestVolatile tv = new TestVolatile();

        int count = 8000;

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    tv.a1++;
                }
                for (int i = 0; i < count; i++) {
                    tv.a2++;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    tv.a1++;
                }
                for (int i = 0; i < count; i++) {
                    tv.a2++;
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Throwable e) {

        }

        System.out.println(tv.a1);
        System.out.println(tv.a2);
    }
}
