package main.java.algo.easy;

/**
 * @author davbao
 * @date 2021/9/22
 */
public class Nc103ReverseStr {
    public static void main(String[] args) {
        System.out.println(new Solution().solve("1234"));
        System.out.println(new Solution().solve("12345"));
    }
}

class Solution {
    /**
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public String solve (String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] arr = str.toCharArray();
        ////根据长度分奇偶数讨论，奇数时end = (arr.length - 1) / 2,偶数时候为arr.length / 2 - 1
        int end = arr.length % 2 != 0 ? (arr.length - 1) / 2 : arr.length / 2 - 1;
        for (int i = 0; i <= end; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        return String.valueOf(arr);
    }
}
