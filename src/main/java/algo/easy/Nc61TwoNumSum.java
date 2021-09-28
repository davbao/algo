package main.java.algo.easy;

import java.util.HashMap;

/**
 * @author davbao
 * @date 2021/9/28
 */
public class Nc61TwoNumSum {
    public static void main(String[] args) {
        int[] num = new int[]{3,2,4};
        int target = 6;
        int[] ans = new Solution().twoSum(num, 6);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    static class Solution {
        /**
         *
         * @param numbers int整型一维数组
         * @param target int整型
         * @return int整型一维数组
         */
        public int[] twoSum (int[] numbers, int target) {
            // write code here
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0, tmp; i < numbers.length; i++) {
                tmp = numbers[i];
                int val = target - numbers[i];
                if (map.containsKey(val)) {
                    return new int[]{map.get(target - numbers[i]), i+1};
                }
                map.put(tmp, i + 1);
            }
            return new int[]{};
        }
    }
}
