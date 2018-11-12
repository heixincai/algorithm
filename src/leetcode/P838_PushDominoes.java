package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by krosshuang on 2018/11/3.
 */
public class P838_PushDominoes {

    public static void main(String[] args) {
        String s = ".L.R...LR..L..";

        String result = new P838_PushDominoes().pushDominoes(s);
        System.out.println(result);
    }

    public String pushDominoes(String dominoes) {
        boolean isChange = true;

        char[] data = dominoes.toCharArray();

        Map<Integer, Object> opedIndex = new HashMap<>();

        while (isChange) {
            isChange = false;
            for (int i = 0; i < data.length; i++) {
                char c = data[i];

                if (opedIndex.containsKey(i)) {
                    continue;
                }

                if (c == '.') {
                    if (opedIndex.containsKey(i + 1) && opedIndex.containsKey(i - 1)) {
                        opedIndex.put(i, null);
                    }
                    continue;
                } else if (c == 'L') {
                    opedIndex.put(i, null);
                    if (i - 1 >= 0) {
                        if (data[i - 1] == '.') {
                            data[i - 1] = 'L';
                            isChange = true;
                        } else if (data[i - 1] == 'R') {
                            if (!opedIndex.containsKey(i - 1)) {
                                data[i - 1] = '.';
                                isChange = true;
                                opedIndex.put(i - 1, null);
                            }
                        }
                    }
                } else if (c == 'R') {
                    opedIndex.put(i, null);

                    if (i + 1 <= data.length - 1) {
                        char rightOne = data[i + 1];
                        if (rightOne == '.') {
                            data[i + 1] = 'R';
                            isChange = true;
                            i++;
                        }
                    }
                }
            }
        }

        return String.copyValueOf(data);
    }
}
