package main.java.algo.easy;

import main.java.algo.common.TreeNode;

/**
 * @author davbao
 * @date 2021/10/10
 */
public class Nc62IsBalancedTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t2;
        t2.left = t4;
        t2.right = t3;
        System.out.println(new Solution().IsBalanced_Solution(t1));

        TreeNode tt1 = new TreeNode(1);
        TreeNode tt2 = new TreeNode(2);
        TreeNode tt3 = new TreeNode(3);
        tt1.left = t2;
        tt1.right = t3;
        System.out.println(new Solution1().isBalanced(tt1));

        System.out.println(new Solution2().isBalanced(tt1));
    }

    static class Solution {
        public boolean IsBalanced_Solution(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
                return false;
            }
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }

        public int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            int leftDepth = depth(root.left) + 1;
            int rightDepth = depth(root.right) + 1;
            return Math.max(leftDepth, rightDepth);
        }
    }

    /**
     * 一个有意思的解法
     */
    static class Solution1 {
        public boolean isBalanced(TreeNode root) {
            return height(root) >= 0;
        }

        private int height(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int lh = height(root.left), rh = height(root.right);
            if(lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) {
                return Math.max(lh, rh) + 1;
            } else {
                return -1;
            }
        }
    }

    /**
     * 一个有意思的解法，附带博客：https://lyl0724.github.io/2020/01/25/1/
     * 主要看博主对于递归问题的理解
     */
    static class Solution2 {
        //这个ReturnNode是参考我描述的递归套路的第二步：思考返回值是什么
        //一棵树是BST等价于它的左、右俩子树都是BST且俩子树高度差不超过1
        //因此我认为返回值应该包含当前树是否是BST和当前树的高度这两个信息
        private class ReturnNode{
            boolean isB;
            int depth;
            public ReturnNode(int depth, boolean isB){
                this.isB = isB;
                this.depth = depth;
            }
        }
        //主函数
        public boolean isBalanced(TreeNode root) {
            return isBST(root).isB;
        }
        //参考递归套路的第三部：描述单次执行过程是什么样的
        //这里的单次执行过程具体如下：
        //是否终止?->没终止的话，判断是否满足不平衡的三个条件->返回值
        public ReturnNode isBST(TreeNode root){
            if(root == null){
                return new ReturnNode(0, true);
            }
            //不平衡的情况有3种：左树不平衡、右树不平衡、左树和右树差的绝对值大于1
            ReturnNode left = isBST(root.left);
            ReturnNode right = isBST(root.right);
            if(left.isB == false || right.isB == false){
                return new ReturnNode(0, false);
            }
            if(Math.abs(left.depth - right.depth) > 1){
                return new ReturnNode(0, false);
            }
            //不满足上面3种情况，说明平衡了，树的深度为左右俩子树最大深度+1
            return new ReturnNode(Math.max(left.depth, right.depth) + 1, true);
        }
    }
}
