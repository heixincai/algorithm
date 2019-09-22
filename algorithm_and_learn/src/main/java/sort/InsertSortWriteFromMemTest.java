package sort;

import org.junit.Test;
import util.Util;

import java.util.Arrays;

/**
 * */
public class InsertSortWriteFromMemTest implements ISort {

    @Override
    public int[] sort(int[] data) {

        for (int i = 1; i < data.length; i++) {
            int p = data[i];
            int j = i - 1;

            while (j >= 0 && data[j] > p) {
                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = p;
        }

        return data;
    }

    @Test
    public void test() {
        int[] data = Util.prepareTestData(20);

        System.out.println(Arrays.toString(data));
        data = new InsertSortWriteFromMemTest().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
