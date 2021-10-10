package main.java.algo.easy;

/**
 * @author davbao
 * @date 2021/10/9
 */
public class Nc32CalSqrt {
    public static void main(String[] args) {
        System.out.println(new Solution().sqrt(101));
        System.out.println(new Solution1().sqrt(4));
        System.out.println(new Solution2().sqrt(120));
        System.out.println(new Solution().sqrt(1518991037));
    }

    static class Solution {
        /**
         * @param x int整型
         * @return int整型
         */
        public int sqrt(int x) {
            int left = 0;
            int right = x;
            int ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long temp = (long) mid * mid;
                if (temp <= x) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }
    }

    static class Solution1 {
        public int sqrt(int x) {
            // 特殊值判断
            if (x == 0) {
                return 0;
            }
            if (x == 1) {
                return 1;
            }

            int left = 1;
            int right = x / 2;
            // 在区间 [left..right] 查找目标元素
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                // 注意：这里为了避免乘法溢出，改用除法
                if (mid > x / mid) {
                    // 下一轮搜索区间是 [left..mid - 1]
                    right = mid - 1;
                } else {
                    // 下一轮搜索区间是 [mid..right]
                    left = mid;
                }
            }
            return left;
        }
    }

    static class Solution2 {
        public int sqrt(int x) {
            int left = 0;
            int right = x;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long temp = (long)mid * mid;
                if (temp == x) {
                    return mid;
                } else if (right - left == 1) {
                    return right * right <= x ? right : left;
                } else if (temp < x) {
                    left = mid;
                } else if (temp > x) {
                    right = mid;
                }
            }
            return -1;
        }
    }
}
