package sort;

import org.junit.Test;
import util.Util;

import java.util.Arrays;
import java.util.Random;

public class QuickSortWriteFromMemTest implements ISort {

    @Override
    public int[] sort(int[] data) {
        sortIntern(data, 0, data.length - 1);
        return data;
    }

    private void sortIntern(int[] data, int l, int r) {
        if (l < r) {
            int m = partition(data, l, r);
            sortIntern(data, l, m - 1);
            sortIntern(data, m + 1, r);
        }
    }

    private int partition(int[] data, int l, int r) {
        int p = data[r];

        int x = l - 1;

        for (int i = l; i < r; i++) {
            if (data[i] < p) {
                Util.swap(data, i, ++x);
            }
        }

        Util.swap(data, r, ++x);

        return x;
    }


    @Test
    public void test() {
        int[] data = Util.prepareTestData(20);

        System.out.println(Arrays.toString(data));
        data = new QuickSortWriteFromMemTest().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
