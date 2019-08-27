package leetcode;

import java.util.Arrays;

class P1122_Relative_Sort_Array {

    // 还有另一种思路，将arr2做成一个map，记录每个数的index，然后遍历arr1，查找在map2中的位置，插入到一个很大的数组中的正确位置
    public static void main(String[] args) {

//        int[] arr1 = new int[]{2,3,1,3,2,4,6,22,9,2,19};
//        int[] arr2 = new int[]{2,1,4,3,9,6};

        int[] arr1 = new int[]{26,21,11,20,50,34,1,18};
        int[] arr2 = new int[]{21,11,26,20};
        new P1122_Relative_Sort_Array().relativeSortArray(arr1, arr2);

        System.out.println(Arrays.toString(arr1));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int nextPlace = 0; // arr1 中下一个摆放位置
        int find = 0;      // arr1 中找到与compareIndex相同的数
        int compareIndex = 0; // arr2 中当前正在比较的数

        // 初始化
        while (arr1[nextPlace] == arr2[compareIndex]) {
            nextPlace++;
            find = nextPlace + 1;
        }

        while (compareIndex < arr2.length) {
            while (find < arr1.length) {

                // 1.一直找，找到arr1中和arr2中相同的数
                while (find < arr1.length && arr1[find] != arr2[compareIndex]) {
                    find++;
                }

                if (find >= arr1.length) {
                    break;
                }

                // 2.交换两个数
                if (arr1[find] == arr2[compareIndex]) {
                    swap(arr1, nextPlace, find);
                    nextPlace++; // 3.下一个摆放位置 +1
                    find++; // 4.下一个查找位置自增，为啥，不然的话就无无限循环了
                }
            }

            // 5.找完了一圈，说明compareIndex对应的数已经都找完了，compareIndex自增，找下一个数
            compareIndex++;
            find = nextPlace;
        }

        // 6.最后排序剩余的数
        if (nextPlace != arr1.length - 1) {
            Arrays.sort(arr1, nextPlace, arr1.length);
        }

        return arr1;

    }

    public void swap(int[] arr, int x, int y) {
        int a = arr[x];
        arr[x] = arr[y];
        arr[y] = a;
    }

}
