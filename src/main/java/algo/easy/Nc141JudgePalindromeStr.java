package main.java.algo.easy;

/**
 * @author davbao
 * @date 2021/9/28
 */
public class Nc141JudgePalindromeStr {
    public static void main(String[] args) {
        System.out.println(new Solution().judge("123321"));
        System.out.println(new Solution().judge("aba"));
        System.out.println(new Solution().judge("abc"));
    }

    static class Solution {
        public boolean judge (String str) {
            // write code here
            char[] arr = str.toCharArray();
            int left = 0;
            int right = arr.length - 1;
            //left从左到右，right从右向左，依次判断，结束条件：left >= right
            while (left < right) {
                if (arr[left] == arr[right]) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}

