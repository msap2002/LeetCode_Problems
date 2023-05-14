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
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int maximumPoints(int points[][],int N){
        //code here
        int dp[][] = new int[N][4];
        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < dp[0].length;j++)
              dp[i][j] = -1;
        }
        return f(N - 1,3,points,dp);
    }
    public int f(int day,int last,int points[][],int[][] dp){
        if(day == 0){
            int maxi = 0;
            for(int task = 0;task < 3;task++){
                if(task != last)
                  maxi = (int)Math.max(maxi,points[0][task]);
            }
            return maxi;
        }
        if(dp[day][last] != -1)
          return dp[day][last];
        int maxi = 0;
        for(int task = 0;task < 3;task++){
            if(task != last){
                int point = points[day][task] + f(day - 1,task,points,dp);
                maxi = (int)Math.max(maxi,point);
            }
        }
        return dp[day][last] = maxi;
    }
}