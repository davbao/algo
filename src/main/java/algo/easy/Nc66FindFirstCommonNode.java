package main.java.algo.easy;

import main.java.algo.common.ListNode;

/**
 * @author davbao
 * @date 2021/10/9
 */
public class Nc66FindFirstCommonNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        node6.next = node7;
        node7.next = node4;

        ListNode res = new Solution().FindFirstCommonNode(node1, node6);
        System.out.println(res.val);

        ListNode res1 = new Solution1().FindFirstCommonNode(node1, node6);
        System.out.println(res1.val);
    }

    static class Solution {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            if (pHead1 == null || pHead2 == null) {
                return null;
            }
            int m = 0;
            int n = 0;
            ListNode h1 = pHead1;
            ListNode h2 = pHead2;
            while (h1 != null) {
                m++;
                h1 = h1.next;
            }
            while (h2 != null) {
                n++;
                h2 = h2.next;
            }
            if (m > n) {
                for (int i = 0; i < m - n; i++) {
                    pHead1 = pHead1.next;
                }
            } else {
                for (int i = 0; i < n - m; i++) {
                    pHead2 = pHead2.next;
                }
            }
            while (pHead1 != null && pHead2 != null) {
                if (pHead1 == pHead2) {
                    return pHead1;
                }
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return null;
        }
    }

    /**
     * 如果没有公共点，两个指针会同时到达null，然后跳出循环，不会死循环的
     * 看下面的链表例子：
     * 0-1-2-3-4-5-null
     * a-b-4-5-null
     * 代码的if else语句，对于某个指针p1来说，其实就是让它跑了连接好的的链表，长度就变成一样了。
     * 如果有公共结点，那么指针一起走到末尾的部分，也就一定会重叠。看看下面指针的路径吧。
     * p1: 0-1-2-3-4-5-null(此时遇到if else)-a-b-4-5-null
     * p2: a-b-4-5-null(此时遇到if else)0-1-2-3-4-5-null
     * 因此，两个指针所要遍历的链表就长度一样了！
     * 如果两个链表存在公共结点，那么p1就是该结点，如果不存在那么p1将会是null。
     */
    static class Solution1 {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            if(pHead1 == null || pHead2 == null) {
                return null;
            }
            ListNode p1 = pHead1;
            ListNode p2 = pHead2;
            while(p1!=p2){
                p1 = p1.next;
                p2 = p2.next;
                if(p1 != p2){
                    if(p1 == null){
                        p1 = pHead2;
                    }
                    if(p2 == null){
                        p2 = pHead1;
                    }
                }
            }
            return p1;
        }

    }
}
