package main.java.algo.easy;

/**
 * @author davbao
 * @date 2021/10/8
 */
public class Nc73MoreThanHalfNum {
    public static void main(String[] args) {
        int[] array = new int[]{47,47,72,47,72,47,79,47,12,92,13,47,47,83,33,15,18,47,47,47,47,64,47,65,47,47,47,47,70,47,47,55,47,15,60,47,47,47,47,47,46,30,58,59,47,47,47,47,47,90,64,37,20,47,100,84,47,47,47,47,47,89,47,36,47,60,47,18,47,34,47,47,47,47,47,22,47,54,30,11,47,47,86,47,55,40,49,34,19,67,16,47,36,47,41,19,80,47,47,27};
        int num = new Solution().MoreThanHalfNum_Solution(array);
        System.out.println(num);
    }

    static class Solution {
        public int MoreThanHalfNum_Solution(int[] array) {
            if (array == null || array.length == 0) {
                return -1;
            }
            int num = array[0];
            int count = 1;
            for (int i = 1; i < array.length; i++) {
                if (count <= 0) {
                    num = array[i];
                }
                if (array[i] == num) {
                    count++;
                } else {
                    count--;
                }
            }
            return num;
        }
    }
}
