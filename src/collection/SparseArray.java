package collection;

import search.BinarySearch;

public class SparseArray<E> {

    private static final Object DELETED = new Object();
    private int[] mKeys;
    private Object[] mValues;
    private int mSize = 0;

    public SparseArray() {
        this(10);
    }

    public SparseArray(int initCap) {
        mKeys = new int[initCap];
        mValues = new Object[initCap];
    }

    public void put(int key, E value) {
        int i = BinarySearch.search(mKeys, mSize, key);
        if (i >= 0) {
            mValues[i] = value;
        } else {
            i = ~i;

            // 这一段代码是处理这一的场景的
            // 比如当前的数据为 [3, 4, 7, 8]，先插入一个9，9应该放在最后，于是 [3, 4, 7, 8, 9]
            // 然后删除9，那么mValues里面的值就被标记为DELETED了，这个时候，插入10，那么10，二分查找的结果为没找到，但是应该放在之前
            // 9的位置上，如果这个位置是deleted的，就直接放进去就可以了。
            // 如果不按照上面这个描述来的话，会造成什么情况呢。就会将数组中保留一份DELETED的数据，没有被清理掉。复制的时候也把它顺带复制了
            if (i < mSize && mValues[i] == DELETED) {
                mKeys[i] = key;
                mValues[i] = value;
                return;
            }

            insertKey(i, key);
            insertValue(i, value);
            mSize++;
        }
    }

    public E get(int key) {
        // 首先查找这个key存不存在
        int i = BinarySearch.search(mKeys, mSize, key);

        // 这里有两种情况
        // 如果key小于0，说明在mKeys中，没有目标key，没找到
        // 如果key大于0，还要看一下，对应的mValues中，是否那个元素是DELETED，因为删除的时候是标记删除的
        // 以上两种情况都是没有找到
        if (i < 0 || mValues[i] == DELETED) {
            return null;
        } else {
            return (E)mValues[i];
        }
    }

    public void delete(int key) {
        // 删除的时候为标记删除，先要找到是否有这个key，如果没有，就没必要删除了；
        // 找到了key看一下对应的value是否已经是DELETED，如果是的话，也没必要再删除了
        int i = BinarySearch.search(mKeys, mSize, key);
        if (i >= 0 && mValues[i] != DELETED) {
            mValues[i] = DELETED;
        }
    }

    private void insertKey(int insertIndex, int insertValue) {
        System.arraycopy(mKeys, insertIndex, mKeys, insertIndex + 1, mSize - insertIndex);
        mKeys[insertIndex] = insertValue;
    }

    private void insertValue(int insertIndex, E insertValue) {
        System.arraycopy(mValues, insertIndex, mValues, insertIndex + 1, mSize - insertIndex);
        mValues[insertIndex] = insertValue;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {

    }
}
