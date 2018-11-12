import java.util.Arrays;

/**
 * Created by krosshuang on 2018/11/3.
 */
public class Test {

    static int loopCount = 100000;

    public static void main(String[] args) {

        int[] result = null;

        long t = System.currentTimeMillis();

        final int DATA_SIZE = 10;

        // data generate
        int[] arr = new int[DATA_SIZE];
        for (int i = 0; i < DATA_SIZE; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        System.out.println(Arrays.toString(arr));

        testSort(arr, new HeapSort(), "heap sort");
        testSort(arr, new QuickSort(), "quick sort");
        testSort(arr, new MergeSort(), "merge sort");
        testSort(arr, new InsertSort(), "insert sort");
    }

    public static void testSort(int[] sortData, ISort sortImpl, String sortName) {
        long t = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            sortData = sortImpl.sort(sortData);
        }
        System.out.println(sortName + "(" + loopCount + "): " + (System.currentTimeMillis() - t));
        System.out.println(Arrays.toString(sortData));
    }
}
