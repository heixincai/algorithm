package search;

import org.junit.Assert;
import org.junit.Test;

/**
 * 默写记录
 * 2019-01-14 18:54:22 默写一次
 *
 * */
public class BinarySearchWriteFromMemTest {

    public static int search(int[] data, int value) {

        int lo = 0;
        int hi = data.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int p = data[mid];

            if (p > value) {
                hi = mid - 1;
            } else if (p < value) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return ~lo;
    }

    @Test
    public void test() {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Assert.assertEquals(search(data, 0), ~0);
        Assert.assertEquals(search(data, 4), 3);
        Assert.assertEquals(search(data, 9), 8);
        Assert.assertEquals(search(data, 22), ~10);
    }
}
