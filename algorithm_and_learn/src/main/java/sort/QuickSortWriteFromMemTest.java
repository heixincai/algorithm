package sort;

import org.junit.Test;
import util.Util;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * */
public class QuickSortWriteFromMemTest implements ISort {

    @Override
    public int[] sort(int[] data) {
        sortIntern(data, 0, data.length - 1);
        return data;
    }

    private void sortIntern(int[] data, int start, int end) {

    }

    private int partition(int[] data, int start, int end) {
        return 0;
    }

    @Test
    public void test() {
        int[] data = Util.prepareTestData(20);

        System.out.println(Arrays.toString(data));
        data = new QuickSortWriteFromMemTest().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
