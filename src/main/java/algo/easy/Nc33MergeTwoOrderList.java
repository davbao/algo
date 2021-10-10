package main.java.algo.easy;

import main.java.algo.common.ListNode;

/**
 * @author davbao
 * @date 2021/9/28
 */
public class Nc33MergeTwoOrderList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        node1.next = node3;
        node3.next = node5;
        node5.next = null;
        node2.next = node4;
        node4.next = node6;
        node6.next = null;
        ListNode ans = new Solution().Merge(node1, node2);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
    static class Solution {
        public ListNode Merge(ListNode list1,ListNode list2) {
            if (list1 == null || list2 == null) {
                return list1 == null ? list2 : list1;
            }
            ListNode node = new ListNode(-1);
            ListNode head = node;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    node.next = list1;
                    node = list1;
                    list1 = list1.next;
                    node.next = null;
                } else {
                    node.next = list2;
                    node = list2;
                    list2 = list2.next;
                    node.next = null;
                }
            }
            if (list1 != null) {
                node.next = list1;
            }
            if (list2 != null) {
                node.next = list2;
            }
            return head.next;
        }
    }
}
