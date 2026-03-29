class Solution {
    public int climbStairs(int n, int[] costs) {
        long[] dp = new long[n + 1];
        
        for (int i = 1; i <= n; i++) {
            dp[i] = Long.MAX_VALUE;
        }
        
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int jump = 1; jump <= 3; jump++) {
                int j = i - jump;
                if (j >= 0 && dp[j] != Long.MAX_VALUE) {
                    long currentCost = dp[j] + (long)jump * jump + costs[i - 1];
                    dp[i] = Math.min(dp[i], currentCost);
                }
            }
        }
        
        return (int) dp[n];
    }
}
