class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        // Space-optimized version
        // int first = cost[0];
        // int second = cost[1];
        // for(int i = 2;i < n;i++){
        //     int ans = cost[i] + Math.min(first,second);
        //     first = second;
        //     second = ans;
        // }
        // return Math.min(first,second);
        
        //Iterative version
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2;i < n;i++){
            dp[i] = cost[i] + Math.min(dp[i - 1],dp[i - 2]);
        }
        return Math.min(dp[n - 1],dp[n - 2]);
    }
}