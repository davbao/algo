package main.java.algo.easy;

/**
 * @author davbao
 * @date 2021/9/28
 */
public class Nc101FindMissingNum {
    public static void main(String[] args) {
        System.out.println(new Solution().solve(new int[]{0,1,2,3,4,5,7,8,9}));
        System.out.println(new Solution().solve(new int[]{0,1,3,4,5,6,7}));
    }

    /**
     * 二分查找即可
     */
    static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * 找缺失数字
         * @param a int整型一维数组 给定的数字串
         * @return int整型
         */
        public int solve (int[] a) {
            // write code here
            int left = 0;
            int right = a.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (a[mid] > mid) {
                    right = mid - 1;
                }
                if (a[mid] == mid) {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
