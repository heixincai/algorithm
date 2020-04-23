package test;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import search.BinarySearch;
import sort.*;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by krosshuang on 2018/11/3.
 */
public class Test {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 34, 89, 56, 72, 63, 29, 74, 69};
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, arr);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    static int loopCount = 100000;

//    public static void A main(String[] args) {
//
//        int[] result = null;
//
//        long t = System.currentTimeMillis();
//
//        final int DATA_SIZE = 100;
//
//        // data generate
//        int[] arr = new int[DATA_SIZE];
//        for (int i = 0; i < DATA_SIZE; i++) {
//            arr[i] = (int) (Math.random() * 10000);
//        }
//        System.out.println(Arrays.toString(arr));
//
//        testSort(arr, new HeapSort(), "heap sort");
//        testSort(arr, new QuickSort(), "quick sort");
//        testSort(arr, new MergeSort(), "merge sort");
//        testSort(arr, new InsertSort(), "insert sort");
//        testSort(arr, new SelectionSort(), "sort.SelectionSort");
//
//        // test binary search
//
//        int[] sortedArr = new QuickSort().sort(arr);
//
//        System.out.println("search: " + sortedArr[0] + " result: " + BinarySearch.search(sortedArr, sortedArr[0]));
//        System.out.println("search: " + sortedArr[sortedArr.length - 1] + " result: " + BinarySearch.search(sortedArr, sortedArr[sortedArr.length - 1]));
//        System.out.println("search: " + 1 + " result: " + BinarySearch.search(sortedArr, 1));
//
//        t = System.currentTimeMillis();
//        for (int i = 0; i < 10000000; i++) {
//            BinarySearch.search(sortedArr, sortedArr[0]);
//        }
//        System.out.println("search 1: " + (System.currentTimeMillis() - t));
//
//    }
//
//    public static void testSort(int[] sortData, ISort sortImpl, String sortName) {
//        long t = System.currentTimeMillis();
//        for (int i = 0; i < loopCount; i++) {
//            sortData = sortImpl.sort(sortData);
//        }
//        System.out.println(sortName + "(" + loopCount + "): " + (System.currentTimeMillis() - t));
//        System.out.println(Arrays.toString(sortData));
//    }

    @org.junit.Test
    public void teststs() {
        boolean ret = isBuildBySelfSubString("acac");
        Assert.assertEquals(ret, true);

    }

    @org.junit.Test
    public void teststs2() {

        boolean ret = isBuildBySelfSubString("aca");
        Assert.assertEquals(ret, false);

    }

    @org.junit.Test
    public void teststs3() {

        boolean ret = isBuildBySelfSubString("acdacdacdacd");
        Assert.assertEquals(ret, true);
    }

    public boolean isBuildBySelfSubString(String input) {

        if (input == null || input.length() <= 1) {
            return false;
        }

        int len = input.length();

        String sub = "";

        for (int i = 0; i < len / 2; i++) {

            // plan 1: 使用subString
            // sub = input.subString(0, i);

            // plan 2: 每次直接拼接一个就行了
            sub += input.charAt(i);

            if (len % sub.length() != 0) {
                continue;
            } else {
                // plan 1: 使用equals，比较次数为原字符串长度 len
                //if (createWhole(sub, len).equals(input)) {

                // plan 2: 使用 len / subLen 次的startWith 优化
                if (isMatchWhole(sub, input)) {
                    return true;
                } else {
                    continue;
                }
            }
        }

        return false;  
    }

    public String createWhole(String sub, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len / sub.length(); i++) {
            sb.append(sub);
        }
        return sb.toString();
    }

    public boolean isMatchWhole(String sub, String raw) {
        for (int i = 0; i < raw.length() / sub.length() - 1; i++) {
            if (!raw.startsWith(sub, (i + 1) * sub.length())) {
                return false;
            }
        }
        return true;
    }
}