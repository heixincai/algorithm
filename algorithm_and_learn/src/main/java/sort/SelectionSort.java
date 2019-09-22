package sort;

import sort.ISort;

/**
 * Created by krosshuang on 2018/12/4.
 */
public class SelectionSort implements ISort {
    @Override
    public int[] sort(int[] data) {
        if (data == null) {
            return null;
        }

        if (data.length == 1) {
            return data;
        }

        // 1. 从头遍历到尾
        for (int i = 0; i < data.length; i++) {

            // 2. 认为当前遍历的数是最小的
            int min = data[i];
            int minIndex = i;

            // 3. 然后接着遍历后面的数，找到最小的那个数
            for (int j = i; j < data.length; j++) {
                if (data[j] < min) {
                    min = data[j];
                    minIndex = j;
                }
            }

            // 4. 然后交换最小的和当前的数
            data[minIndex] = data[i];
            data[i] = min;
        }

        return data;
    }
}
