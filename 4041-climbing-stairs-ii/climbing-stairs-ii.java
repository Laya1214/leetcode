class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int jump = 1; jump <= 3; jump++) {
                int j = i - jump;
                if (j >= 0 && dp[j] != Integer.MAX_VALUE) {
                    int currentCost = dp[j] + jump * jump + costs[i - 1];
                    dp[i] = Math.min(dp[i], currentCost);
                }
            }
        }
        
        return  dp[n];
    }
}
