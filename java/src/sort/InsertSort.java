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

        // 从第1个元素开始，认为第0个元素是已经排好的
        for (int i = 1; i < data.length; i++) {
            int p = data[i];
            int j = i - 1;

            // 不断的判断左边的元素，是否大于当前值，如果大于的话，就将这个值往右挪一个，再判断下一个值
            while (j >= 0 && data[j] > p) {
                data[j + 1] = data[j];
                j--;
            }

            // 上面条件不满足了，说明，j + 1的位置是p应当放置的位置
            data[j + 1] = p;
        }

        return data;
    }
}
