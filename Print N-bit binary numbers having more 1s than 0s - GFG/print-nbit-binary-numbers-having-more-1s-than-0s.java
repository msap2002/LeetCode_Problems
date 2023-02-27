//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int N) {
        // code here
        int ones = 0;
        int zeroes = 0;
        String output = "";
        ArrayList<String>list = new ArrayList<>();
        solve(ones,zeroes,output,N,list);
        return list;
    }
    public void solve(int ones,int zeroes,String output,int N,ArrayList<String>list){
        if(N == 0){
            list.add(output);
            return;
        }
        String op1 = output;
        op1 += "1";
        solve(ones + 1,zeroes,op1,N - 1,list);
        if(ones > zeroes){
            String op2 = output;
            op2 += "0";
            solve(ones,zeroes + 1,op2,N - 1,list);
        }
        return;
    }
}