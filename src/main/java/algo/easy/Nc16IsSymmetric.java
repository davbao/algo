package main.java.algo.easy;

import main.java.algo.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author davbao
 * @date 2021/10/10
 */
public class Nc16IsSymmetric {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        t1.left = t2;
        t1.right = t3;
        System.out.println(new Solution().isSymmetric(t1));
        System.out.println(new Solution1().isSymmetric(t1));
    }

    /**
     * 递归解法
     */
    static class Solution {
        /**
         *
         * @param root TreeNode类
         * @return bool布尔型
         */
        public boolean isSymmetric (TreeNode root) {
            // write code here
            return help(root, root);
        }

        public boolean help(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 != null && node2 == null) {
                return false;
            }
            if (node1 == null && node2 != null) {
                return false;
            }
            return node1.val == node2.val && help(node1.left, node2.right) && help(node1.right, node2.left);
        }
    }

    /**
     * 双端队列的解法
     */
    static class Solution1 {
        public boolean isSymmetric (TreeNode root) {
            if(root==null){
                return true;
            }
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root.left);
            queue.add(root.right);
            while(!queue.isEmpty()){
                TreeNode left=queue.poll();
                TreeNode right=queue.poll();
                if(left==null&&right==null) {
                    continue;
                }
                if(left==null||right==null) {
                    return false;
                }
                if(left.val!=right.val) {
                    return false;
                }
                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
            }
            return true;
        }
    }
}
