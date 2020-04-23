package search;

public class BinarySearch {

    // 测试基准，查找 10000000次，在长度为100的数组中找第一个元素
    // 右移比除以2快19毫秒
    // final比没有final快5毫秒
    // 逻辑右移比算术右移快2毫秒

    // 问题1：为什么要返回 ~lo ?
    // 回答：返回 ~lo

    public static int search(int[] arr, int target) {
        return search(arr, arr.length, target);
    }

    public static int search(int[] arr, int size, int target) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final int value = arr[mid];

            if (value == target) {
                return mid;
            } else if (value > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ~lo;
    }
}