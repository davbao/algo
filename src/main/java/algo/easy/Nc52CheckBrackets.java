package main.java.algo.easy;

import java.util.Stack;

/**
 * @author davbao
 * @date 2021/10/9
 */
public class Nc52CheckBrackets {

    public static void main(String[] args) {
        String test = "[";
        System.out.println(new Solution().isValid(test));
        System.out.println(new Solution1().isValid(test));
    }

    static class Solution {
        /**
         *
         * @param s string字符串
         * @return bool布尔型
         */
        public boolean isValid (String s) {
            // write code here
            char[] arr = s.toCharArray();
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
                    stack.push(arr[i]);
                }
                if (arr[i] == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                if (arr[i] == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                if (arr[i] == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
            }
            if (!stack.isEmpty()) {
                return false;
            }
            return true;
        }
    }

    static class Solution1 {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();
            //遍历所有的元素
            for (char c : chars) {
                //如果是左括号，就把他们对应的右括号压栈
                if (c == '(') {
                    stack.push(')');
                } else if (c == '{') {
                    stack.push('}');
                } else if (c == '[') {
                    stack.push(']');
                } else if (stack.isEmpty() || stack.pop() != c) {
                    //否则就只能是右括号。
                    //1，如果栈为空，说明括号无法匹配。
                    //2，如果栈不为空，栈顶元素就要出栈，和这个右括号比较。
                    //如果栈顶元素不等于这个右括号，说明无法匹配，
                    //直接返回false。
                    return false;
                }
            }
            //最后如果栈为空，说明完全匹配，是有效的括号。
            //否则不完全匹配，就不是有效的括号
            return stack.isEmpty();
        }
    }
}
