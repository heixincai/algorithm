package leetcode;

import java.util.ArrayList;
import java.util.List;

class P46_Permutations {

    public static List<List<Integer>> allResult = new ArrayList();

    public static void main(String[] args) {
        new P46_Permutations().permute(new int[] {-1,2,3,6});
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int n : nums) {
            list.add(n);
        }

        doThing(list, null);

        return allResult;

    }

    public static void doThing(List<Integer> list, List<Integer> oneResult) {
        if (oneResult == null) {
            oneResult = new ArrayList();
        }

        if (list.size() == 1) {
            oneResult.add(list.get(0));
            allResult.add(oneResult);
            oneResult = null;
        } else {
            for (int i = 0; i < list.size(); i++) {
                List<Integer> otherResult = clone(oneResult);
                otherResult.add(list.get(i));
                List<Integer> newList = clone(list);
                newList.remove(list.get(i));
                doThing(newList, otherResult);

            }
        }
    }

    public static List<Integer> clone(List<Integer> list) {
        List<Integer> newList = new ArrayList();
        newList.addAll(list);
        return newList;
    }
}
