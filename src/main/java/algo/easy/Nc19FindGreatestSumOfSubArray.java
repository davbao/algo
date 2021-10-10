package main.java.algo.easy;

/**
 * @author davbao
 * @date 2021/10/9
 */
public class Nc19FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        System.out.println(new Solution().FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5}));
    }

    static class Solution {
        public int FindGreatestSumOfSubArray(int[] array) {
            int max = array[0];
            int res = array[0];
            for (int i = 1; i < array.length; i++) {
                max = Math.max(array[i] + max, array[i]);
                res = Math.max(max, res);
            }
            return res;
        }
    }
}
