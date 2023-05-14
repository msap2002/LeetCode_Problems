//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        return f(arr,n);
    }
    public int f(int arr[],int n){
        //int dp[] = new int[n];
        //dp[0] = arr[0];
        //int neg = 0;
        int prev = arr[0];
        int prev2 = 0;
        for(int i = 1;i < n;i++){
            int pick = arr[i];
            if(i > 1)
              pick += prev2;
            int notPick = 0 + prev;
            int curr = (int)Math.max(pick,notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}