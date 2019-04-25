package leetcode;

import sun.misc.LRUCache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by krosshuang on 2018/12/2.
 */
public class P146_LRUCache {

    public static void main(String[] args) {
        P146_LRUCache cache = new P146_LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }

    LinkedList<Integer> list = new LinkedList();
    Map<Integer, Integer> maps = new HashMap<>();

    int cap = 0;

    public P146_LRUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        int ret = -1;

        if (maps.containsKey(key)) {
            ret = maps.get(key);

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == key) {
                    list.remove(i);
                    break;
                }
            }

            list.add(0, key);
        }

        return ret;
    }

    public void put(int key, int value) {
        maps.put(key, value);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) {
                list.remove(i);
                break;
            }
        }

        list.add(0, key);

        if (list.size() > cap) {
            maps.remove(list.removeLast());
        }
    }
}
