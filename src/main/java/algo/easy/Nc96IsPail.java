package main.java.algo.easy;

import main.java.algo.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author davbao
 * @date 2021/10/8
 */
public class Nc96IsPail {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(new Solution().isPail(node1));
        System.out.println(new Solution1().isPail(node1));
        System.out.println(new Solution2().isPail(node1));
    }

    /**
     * 快慢指针
     */
    static class Solution {
        /**
         *
         * @param head ListNode类 the head
         * @return bool布尔型
         */
        public boolean isPail (ListNode head) {
            // write code here
            if (head == null || head.next == null) {
                return true;
            }
            ListNode s = head;
            ListNode f = head.next;
            Stack<ListNode> stack = new Stack<ListNode>();
            while (f != null && f.next != null) {
                stack.push(s);
                s = s.next;
                f = f.next.next;
            }
            ListNode work = null;
            if (f != null && f.next == null) {
                stack.push(s);
                work = s.next;
            }
            if (f == null) {
                work = s.next;
            }
            while (work != null && !stack.isEmpty()) {
                if (work.val != stack.pop().val) {
                    return false;
                }
                work = work.next;
            }
            if (!stack.isEmpty()) {
                return false;
            }
            return true;
        }
    }

    /**
     * 双端队列
     */
    static class Solution1 {
        /**
         *
         * @param head ListNode类 the head
         * @return bool布尔型
         */
        public boolean isPail (ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            Deque<ListNode> queue = new LinkedList<ListNode>();
            ListNode work = head;
            while (work != null) {
                queue.addLast(work);
                work = work.next;
            }
            while (queue.size() > 1) {
                ListNode node1 = queue.pollFirst();
                ListNode node2 = queue.pollLast();
                if (node1.val != node2.val) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Solution2 {
        public boolean isPail (ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode reverseList = reverse(slow);
            ListNode cur1 = reverseList, cur2 = head;
            while (cur1 != null) {
                if (cur1.val != cur2.val) {
                    return false;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return true;
        }

        public ListNode reverse(ListNode head) {
            ListNode cur = head, pre = null;
            while (cur != null) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return pre;
        }
    }
}
