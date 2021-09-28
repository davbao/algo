package main.java.algo.easy;

import java.util.Stack;

/**
 * @author zhangzhongbao
 * @date 2021/9/28
 */
public class Nc76TwoStackToQueue {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.push(1);
        s.push(2);
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

    static class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.size() <= 0) {
                while (stack1.size() != 0) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
