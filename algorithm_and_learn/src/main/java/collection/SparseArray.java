package collection;

import search.BinarySearch;

public class SparseArray<E> {

    private static final Object DELETED = new Object();
    private int[] mKeys;
    private Object[] mValues;
    private int mSize = 0;

    /**
     * 标记是否有DELETED元素标记
     * */
    private boolean mHasDELETED = false;

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

            // 找到了有两种情况
            // 1.是对应的mValues有一个有效的数据对象，直接覆盖
            // 2.对应的mValues里面是一个DELETED对象，同样的，直接覆盖

            mValues[i] = value;
        } else {
            i = ~i;

            // 这一段代码是处理这一的场景的
            // 1 2 3 5, delete 5, put 4
            if (i < mSize && mValues[i] == DELETED) {
                mKeys[i] = key;
                mValues[i] = value;
                return;
            }

            // 另一种情况
            // 如果有删除的元素，并且数组装满了，这个时候需要先GC，再重新搜一下key的位置
            if (mHasDELETED && mSize >= mKeys.length) {
                gc();
                i = ~BinarySearch.search(mKeys, mSize, key);
            }

            mKeys = GrowingArrayUtil.insert(mKeys, mSize, i, key);
            mValues = GrowingArrayUtil.insert(mValues, mSize, i, value);
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
            mHasDELETED = true;
        }
    }

    private void gc() {

        int placeHere = 0;

        for (int i = 0; i < mSize; i++) {
            Object obj = mValues[i];
            if (obj != DELETED) {

                if (i != placeHere) {
                    mKeys[placeHere] = mKeys[i];
                    mValues[placeHere] = obj;
                    mValues[i] = null;
                }
                placeHere++;
            }

        }

        mHasDELETED = false;
        mSize = placeHere;
    }

    public int size() {
        if (mHasDELETED) {
            gc();
        }
        return mSize;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
