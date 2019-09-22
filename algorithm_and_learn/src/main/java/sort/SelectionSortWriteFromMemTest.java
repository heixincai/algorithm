package sort;

import org.junit.Test;
import util.Util;

import java.util.Arrays;

public class SelectionSortWriteFromMemTest implements ISort {

    @Override
    public int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = data[i];
            int minIndex = i;

            for (int j = i; j < data.length; j++) {
                if (data[j] < min) {
                    min = data[j];
                    minIndex = j;
                }
            }

            Util.swap(data, i, minIndex);
        }

        return data;
    }

    @Test
    public void test() {
        int[] data = Util.prepareTestData(30);

        System.out.println(Arrays.toString(data));
        new SelectionSortWriteFromMemTest().sort(data);
        System.out.println(Arrays.toString(data));

    }
}
