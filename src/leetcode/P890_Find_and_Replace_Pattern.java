package leetcode;

import java.util.ArrayList;
import java.util.List;

class P890_Find_and_Replace_Pattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList<>();

        List<Integer> pat = parse(pattern);

        for (String w : words) {
            if (same(pat, parse(w))) {
                ret.add(w);
            }
        }

        return ret;
    }

    public static List<Integer> parse(String pattern) {
        List<Integer> arr = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < pattern.toCharArray().length; i++) {
            if (i == 0) {
                c = 1;
            } else {
                if (pattern.charAt(i) == pattern.charAt(i - 1)) {
                    c++;
                } else {
                    arr.add(c);
                    c = 1;
                }
            }
        }
        arr.add(c);
        return arr;
    }

    public static boolean same(List<Integer> a1, List<Integer> a2) {
        if (a1.size() != a2.size()) {
            return false;
        } else {
            for (int i = 0; i < a1.size(); i++) {
                if (a1.get(i).equals(a2.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}