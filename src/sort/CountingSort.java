package sort;

import java.util.Arrays;

/**
 * Created by krosshuang on 2018/12/17.
 */
public class CountingSort {

    /**
     * 计数排序的应用场景是，如果需要排序的数字都在0-k这个范围内，那么就可以使用计数排序
     * */
    public static int[] sort(int[] arr, int k) {
        int[] counting = new int[k + 1];

        for (int i = 0; i < arr.length; i++) {
            counting[arr[i]]++;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] = counting[i] + counting[i - 1];
        }

        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            result[counting[arr[i]] - 1] = arr[i]; // 将一个元素取出来，查一下它应该放在哪个位置，然后放上去
            counting[arr[i]]--; // 再将它的计数器减1
        }

        return result;
    }

    public static void main(String[] args) {
        final int MAX_VALUE = 20;
        final int DATA_LEN = 20;

        int[] data = new int[DATA_LEN];

        for (int i = 0; i < DATA_LEN; i++) {
            data[i] = (int) (Math.random() * MAX_VALUE);
        }


        System.out.println(Arrays.toString(data));
        System.out.println(data.length);

        int[] result = sort(data, MAX_VALUE);



        System.out.println(Arrays.toString(result));
        System.out.println(result.length);

        result = new QuickSort().sort(data);
        System.out.println("correct:");
        System.out.println(Arrays.toString(result));
    }
}
