package sort;

import org.junit.Test;
import util.Util;

import java.util.Arrays;

public class MergeSortWriteFromMemTest implements ISort {

    @Override
    public int[] sort(int[] data) {
        sortIntern(data, 0, data.length - 1);
        return data;
    }

    private void sortIntern(int[] data, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sortIntern(data, l, m);
            sortIntern(data, m + 1, r);
            merge(data, l, m, r);
        }
    }

    private void merge(int[] data, int l, int m, int r) {
        final int n1 = m - l + 1;
        final int n2 = r - m;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = data[l + i];
        }

        for (int i = 0; i < n2; i++) {
            arr2[i] = data[m + 1 + i];
        }

        int i = 0; int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                data[k++] = arr1[i++];
            } else {
                data[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            data[k++] = arr1[i++];
        }

        while (j < n2) {
            data[k++] = arr2[j++];
        }
    }

    @Test
    public void test() {
        int[] data = Util.prepareTestData(20);
        System.out.println(Arrays.toString(data));
        data = new MergeSortWriteFromMemTest().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
