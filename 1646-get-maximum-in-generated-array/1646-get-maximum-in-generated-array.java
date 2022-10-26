class Solution {
    public int getMaximumGenerated(int n) {
        if(n == 0||n == 1)
            return n;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int ans = Math.max(dp[0],dp[1]);
        for(int i = 1;(2 * i + 1) <= n;i++){
            dp[2 * i] = dp[i];
            dp[2 * i + 1] = dp[i] + dp[i + 1];
            ans = Math.max(ans,Math.max(dp[2 * i],dp[2 * i + 1]));
        }
        return ans;
    }
}