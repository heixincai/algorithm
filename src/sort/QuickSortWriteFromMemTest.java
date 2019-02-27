package sort;

import org.junit.Test;
import util.Util;

import java.util.Arrays;
import java.util.Random;

/**
 * 默写记录
 * 2019-01-14 18:50:05 默写一次
 *
 * */
public class QuickSortWriteFromMemTest implements ISort {

    @Override
    public int[] sort(int[] data) {
        sortIntern(data, 0, data.length - 1);
        return data;
    }

    private void sortIntern(int[] data, int lo, int hi) {
        if (lo < hi) {
            int m = parition(data, lo, hi);
            sortIntern(data, lo, m - 1);
            sortIntern(data, m + 1, hi);
        }
    }

    private int parition(int[] data, int lo, int hi) {
        int p = data[hi];
        int x = lo - 1;

        for (int i = lo; i < hi; i++) {
            if (data[i] < p) {
                Util.swap(data, ++x, i);
            }
        }

        Util.swap(data, ++x, hi);

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
