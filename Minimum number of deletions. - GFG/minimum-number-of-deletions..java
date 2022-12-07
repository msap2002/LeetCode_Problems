//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int minDeletions(String str, int n)
    {
        // code here
        String revstr = "";
        for(int i = 0;i < n;i++){
            revstr = str.charAt(i) + revstr;
        }
        int m = revstr.length();
        int lcs = lcs(str,revstr,n,m);
        int res = n - lcs;
        return res;
    }
    int lcs(String str1, String str2,int m,int n){
        int dp[][] = new int[m + 1][n + 1];
        for(int i = 0;i < m + 1;i++){
            for(int j = 0;j < n + 1;j++){
                if(i == 0||j == 0)
                  dp[i][j] = 0;
            }
        }
        for(int i = 1;i < m + 1;i++){
            for(int j = 1;j < n + 1;j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1))
                  dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                  dp[i][j] = (int)Math.max(dp[i - 1][j],dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
} 