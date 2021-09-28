package main.java.algo.easy;

/**
 * @author davbao
 * @date 2021/9/28
 */
public class Nc151GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(new Solution1().gcd(60, 18));
        System.out.println(new Solution2().gcd(60, 18));
        System.out.println(new Solution3().gcd(60, 18));
    }

    /**
     * 方法一：比较大小，如果大的除以小的，余数不为0，则小的除以2等于i，然后分别判断a/i 和b/i余数是否为0
     */
    static class Solution1 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * 求出a、b的最大公约数。
         * @param a int
         * @param b int
         * @return int
         */
        public int gcd (int a, int b) {
            // write code here
            int max = Math.max(a,b);
            int min = Math.min(a, b);
            if (max % min == 0) {
                return min;
            }
            for (int i = min / 2; i >= 1; i--) {
                if (a % i == 0 && b % i == 0){
                    return i;
                }
            }
            return 1;
        }
    }

    /**
     * 方法二：(更相减损法)比较a,b大小，然后判断max % min 是否等于0，如果不等，则max-min, min，然后继续比较大小，并继续判断
     */
    static class Solution2 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * 求出a、b的最大公约数。
         * @param a int
         * @param b int
         * @return int
         */
        public int gcd (int a, int b) {
            // write code here
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            if (max % min == 0) {
                return min;
            }
            return gcd(max-min, min);
        }
    }

    /**
     * 方法三：(辗转相除法) 比较a,b大小，然后判断max % min 是否等于0，如果不等，则max%min, min，然后继续比较大小，并继续判断
     */
    static class Solution3 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * 求出a、b的最大公约数。
         * @param a int
         * @param b int
         * @return int
         */
        public int gcd (int a, int b) {
            // write code here
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            if (max % min == 0) {
                return min;
            }
            return gcd(max % min, min);
        }
    }
}
