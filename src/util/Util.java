package util;

public class Util {

    public static void swap(int[] data, int a, int b) {
        if (a != b) {
            int x = data[a];
            data[a] = data[b];
            data[b] = x;
        }
    }

    public static int[] prepareTestData(int count) {
        int[] data = new int[count];
        for (int i = 0; i < count; i++) {
            data[i] = (int) (Math.random() * 100);
        }
        return data;
    }
}
