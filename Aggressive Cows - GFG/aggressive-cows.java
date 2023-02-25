//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int start = 1;
        // int min = stalls[1] - stalls[0];
        // int max = stalls[n -1] - stalls[0];
        int res = -1;
        int end = stalls[n - 1] - stalls[0];
        while(start <= end){
            int mid = start + (end - start)/2;
            if(isValid(n,k,stalls,mid) == true){
                //res = mid;
                start = mid + 1;
                res = mid;
            }
            else{
                end = mid - 1;
            }
        }
        return res;
    }
    public static boolean isValid(int n,int k,int[] stalls,int mid){
        int noCows = 1;
        int lastPlaced = stalls[0];
        for(int i = 1;i < n;i++){
            if(stalls[i] - lastPlaced >= mid){
                noCows++;
                lastPlaced = stalls[i];
            }
        }
        if(noCows >= k)
           return true;
        return false;
    }
}