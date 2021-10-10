package main.java.algo.easy;

/**
 * @author davbao
 * @date 2021/9/30
 */
public class Nc7MaxProfit {
    public static void main(String[] args) {
        int[] a = new int[]{4,1,2,3};
        System.out.println(new Solution().maxProfit(a));
        System.out.println(new Solution1().maxProfit(a));
    }

    static class Solution {
        public int maxProfit (int[] prices) {
            int len = prices.length;
            int[] prize = new int[100];
            int k = 0;
            for (int i = 0; i <= len - 2; i++) {
                for (int j = i + 1; j <= len - 1; j++) {
                    int interval = prices[j] - prices[i];
                    prize[k++] = interval;
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < prize.length; i++) {
                if (prize[i] > max) {
                    max = prize[i];
                }
            }
            return max;
        }
    }

    /**
     * 在找到最大价格之前找到最小的价格
     */
    static class Solution1 {
        public int maxProfit(int[] prices) {
            if(prices==null||prices.length==0){
                return 0;
            }
            int max=0;
            int min=prices[0];
            for(int i=0;i<prices.length;i++){
                min = Math.min(min,prices[i]);
                max=Math.max(max,prices[i]-min);
            }
            return max;
        }
    }
}
