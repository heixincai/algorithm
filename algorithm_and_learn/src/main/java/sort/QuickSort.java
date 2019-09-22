package sort;

import sort.ISort;
import util.Util;

import java.util.Arrays;

/**
 * Created by krosshuang on 2018/11/3.
 */
public class QuickSort implements ISort {

    @Override
    public int[] sort(int[] data) {
        return quickSort(data);
    }

    public static void main(String[] args) {

        final int DATA_SIZE = 10;
        int[] data = new int[DATA_SIZE];

        for (int i = 0; i < DATA_SIZE; i++) {
            data[i] = (int) (Math.random() * 100);
        }

        System.out.println(Arrays.toString(data));
        data = quickSort(data);
        System.out.println(Arrays.toString(data));
    }

    private static int[] quickSort(int[] arr) {
        if (arr == null) {
            return null;
        } else {
            quickSortIntern(arr, 0, arr.length - 1);
            return arr;
        }
    }

    /**
     * 1. start, end 都是include的index
     * */
    private static void quickSortIntern(int arr[], int start, int end) {
        if (arr != null) {
            if (start < end) { // 2. 这里要 start < end
                int x = partition(arr, start, end);
                quickSortIntern(arr, start, x - 1);
                quickSortIntern(arr, x + 1, end);
            }
        }
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 3. 取出最后一个数，作为一个判断值
        int p = arr[endIndex];

        // 4. 左边已经排好的index
        int indexOfSortedLeft = startIndex - 1;

        // 5. 遍历所有的数，除了最后一个
        for (int i = startIndex; i < endIndex; i++) {

            // 6. 如果当前的这个数，小于判断值p，就将它交换到下一个需要放置的位置上
            if (arr[i] < p) {
                Util.swap(arr, i, indexOfSortedLeft + 1);
                indexOfSortedLeft++; // 7. 再自增自己，此时，index指向的已经排好的元素，下一个才是未知的元素
            }
        }

        //8. 交换判断值p和排好的下一个元素的值
        Util.swap(arr, indexOfSortedLeft + 1, endIndex);

        // 9. 然后再返回这个中间值p
        return indexOfSortedLeft + 1;
    }

    /**
     * Pick the pivot from array.
     * */
    private static int pickPivot(int[] arr) {
        if (arr == null) {
            return 0;
        } else {
            return arr[arr.length - 1];
        }
    }


}
