package sort;

import org.junit.Test;
import util.Util;

import java.util.Arrays;

public class BubbleSort implements ISort {

    @Override
    public int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    Util.swap(data, j, j + 1);
                }
            }
        }
        return data;
    }

    @Test
    public void test() {
        int[] data = Util.prepareTestData(20);
        System.out.println(Arrays.toString(data));
        data = new BubbleSort().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
