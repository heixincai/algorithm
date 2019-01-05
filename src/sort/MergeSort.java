package sort;

import sort.ISort;

/**
 * Created by krosshuang on 2018/11/3.
 */
public class MergeSort implements ISort {

    @Override
    public int[] sort(int[] data) {

        int[][] arrOfArr = new int[data.length][1];

        for (int i = 0; i < data.length; i++) {
            arrOfArr[i][0] = data[i];
        }

        int[][] result = mergeArray(arrOfArr);

        return result[0];
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
