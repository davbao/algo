package main.java.algo.easy;

/**
 * @author davbao
 * @date 2021/10/10
 */
public class Nc57ReverseNumber {
    public static void main(String[] args) {
        int num = 123456;
        System.out.println(new Solution().reverse(num));
        System.out.println(new Solution1().reverse(-1234567));
    }

    static class Solution {
        /**
         *
         * @param x int整型
         * @return int整型
         */
        public int reverse(int x) {
            // write code here
            int res = 0;
            while (x != 0) {
                int mod = x % 10;
                int newRes = res * 10 + mod;
                // 逆运算判断是否相等，如果不能说明已经发生了溢出
                if ((newRes - mod) / 10 != res) {
                    return 0;
                }
                res = newRes;
                x = x / 10;
            }
            return res;
        }
    }

    static class Solution1 {
        public int reverse(int x) {
            int res = 0;
            while(x != 0){
                //计算之前计算后续会不会出现溢出
                if(res >= Integer.MAX_VALUE / 10 || res <= Integer.MIN_VALUE / 10) {
                    return 0;
                }
                res = res * 10 + x % 10;
                x = x / 10;
            }
            return res;
        }
    }
}
