package sort;

import org.junit.Test;
import util.Util;

import java.util.Arrays;

/**
 * 默写记录
 * 2019-01-14 19:00:11
 * 2019-01-18 00:34:29
 * */
public class InsertSortWriteFromMemTest implements ISort {

    @Override
    public int[] sort(int[] data) {
        return null;
    }

    @Test
    public void test() {
        int[] data = Util.prepareTestData(20);

        System.out.println(Arrays.toString(data));
        data = new InsertSortWriteFromMemTest().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
