package sort;

import sort.ISort;

/**
 * Created by krosshuang on 2018/11/12.
 */
public class InsertSort implements ISort {

    @Override
    public int[] sort(int[] data) {

        if (data == null) {
            return null;
        }

        if (data.length == 1) {
            return data;
        }

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
}
