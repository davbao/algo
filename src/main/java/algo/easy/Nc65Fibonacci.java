package main.java.algo.easy;

/**
 * @author davbao
 * @date 2021/9/28
 */
public class Nc65Fibonacci {
    public static void main(String[] args) {
        System.out.println(new Solution1().Fibonacci(6));
        System.out.println(new Solution2().Fibonacci(6));
    }

    static class Solution1 {
        public int Fibonacci(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1 || n == 2) {
                return 1;
            }
            return Fibonacci(n-1) + Fibonacci(n-2);
        }
    }

    static class Solution2 {
        public int Fibonacci(int n) {
            int[] ans = new int[40];
            ans[0] = 0;
            ans[1] = 1;
            for (int i = 2; i <=n; i++) {
                ans[i] = ans[i-1] + ans[i-2];
            }
            return ans[n];
        }
    }
}
