//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[n][W + 1];
        //  for(int[] arr : dp){
        //      Arrays.fill(arr,-1);
        //  }
        //  return f(n - 1,W,wt,val,dp);
        for(int w = 0;w <= W;w++){
           if(wt[0] <= w)
               dp[0][w] = val[0];
           else
               dp[0][w] = 0;
        }
        for(int index = 1;index < n;index++){
            for(int w = 0;w <= W;w++){
                int notPick = dp[index - 1][w];
                int pick = Integer.MIN_VALUE;
                if(wt[index] <= w)
                    pick = val[index] + dp[index - 1][w - wt[index]];
                dp[index][w] = Math.max(pick,notPick);
            }
        }
        return dp[n - 1][W];
    } 
    // static int f(int index,int W,int[] wt,int[] val,int[][] dp){
    //     if(index == 0){
    //         if(wt[index] <= W)
    //             return val[index];
    //         else
    //             return 0;
    //     }
    //     if(dp[index][W] != -1)
    //         return dp[index][W];
    //     int notPick = f(index - 1,W,wt,val,dp);
    //     int pick = Integer.MIN_VALUE;
    //     if(wt[index] <= W)
    //       pick = val[index] + f(index - 1,W - wt[index],wt,val,dp);
    //     return dp[index][W] = Math.max(pick,notPick);
    // }
}


