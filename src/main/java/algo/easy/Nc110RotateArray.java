package main.java.algo.easy;

/**
 * @author davbao
 * @date 2021/9/28
 */
public class Nc110RotateArray {
    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,4,5,6};
        new Solution().solve(6, 2, a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }

    /**
     * 旋转数组例如123456，m=2，结果为561234
     * 1234翻转4321
     * 56翻转65
     * 432165整体翻转561234
     */
    static class Solution {
        /**
         * 旋转数组
         * @param n int整型 数组长度
         * @param m int整型 右移距离
         * @param a int整型一维数组 给定数组
         * @return int整型一维数组
         */
        public int[] solve (int n, int m, int[] a) {
            // write code here
            m = n >= m ? m : m % n;
            reverse(a, 0, n - m - 1);
            reverse(a, n - m, n - 1);
            reverse(a, 0, n - 1);
            return a;
        }

        public void reverse(int[] a, int start, int end) {
            while (start < end) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++;
                end--;
            }
        }
    }
}
