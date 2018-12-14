package sort;

/**
 * Created by krosshuang on 2018/11/3.
 */
public interface ISort {

    public static final int SortType_INCREASE = 1;
    public static final int SortType_DECREASE = 2;

    public int[] sort(int[] data);
}
