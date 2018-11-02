import java.util.Arrays;

/**
 * Created by krosshuang on 2018/11/3.
 */
public class QuickSort {

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

    public static int[] quickSort(int[] arr) {
        if (arr == null) {
            return null;
        } else {
            quickSortIntern(arr, 0, arr.length - 1);
            return arr;
        }
    }

    private static void quickSortIntern(int arr[], int start, int end) {
        if (arr != null) {
            if (start < end) {
                int x = partition(arr, start, end);
                quickSortIntern(arr, start, x - 1);
                quickSortIntern(arr, x + 1, end);
            }
        }
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex];

        int nextSmallPlace = startIndex;

        for (int p = startIndex; p < endIndex; p++) {
            if (arr[p] < pivot) {
                if (p != nextSmallPlace) {
                    swap(arr, p, nextSmallPlace);
                }
                nextSmallPlace++;
            }
        }
        swap(arr, nextSmallPlace, endIndex);

        return nextSmallPlace;
    }

    private static void swap(int[] arr, int i, int j) {
        int p = arr[i];
        arr[i] = arr[j];
        arr[j] = p;
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
