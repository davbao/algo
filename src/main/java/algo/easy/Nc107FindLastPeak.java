package main.java.algo.easy;

/**
 * @author davbao
 * @date 2021/9/28
 */
public class Nc107FindLastPeak {
    public static void main(String[] args) {
        System.out.println(new Solution().solve(new int[]{2,4,9,2,7,8,4}));
    }

    /**
     * 这里最后山峰的意思是最后一个满足a[i] > a[i+1]且a[i] > a[i-1]
     */
    static class Solution {
        /**
         * 寻找最后的山峰
         * @param a int整型一维数组
         * @return int整型
         */
        public int solve (int[] a) {
            // write code here
            if (a == null || a.length == 0) {
                return -1;
            }
            int i = a.length - 1;
            while (i >= 1) {
                if (a[i] > a[i-1]) {
                    return i;
                }
                i--;
            }
            return 0;
        }
    }
}
