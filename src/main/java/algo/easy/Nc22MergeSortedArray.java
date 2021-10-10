package main.java.algo.easy;

/**
 * @author davbao
 * @date 2021/10/9
 */
public class Nc22MergeSortedArray {

    public static void main(String[] args) {
        int[] a = new int[11];
        a[0] = 1;
        a[1] = 3;
        a[2] = 5;
        a[3] = 7;
        a[4] = 9;
        int[] b = new int[]{2,4,6,8,10,12};
        //new Solution().merge(a, 5, b, 6);
        new Solution1().merge(a, 5, b, 6);
    }

    static class Solution {
        public void merge(int A[], int m, int B[], int n) {
            int[] temp = new int[m+n];
            int index = 0;
            int i = 0;
            int j = 0;
            while (i < m && j < n) {
                if (A[i] <= B[j]) {
                    temp[index++] = A[i++];
                } else {
                    temp[index++] = B[j++];
                }
            }
            while (i < m) {
                temp[index++] = A[i++];
            }
            while (j < n) {
                temp[index++] = B[j++];
            }
            for (int k = 0; k < m+n; k++) {
                A[k] = temp[k];
            }
            System.out.println("end");
        }
    }

    static class Solution1 {
        public void merge(int A[], int m, int B[], int n) {
            int index = m + n - 1;
            int i = m - 1;
            int j = n - 1;
            while (i >= 0 && j >= 0) {
                A[index--] = A[i] > B[j] ? A[i--] : B[j--];
            }
            while (j >= 0) {
                A[index--] = B[j--];
            }
            System.out.println("end");
        }
    }
}
