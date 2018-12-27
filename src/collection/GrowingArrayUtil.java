package collection;

public class GrowingArrayUtil {

    /**
     * @param rawArr 原始数组
     * @param size 有效数据的长度，与数组长度不一样，如果数组长度大于有效数据的长度，那么往里面插入数据是OK的
     *             如果有效数据的长度等于数组的长度，那么要插入数据，就要创建更大的数组
     * @param insertIndex 插入index
     * @param insertValue 插入到index的数值
     * */
    public static int[] insert(int[] rawArr, int size, int insertIndex, int insertValue) {
        if (size < rawArr.length) {
            System.arraycopy(rawArr, insertIndex, rawArr, insertIndex + 1, size - insertIndex);
            rawArr[insertIndex] = insertValue;
            return rawArr;
        }

        int[] newArr = new int[rawArr.length * 2];
        System.arraycopy(rawArr, 0, newArr, 0, insertIndex);
        newArr[insertIndex] = insertValue;
        System.arraycopy(rawArr, insertIndex + 1, newArr, insertIndex + 1, size - insertIndex);
        return newArr;
    }

    public static <T> Object[] insert(Object[] rawArr, int size, int insertIndex, T insertValue) {
        if (size < rawArr.length) {
            System.arraycopy(rawArr, insertIndex, rawArr, insertIndex + 1, size - insertIndex);
            rawArr[insertIndex] = insertValue;
            return rawArr;
        }

        Object[] newArr = new Object[rawArr.length * 2];
        System.arraycopy(rawArr, 0, newArr, 0, insertIndex);
        newArr[insertIndex] = insertValue;
        System.arraycopy(rawArr, insertIndex + 1, newArr, insertIndex + 1, size - insertIndex);
        return newArr;
    }
}
