package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P890_Find_and_Replace_Pattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList<>();
        String standard = standard(pattern);

        for (String w : words) {
            if (standard(w).equals(standard)) {
                ret.add(w);
            }
        }

        return ret;
    }

    public static String standard(String pattern) {
        Map<Character, Character> maps = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char availableC = 'a';
        int c = 0;
        for (int i = 0; i < pattern.toCharArray().length; i++) {
            if (i == 0) {
                c = 1;
                maps.put(pattern.charAt(i), availableC);
                sb.append(availableC);
            } else {
                if (pattern.charAt(i) == pattern.charAt(i - 1)) {
                    c++;
                } else {
                    sb.append(c);
                    if (maps.containsKey(pattern.charAt(i))) {
                        sb.append(maps.get(pattern.charAt(i)));
                    } else {
                        availableC++;
                        maps.put(pattern.charAt(i), availableC);
                        sb.append(availableC);
                    }
                    c = 1;
                }
            }
        }

        sb.append(c);

        return sb.toString();
    }
}