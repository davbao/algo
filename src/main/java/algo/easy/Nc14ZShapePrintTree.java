package main.java.algo.easy;

import main.java.algo.common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author davbao
 * @date 2021/10/9
 */
public class Nc14ZShapePrintTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        ArrayList<ArrayList<Integer>> list = new Solution().Print(node1);
        System.out.println("end");
    }

    static class Solution {
        public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
            if (pRoot == null) {
                return list;
            }
            Stack<TreeNode> s1 = new Stack<TreeNode>();
            Stack<TreeNode> s2 = new Stack<TreeNode>();
            s1.push(pRoot);
            while (!s1.isEmpty() || !s2.isEmpty()) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    temp.add(node.val);
                    if (node.left != null) {
                        s2.push(node.left);
                    }
                    if (node.right != null) {
                        s2.push(node.right);
                    }
                }
                if (temp.size() > 0) {
                    list.add(temp);
                }
                temp = new ArrayList<Integer>();
                while(!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    temp.add(node.val);
                    if (node.right != null) {
                        s1.push(node.right);
                    }
                    if (node.left != null) {
                        s1.push(node.left);
                    }
                }
                if (temp.size() > 0) {
                    list.add(temp);
                }
            }
            return list;
        }
    }
}
