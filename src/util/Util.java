package util;

public class Util {

    public static void swap(int[] data, int a, int b) {
        if (a != b) {
            int x = data[a];
            data[a] = data[b];
            data[b] = x;
        }
    }
}
