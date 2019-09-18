package leetcode;

import java.util.Stack;

/**
 * Created by krosshuang on 2018/11/20.
 */
public class P143_ReorderList {

    public static ListNode convert(int[] arr) {
        ListNode head = null;
        ListNode last = null;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                head = new ListNode(arr[i]);
                last = head;
            } else {
                ListNode l = new ListNode(arr[i]);
                last.next = l;
                last = l;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = convert(new int[]{1, 2, 3, 4});
        new P143_ReorderList().reorderList(head);

        int a = 0;
    }

    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }

        ListNode h1 = head; // 步进1
        ListNode h2 = head; // 步进2
        ListNode midPrev = head; // 这个找到中点的前一个节点

        while (h2 != null) {
            if (h1 != head) {
                midPrev = midPrev.next;
            }
            h1 = h1.next;
            h2 = h2.next;
            if (h2 != null) {
                h2 = h2.next;
            }
        }

        // 此时 h1 为中点节点

        midPrev.next = null; // 将前一个断链

        // 将h1后面的加入栈中
        Stack<ListNode> stack = new Stack<ListNode>();
        while (h1 != null) {
            stack.push(h1);
            h1 = h1.next;
        }

        ListNode curr = head;

        // 从栈里面取出来，重新链接
        while (!stack.isEmpty()) {
            ListNode t = stack.pop();
            ListNode next = curr.next;
            curr.next = t;
            t.next = next;
            curr = next;
        }
    }
}
