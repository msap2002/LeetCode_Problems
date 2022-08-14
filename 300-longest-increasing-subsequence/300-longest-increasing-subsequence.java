class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                dp[i][j] = -1;
            }
        }
        int ans = f(0,-1,dp,nums,nums.length);
        return ans;
    }
    public int f(int index,int prevIndex,int dp[][],int nums[],int n){
        if(index == n)
            return 0;
        if(dp[index][prevIndex + 1] != -1)
            return dp[index][prevIndex + 1];
        int len = 0 + f(index + 1,prevIndex,dp,nums,n);
        if(prevIndex == -1||nums[index] > nums[prevIndex])
            len = Math.max(len,1 + f(index + 1,index,dp,nums,n));
        return dp[index][prevIndex + 1] = len;
    }
}