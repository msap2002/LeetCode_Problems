//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minOperation(int n)
    {
        //code here.
        int dp[] = new int[n + 1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    public int helper(int n,int[] dp){
        if(n == 0)
           return 0;
        if(dp[n] != -1)
           return dp[n];
        if(n % 2 == 0){
            return dp[n] = 1 + helper(n/2,dp);
        }
        else
            return dp[n] = 1 + helper(n - 1,dp);
    }
}