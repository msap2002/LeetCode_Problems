//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        int res = -1;
        if(M > N)
          return res;
        int sum = 0;
        for(int i = 0;i < N;i++)
           sum += A[i];
        int l = A[N - 1];
        int h = sum;
        while(l <= h){
            int mid = l + (h - l)/2;
            if(isAllocationPossible(A,N,M,mid)){
                res = mid;
                h = mid - 1;
            }
            else
               l = mid + 1;
        }
        return res;
    }
    public static boolean isAllocationPossible(int A[],int N,int M,int maxPages){
        int stu = 1,currPages = 0;
        for(int i = 0;i < N;i++){
            if(A[i] > maxPages)
               return false;
            if(currPages + A[i] > maxPages){
                stu++;
                if(stu > M)
                   return false;
                currPages = A[i];
            }
            else
               currPages += A[i];
        }
        return true;
    }
};