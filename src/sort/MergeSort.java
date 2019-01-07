package sort;

import sort.ISort;

import java.util.Arrays;

/**
 * Created by krosshuang on 2018/11/3.
 */
public class MergeSort implements ISort {

    public static void main(String[] args) {
        int[] result = new MergeSort().sort(new int[]{3, 4, 6, 1, 23, 12, 33, 99, 2, 7, 8});
        System.out.println(Arrays.toString(result));
    }

    @Override
    public int[] sort(int[] data) {
        sortIntern(data, 0, data.length - 1);
        return data;
    }

    private void sortIntern(int[] data, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            sortIntern(data, l, mid);
            sortIntern(data, mid + 1, r);
            merge(data, l, mid, r);
        }
    }

    private void merge(int[] data, int l, int m, int r) {
        final int n1 = m - l + 1;
        final int n2 = r - m;

        final int[] arr1 = new int[n1];
        final int[] arr2 = new int[n2];

        System.arraycopy(data, l, arr1, 0, n1);
        System.arraycopy(data, m + 1, arr2, 0, n2);

        int i = 0; int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                data[k++] = arr1[i++];
            } else {
                data[k++] = arr2[j++];
            }
        }

        while (i < n1) data[k++] = arr1[i++];
        while (j < n2) data[k++] = arr2[j++];
    }

    private int[][] mergeArray(int[][] arrOfArr) {
        if (arrOfArr == null) {
            return null;
        } else {
            if (arrOfArr.length == 1) {
                return arrOfArr;
            } else {
                int groupCount = (int) Math.ceil(arrOfArr.length / 2f);

                int[][] resultGroupCount = new int[groupCount][];

                for (int i = 0; i < groupCount; i++) {
                    int[] arrA = arrOfArr[i * 2];
                    int[] arrB = arrOfArr.length - 1 < i * 2 + 1 ? null : arrOfArr[i * 2 + 1];
                    resultGroupCount[i] = mergeTwoArr(arrA, arrB);
                }

                return mergeArray(resultGroupCount);
            }
        }
    }

    private int[] mergeTwoArr(int[] arrA, int[] arrB) {
        if (arrA == null) {
            if (arrB == null) {
                return null;
            } else {
                return arrB;
            }
        } else {
            if (arrB == null) {
                return arrA;
            } else {
                int indexA = 0;
                int indexB = 0;

                int[] result = new int[arrA.length + arrB.length];

                for (int i = 0; i < result.length; i++) {
                    if (indexA >= arrA.length) {
                        result[i] = arrB[indexB];
                        indexB++;
                    } else if (indexB >= arrB.length) {
                        result[i] = arrA[indexA];
                        indexA++;
                    } else {
                        if (arrA[indexA] < arrB[indexB]) {
                            result[i] = arrA[indexA];
                            indexA++;
                        } else {
                            result[i] = arrB[indexB];
                            indexB++;
                        }
                    }
                }

                return result;
            }
        }
    }
}
