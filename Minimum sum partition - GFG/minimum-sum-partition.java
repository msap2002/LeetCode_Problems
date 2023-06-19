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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum = 0;
	    for(Integer i : arr)
	       sum += i;
	    boolean dp[][] = new boolean[n][sum + 1];
	    for(int i = 0;i < n;i++){
	        dp[i][0] = true;
	    }
	    if(arr[0] <= sum)
	      dp[0][sum] = true;
	    for(int i = 1;i < n;i++){
	        for(int target = 1;target <= sum;target++){
	            boolean notPick = dp[i - 1][target];
	            boolean pick = false;
	            if(arr[i] <= target)
	              pick = dp[i - 1][target - arr[i]];
	            dp[i][target] = notPick | pick;
	        }
	    }
	    int mini = (int)1e9;
        for (int i = 0; i <= sum; i++) {
            if (dp[n - 1][i] == true) {
            int diff = Math.abs(i - (sum - i));
            mini = Math.min(mini, diff);
            }
        }
        return mini;
	} 
}
