package collection;

import collection.SparseArray;
import org.junit.Assert;
import org.junit.Test;

public class SparseArrayTest {

    @Test
    public void test1() {
        SparseArray<String> sparseArray = new SparseArray<>();

        sparseArray.put(1, "a");

        Assert.assertTrue(sparseArray.size() == 1);
        Assert.assertTrue(sparseArray.get(1).equals("a"));

        sparseArray.put(1, "b");

        Assert.assertTrue(sparseArray.get(1).equals("b"));
        Assert.assertTrue(sparseArray.size() == 1);
    }
}
