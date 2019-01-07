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

    public void sortIntern(int[] data, int l, int r) {
        if (l < r) {
            int m = partion(data, l, r);
            sortIntern(data, l, m - 1);
            sortIntern(data, m + 1, r);
        }
    }

    public int partion(int[] data, int l, int r) {
        int p = data[r];

        int sortedIndex = l - 1;

        for (int i = l; i < r; i++) {
            if (data[i] < p) {
                Util.swap(data, i, ++sortedIndex);
            }
        }

        Util.swap(data, ++sortedIndex, r);

        return sortedIndex;
    }

    @Test
    public void test() {
        int[] data = Util.prepareTestData(20);

        System.out.println(Arrays.toString(data));
        data = new QuickSortWriteFromMemTest().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
