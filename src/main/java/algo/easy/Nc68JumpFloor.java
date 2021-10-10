package main.java.algo.easy;

/**
 * @author davbao
 * @date 2021/10/9
 */
public class Nc68JumpFloor {
    public static void main(String[] args) {
        System.out.println(new Solution().jumpFloor(5));
    }

    static class Solution {
        public int jumpFloor(int target) {
            int[] ans = new int[40];
            ans[0] = 1;
            ans[1] = 1;
            for (int i = 2; i <= target; i++) {
                ans[i] = ans[i-1] + ans[i-2];
            }
            return ans[target];
        }
    }
}
