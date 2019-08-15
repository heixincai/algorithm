package sort;

import org.junit.Test;
import util.Util;

import java.util.Arrays;
import java.util.Random;

/**
 * 默写记录
 * 2019-01-14 18:50:05 默写一次
 * 2019-08-15 21:29:24
 *
 * */
public class QuickSortWriteFromMemTest implements ISort {

    @Override
    public int[] sort(int[] data) {
        sortIntern(data, 0, data.length - 1);
        return data;
    }

    private void sortIntern(int[] data, int start, int end) {
        if (start < end) {
            int p = partition(data, start, end);
            sortIntern(data, start, p - 1);
            sortIntern(data, p + 1, end);
        }
    }

    private int partition(int[] data, int start, int end) {
        int p = data[end];
        int sortedIndex = start - 1;

        for (int i = start; i < end; i++) {
            if (data[i] < p) {
                Util.swap(data, i, ++sortedIndex);
            }
        }

        Util.swap(data, sortedIndex + 1, end);

        return sortedIndex + 1;
    }

    @Test
    public void test() {
        int[] data = Util.prepareTestData(20);

        System.out.println(Arrays.toString(data));
        data = new QuickSortWriteFromMemTest().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
