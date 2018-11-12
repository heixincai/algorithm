/**
 * Created by krosshuang on 2018/11/12.
 */
public class InsertSort implements ISort {

    @Override
    public int[] sort(int[] data) {

        if (data == null) {
            return null;
        }

        if (data.length == 1) {
            return data;
        }

        for (int i = 1; i < data.length; i++) {
            int finder = i;
            int val = data[i];
            while (finder >= 0 && val < data[finder - 1]) {
                data[finder] = data[finder - 1];
                data[finder - 1] = val;
                finder--;
            }
        }

        return data;
    }
}
