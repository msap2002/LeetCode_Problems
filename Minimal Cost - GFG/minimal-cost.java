//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int K=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.minimizeCost(arr,N,K);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimizeCost(int arr[],int N,int K){
        //code here
        // int dp[] = new int[N + 1];
        // for(int i = 0;i < N;i++)
        //   dp[i] = -1;
        return f(arr,N,K);
    }
    // public int f(int index,int arr[],int K,int dp[]){
    //     if(index == 0)
    //       return 0;
    //     if(dp[index] != -1)
    //       return dp[index];
    //     int minSteps = Integer.MAX_VALUE;
    //     for(int i = 1;i <= K;i++){
    //         if(index - i >= 0){
    //           int ans =  f(index - i,arr,K,dp) + (int)Math.abs(arr[index] - arr[index - i]);
    //           minSteps = (int)Math.min(minSteps,ans);
    //         }
    //     }
    //     return dp[index] = minSteps;
    // }
    public int f(int arr[],int N,int K){
        int dp[] = new int[N + 1];
        dp[0] = 0;
        for(int i = 1;i < N;i++){
            int minSteps = Integer.MAX_VALUE;
            for(int j = 1;j <= K;j++){
                if(i - j >= 0){
                    int ans = dp[i - j] + (int)Math.abs(arr[i] - arr[i - j]);
                    minSteps = (int)Math.min(minSteps,ans);
                }
            }
            dp[i] = minSteps;
        }
        return dp[N - 1];
    }
}
