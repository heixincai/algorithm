package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class P933_Number_of_Recent_Calls {

    Queue<Integer> data = new ArrayDeque<>();

    public int ping(int t) {

        int v = t - 3000;

        data.add(t);

        while (!data.isEmpty() && data.peek() < v) {
            data.poll();
        }

        return data.size();
    }

}
