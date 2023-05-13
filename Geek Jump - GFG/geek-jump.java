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
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[],int N){
        //code here
        int dp[] = new int[N + 1];
        for(int i = 0;i < N;i++)
          dp[i] = -1;
        return minimumEnergyMem(N - 1,arr,N,dp);
    }
    public int minimumEnergyMem(int index,int arr[],int N,int dp[]){
        if(index == 0)
          return 0;
        if(dp[index] != -1)
          return dp[index];
        int left = minimumEnergyMem(index - 1,arr,N,dp) + (int)Math.abs(arr[index] - arr[index - 1]);
        int right = Integer.MAX_VALUE;
        if(index > 1)
          right = minimumEnergyMem(index - 2,arr,N,dp) + (int)Math.abs(arr[index] - arr[index - 2]);
        return dp[index] = (int)Math.min(left,right);
    }
}