package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by krosshuang on 2018/12/5.
 */
public class P56_MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> result = new ArrayList<>();

        for (int i = 0; i < intervals.size(); i++) {
            if (result.isEmpty()) {
                result.add(intervals.get(i));
            } else {
                Interval lastOne = result.get(result.size() - 1);
                if (lastOne.end < intervals.get(i).start) {
                    result.add(intervals.get(i));
                } else {
                    lastOne.end = Math.max(intervals.get(i).end, lastOne.end);
                }
            }
        }

        return result;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
