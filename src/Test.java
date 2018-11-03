import java.util.Arrays;

/**
 * Created by krosshuang on 2018/11/3.
 */
public class Test {

    public static void main(String[] args) {
        int loopCount = 100000;

        int[] result = null;

        long t = System.currentTimeMillis();

        final int DATA_SIZE = 100;

        // data generate
        int[] arr = new int[DATA_SIZE];
        for (int i = 0; i < DATA_SIZE; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }

        t = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            result = HeapSort.heapSort(arr, HeapSort.SortType.Increase);
        }
        System.out.println("heap sort: " + (System.currentTimeMillis() - t));
        System.out.println(Arrays.toString(result));

        t = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            result = QuickSort.quickSort(arr);
        }
        System.out.println("quick sort: " + (System.currentTimeMillis() - t));
        System.out.println(Arrays.toString(result));

        t = System.currentTimeMillis();
        MergeSort mergeSort = new MergeSort();
        for (int i = 0; i < loopCount; i++) {
            result = mergeSort.sort(arr);
        }
        System.out.println("merge sort: " + (System.currentTimeMillis() - t));
        System.out.println(Arrays.toString(result));
    }
}
