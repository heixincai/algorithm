package search;

public class BinarySearch {

    public static int search(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            // 右移比除以2快19毫秒
            // final比没有final快5毫秒
            // 逻辑右移比算术右移快2毫秒
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

    public static int search2(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ~lo;
    }
}