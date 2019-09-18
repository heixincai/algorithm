package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class P950_Reveal_Cards_In_Increasing_Order {


    public static void main(String[] args) {
        new P950_Reveal_Cards_In_Increasing_Order().deckRevealedIncreasing(new int[]{2 ,3, 4, 5, 6, 7, 8});
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        LinkedList<Integer> que = new LinkedList<>();

        for (int i = deck.length - 1; i >= 0; i--) {
            if (que.size() >= 1) {
                Integer l = que.pollLast();
                que.add(0, l);
                que.add(0, deck[i]);
            } else {
                que.push(deck[i]);
            }
        }

        int[] arr = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            arr[i] = que.get(i);
        }
        return arr;
    }

    public int[] deckRevealedIncreasing2(int[] deck) {
        Arrays.sort(deck);

        LinkedList<Integer> que = new LinkedList<>();

        // 构造一个卡牌的index序列 [0, 1, 2, 3, ....]
        for (int i = 0; i < deck.length; i++) {
            que.add(i);
        }

        int[] res = new int[deck.length];

        for (int i = 0; i < deck.length; i++) {
            res[que.poll()] = deck[i];
            que.add(que.poll());
        }

        return res;
    }
}
