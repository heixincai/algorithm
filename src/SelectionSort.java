/**
 * Created by krosshuang on 2018/12/4.
 */
public class SelectionSort implements ISort {
    @Override
    public int[] sort(int[] data) {
        if (data == null) {
            return null;
        }

        if (data.length == 1) {
            return data;
        }


        for (int i = 0; i < data.length; i++) {

            int min = data[i];
            int minIndex = i;

            for (int j = i; j < data.length; j++) {
                if (data[j] < min) {
                    min = data[j];
                    minIndex = j;
                }
            }

            data[minIndex] = data[i];
            data[i] = min;
        }

        return data;
    }
}
