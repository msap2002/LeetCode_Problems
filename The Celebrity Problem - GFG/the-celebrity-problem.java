//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    boolean knows(int[][] M,int A,int B){
        if(M[A][B] == 1 && M[B][A] == 0)
            return true;
        return false;
    }
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer>stk = new Stack<>();
    	for(int col = 0;col < n;col++){
    	    stk.push(col);
    	}
    	while(stk.size() > 1){
    	    int A = stk.peek();
    	    stk.pop();
    	    int B = stk.peek();
    	    stk.pop();
    	    if(knows(M,A,B)){
    	        stk.push(B);
    	    }
    	    else
    	       stk.push(A);
    	}
    	int ans = stk.peek();
    	int zeroCnt = 0;
    	for(int col = 0;col < n;col++){
    	    if(M[ans][col] == 0)
    	      zeroCnt++;
    	}
    	if(zeroCnt != n)
    	   return -1;
    	int oneCnt = 0;
    	for(int row = 0;row < n;row++)
    	   if(M[row][ans] == 1)
    	      oneCnt++;
    	if(oneCnt != n - 1)
    	   return -1;
    	return ans;
    }
}