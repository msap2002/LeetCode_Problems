//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int n = nums.length;
        int dp1[] = new int[n];
        for(int i = 0;i < n;i++)
          dp1[i] = 1;
        int dp2[] = new int[n];
        for(int i = 0;i < n;i++)
          dp2[i] = 1;
        for(int i = 0;i < n;i++){
            for(int prev = 0;prev < i;prev++){
                if(nums[i] > nums[prev] && dp1[i] < 1 + dp1[prev])
                   dp1[i] = 1 + dp1[prev];
            }
        }
        for(int i = n - 1;i >= 0;i--){
            for(int prev = n - 1;prev > i;prev--){
                if(nums[i] > nums[prev] && dp2[i] < 1 + dp2[prev])
                   dp2[i] = 1 + dp2[prev];
            }
        }
        int bitonic[] = new int[n];
        int maxi = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            bitonic[i] = (dp1[i] + dp2[i]) - 1;
            maxi = Math.max(maxi,bitonic[i]);
        }
        return maxi;
    }
}