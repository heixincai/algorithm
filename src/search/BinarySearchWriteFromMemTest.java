package search;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchWriteFromMemTest {

    public static int search(int[] data, int value) {

        int lo = 0;
        int hi = data.length - 1;

        while (lo <= hi) {
            final int m = (lo + hi) / 2;
            final int v = data[m];

            if (v < value) {
                lo = m + 1;
            } else if (v > value) {
                hi = m - 1;
            } else {
                return m;
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
