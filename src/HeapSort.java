import java.util.Arrays;

public class HeapSort implements ISort {

    public static void main(String[] args) {

        int loopCount = 100000;

        int[] result = null;

        long t = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            result = heapSort(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, SortType.Decrease);
        }
        System.out.println(System.currentTimeMillis() - t);
        System.out.println(Arrays.toString(result));

        t = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            result = heapSort(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, SortType.Increase);
        }
        System.out.println(System.currentTimeMillis() - t);
        System.out.println(Arrays.toString(result));

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        t = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            result = heapSort(arr, SortType.Increase);
        }
        System.out.println(System.currentTimeMillis() - t);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 堆排序
     *
     * @param input    输入数据
     * @param sortType 排序类型 升序还是降序
     */
    public static int[] heapSort(int[] input, SortType sortType) {

        if (input == null || input.length == 0) {
            return null;
        }

        int[] heap = input;
        int[] result = new int[input.length];
        int heapLength = input.length; // 初始化堆的大小，每次找到一个数后，堆的大小都减少1，不去操作最后一个已经排好的数
        for (int i = 0; i < input.length; i++) {
            heap = maxHeapify(heap, heapLength, SortType.Decrease); // 进行堆调整，只调整heapLength的区域

            // Decrease 排序的话，总是得到最小堆
            if (sortType == SortType.Increase) {
                result[i] = heap[0];
            } else {
                result[input.length - i - 1] = heap[0];
            }

            swap(heap, 0, heapLength - 1); // 调整完成后，将第一个元素后最后一个元素交换
            heapLength--; // 堆的大小减一
        }

        return result;
    }

    /**
     * 堆调整
     */
    public static int[] maxHeapify(int[] heap, int heapLength, SortType sortType) {
        if (heap == null) {
            return null;
        }

        if (heap.length == 1) {
            return heap;
        }

        for (int i = heapLength / 2 - 1; i >= 0; i--) { // 从最后一个有children的节点开始，向前遍历

            int leftIndex = i * 2 + 1; // left child index
            int rightIndex = i * 2 + 2; // right child index

            if (heapLength > leftIndex) {
                if (sortType == SortType.Increase) {
                    if (heap[i] < heap[leftIndex]) { // 判断当前节点和左节点的大小，进行交换
                        swap(heap, i, leftIndex);
                    }
                } else if (sortType == SortType.Decrease) {
                    if (heap[i] > heap[leftIndex]) {
                        swap(heap, i, leftIndex);
                    }
                }

                if (heapLength > rightIndex) { // 处理右节点，如果存在的话
                    if (sortType == SortType.Increase) {
                        if (heap[i] < heap[rightIndex]) {
                            swap(heap, i, rightIndex);
                        }
                    } else if (sortType == SortType.Decrease) {
                        if (heap[i] > heap[rightIndex]) {
                            swap(heap, i, rightIndex);
                        }
                    }
                }
            }
        }

        return heap;
    }

    public static void swap(int[] arr, int i, int j) {
        int v = arr[i];
        arr[i] = arr[j];
        arr[j] = v;
    }

    @Override
    public int[] sort(int[] data) {
        return heapSort(data, SortType.Increase);
    }

    enum SortType {
        Increase, Decrease
    }


}
