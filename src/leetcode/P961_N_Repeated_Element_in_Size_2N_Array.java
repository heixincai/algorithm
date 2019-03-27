package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by krosshuang on 2019/3/27.
 */
public class P961_N_Repeated_Element_in_Size_2N_Array {

    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int a : A) {
            count.put(a, count.getOrDefault(a, 0) + 1);
            if (count.get(a) > 1) {
                return a;
            }
        }

        return 0;
    }
}
