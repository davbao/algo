package main.java.algo.easy;

/**
 * @author davbao
 * @date 2021/9/28
 */
public class Nc78ReverseList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode ans = new Solution().ReverseList(node1);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    static class Solution {
        public ListNode ReverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }

}
