package main.java.algo.easy;

import main.java.algo.common.TreeNode;

/**
 * @author davbao
 * @date 2021/10/9
 */
public class Nc13MaxDepth {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        node4.right = node6;
        System.out.println(new Solution().maxDepth(node1));
    }

    static class Solution {
        /**
         *
         * @param root TreeNode类
         * @return int整型
         */
        public int maxDepth (TreeNode root) {
            // write code here
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            int leftDepth = maxDepth(root.left) + 1;
            int rightDepth = maxDepth(root.right) + 1;
            return Math.max(leftDepth, rightDepth);
        }
    }
}
