class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        for(int i = 0;i < dp.length;i++)
            dp[i] = -1;
        int ans = f(nums,nums.length - 1,dp);
        return ans;
    }
    public int f(int[] nums,int index,int dp[]){
        if(index == 0)
            return nums[index];
        if(index < 0)
            return 0;
        if(dp[index] != -1)
            return dp[index];
        int pick = nums[index] + f(nums,index - 2,dp);
        int notPick = 0 + f(nums,index - 1,dp);
        dp[index] = Math.max(pick,notPick);
        return dp[index];
    }
}