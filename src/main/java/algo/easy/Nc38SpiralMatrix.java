package main.java.algo.easy;

import java.util.ArrayList;

/**
 * @author davbao
 * @date 2021/9/28
 */
public class Nc38SpiralMatrix {
    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        ArrayList<Integer> list = new Solution().spiralOrder(a);
        list.forEach(item -> System.out.println(item));
    }

    /**
     * 思路：定义矩阵的左右，上下边界，然后每遍历一个边，则更新对应的边界范围即可
     */
    static class Solution {
        public ArrayList<Integer> spiralOrder(int[][] matrix) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if (matrix.length == 0) {
                return list;
            }
            if (matrix[0].length == 0) {
                return list;
            }
            int left = 0;
            int right = matrix[0].length - 1;
            int up = 0;
            int down = matrix.length - 1;
            while (true) {
                if (left > right) {
                    return list;
                }
                for (int k = left; k <= right; k++) {
                    list.add(matrix[up][k]);
                }
                up++;
                if (up > down) {
                    return list;
                }
                for (int k = up; k <= down; k++) {
                    list.add(matrix[k][right]);
                }
                right--;
                if (left > right) {
                    return list;
                }
                for (int k = right; k >= left; k--) {
                    list.add(matrix[down][k]);
                }
                down--;
                if (up > down) {
                    return list;
                }
                for (int k = down; k >= up; k--) {
                    list.add(matrix[k][left]);
                }
                left++;
            }
        }
    }
}
