package test;

import search.BinarySearch;
import sort.*;

import java.util.Arrays;

/**
 * Created by krosshuang on 2018/11/3.
 */
public class Test {

    static int loopCount = 100000;

    public static void main(String[] args) {

        int[] result = null;

        long t = System.currentTimeMillis();

        final int DATA_SIZE = 100;

        // data generate
        int[] arr = new int[DATA_SIZE];
        for (int i = 0; i < DATA_SIZE; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        System.out.println(Arrays.toString(arr));

        testSort(arr, new HeapSort(), "heap sort");
        testSort(arr, new QuickSort(), "quick sort");
        testSort(arr, new MergeSort(), "merge sort");
        testSort(arr, new InsertSort(), "insert sort");
        testSort(arr, new SelectionSort(), "sort.SelectionSort");

        // test binary search

        int[] sortedArr = new QuickSort().sort(arr);

        System.out.println("search: " + sortedArr[0] + " result: " + BinarySearch.search(sortedArr, sortedArr[0]));
        System.out.println("search: " + sortedArr[sortedArr.length - 1] + " result: " + BinarySearch.search(sortedArr, sortedArr[sortedArr.length - 1]));
        System.out.println("search: " + 1 + " result: " + BinarySearch.search(sortedArr, 1));

        t = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            BinarySearch.search(sortedArr, sortedArr[0]);
        }
        System.out.println("search 1: " + (System.currentTimeMillis() - t));

        t = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            BinarySearch.search2(sortedArr, sortedArr[0]);
        }
        System.out.println("search 2: " + (System.currentTimeMillis() - t));


    }

    public static void testSort(int[] sortData, ISort sortImpl, String sortName) {
        long t = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            sortData = sortImpl.sort(sortData);
        }
        System.out.println(sortName + "(" + loopCount + "): " + (System.currentTimeMillis() - t));
        System.out.println(Arrays.toString(sortData));
    }
}
