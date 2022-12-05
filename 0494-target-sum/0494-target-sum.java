 class Solution {
     public int findTargetSumWays(int[] nums, int target) {
//         int n = nums.length;
//         int sum = 0;
//         for(int i = 0;i < n;i++){
//            sum += nums[i]; 
//         }
//         int t = (sum - target)/2;
//         int dp[][] = new int[n + 1][t + 1];
//         for(int i = 0;i < n + 1;i++){
//             for(int j = 0;j < t + 1;j++){
//                 if(i == 0)
//                     dp[i][j] = 0;
//                 if(j == 0)
//                     dp[i][j] = 1;
//             }
//         }
//         for(int i = 1;i < n + 1;i++){
//             for(int j = 1;j < t + 1;j++){
//                 if(nums[i - 1] <= j)
//                     dp[i][j] = dp[i - 1][j] + dp[i - 1][nums[i - 1]];
//                 else
//                     dp[i][j] = dp[i - 1][j];
//             }
//         }
//         int count = 0;
//         for(int x : nums)
//           if(x == 0)
//               count++;
        
//          return (int)(Math.pow(2,count)) * dp[n][t];
          int sum = 0;
        for(int x : nums)
            sum += x;
        if(((sum - target) % 2 != 0) || (target > sum))
            return 0;
        
        int n = nums.length;
        int s2 = (sum - target)/2;
        
        int[][] t = new int[n + 1][s2 + 1];
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < s2 + 1; j++) {
                if(i == 0)
                    t[i][j] = 0;
                if(j == 0)
                    t[i][j] = 1;
            }
        }
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < s2 + 1; j++) {
                if((nums[i - 1] > j) || (nums[i - 1] == 0))
                    t[i][j] = t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j] + t[i - 1][j - nums[i - 1]];
            }
        }
        
        int count = 0;
        for(int x : nums)
            if(x == 0)
                count++;
        
        return (int)(Math.pow(2,count)) * t[n][s2];
    }
 }