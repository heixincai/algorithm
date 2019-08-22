package test;

public class TestVolatile {

    public int a1 = 0;
    public volatile int a2 = 0;
    public static int a3 = 0;

    public static int count = 1000000;

    public static int examCount = 10;

    public static void main(String[] arg) {
        TestVolatile test = new TestVolatile();

        long a1Count = 0;
        long a2Count = 0;
        long a3Count = 0;

        for (int j = 0; j < examCount; j++) {
            long t = System.currentTimeMillis();
            long cost = 0;

            for (int i = 0; i < count; i++) {
                test.a1++;
            }

            cost = (System.currentTimeMillis() - t);
            a1Count += cost;
            System.out.println("a1 " + cost);


            t = System.currentTimeMillis();

            for (int i = 0; i < count; i++) {
                test.a2++;
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
}
