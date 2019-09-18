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


    // 测试放满的情况
    @Test
    public void test2() {
        SparseArray<String> sparseArray = new SparseArray<>(5);

        sparseArray.put(1, "a");
        sparseArray.put(2, "b");
        sparseArray.put(3, "c");
        sparseArray.put(4, "d");
        sparseArray.put(5, "e");

        sparseArray.put(6, "f");

        Assert.assertTrue(sparseArray.size() == 6);
        Assert.assertTrue(sparseArray.get(1).equals("a"));
        Assert.assertTrue(sparseArray.get(2).equals("b"));
        Assert.assertTrue(sparseArray.get(3).equals("c"));
        Assert.assertTrue(sparseArray.get(4).equals("d"));
        Assert.assertTrue(sparseArray.get(5).equals("e"));
        Assert.assertTrue(sparseArray.get(6).equals("f"));

    }

    @Test
    public void test3() {
        SparseArray<String> sparseArray = new SparseArray<>(5);

        sparseArray.put(2, "a");
        sparseArray.put(3, "b");
        sparseArray.put(4, "c");
        sparseArray.put(7, "d");
        sparseArray.put(8, "e");

        sparseArray.delete(4);

        //Assert.assertTrue(sparseArray.size() == 4);

        sparseArray.put(5, "q");

        Assert.assertTrue(sparseArray.size() == 5);
        Assert.assertTrue(sparseArray.get(2).equals("a"));
        Assert.assertTrue(sparseArray.get(3).equals("b"));
        Assert.assertTrue(sparseArray.get(4) == null);
        Assert.assertTrue(sparseArray.get(5).equals("q"));
        Assert.assertTrue(sparseArray.get(7).equals("d"));
        Assert.assertTrue(sparseArray.get(8).equals("e"));
    }

    @Test
    public void test4() {
        SparseArray<String> sparseArray = new SparseArray<>(5);

        sparseArray.put(1, "a");
        sparseArray.put(2, "b");
        sparseArray.put(3, "c");
        sparseArray.put(5, "d");


        sparseArray.delete(5);

        //Assert.assertTrue(sparseArray.size() == 4);

        sparseArray.put(4, "q");

        Assert.assertTrue(sparseArray.size() == 4);
        Assert.assertTrue(sparseArray.get(1).equals("a"));
        Assert.assertTrue(sparseArray.get(2).equals("b"));
        Assert.assertTrue(sparseArray.get(3).equals("c"));
        Assert.assertTrue(sparseArray.get(4).equals("q"));
        Assert.assertTrue(sparseArray.get(5) == null);
    }
}
