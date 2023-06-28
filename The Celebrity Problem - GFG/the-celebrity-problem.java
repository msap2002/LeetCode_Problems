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
    int celebrity(int M[][], int n)
    {
    	// code here 
    	for(int row = 0;row < n;row++){
    	    int col;
    	    for(col = 0;col < n;col++){
    	        if(row != col && M[row][col] == 1)
    	            break;
    	       }
    	       if(col == n){
    	           int ro;
    	           for(ro = 0;ro < n;ro++){
    	               if(ro != row && M[ro][row] == 0)
    	                  break;
    	           }
    	           if(ro == n)
    	             return row;
    	       }
    	}
    	return -1;
    }
}