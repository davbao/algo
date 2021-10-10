package main.java.algo.easy;

import main.java.algo.common.ListNode;

/**
 * @author davbao
 * @date 2021/10/9
 */
public class Nc4HasCycle {
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
        node5.next = node4;
        System.out.println(new Solution().hasCycle(node1));
        System.out.println(new Solution1().hasCycle(node1));
    }

    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Solution1 {
        public boolean hasCycle(ListNode head) {
            //如果head为空，或者他的next指向为空，直接返回false
            if (head == null || head.next == null) {
                return false;
            }
            //如果出现head.next = head表示有环
            if (head.next == head) {
                return true;
            }
            ListNode nextNode = head.next;
            //当前节点的next指向他自己，相当于把它删除了
            head.next = head;
            //然后递归，查看下一个节点
            return hasCycle(nextNode);
        }
    }
}
