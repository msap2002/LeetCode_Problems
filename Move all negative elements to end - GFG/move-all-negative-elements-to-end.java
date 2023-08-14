//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter ot = new  PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.segregateElements(a, n);
            
            for(int i=0;i<n;i++)
            ot.print(a[i]+" ");
            
            ot.println();
        }
        ot.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public void segregateElements(int arr[], int n)
    {
        // Your code goes here
        int positive[] = new int[n];
        int negative[] = new int[n];
        int k = 0;
        int l = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] > 0){
               positive[k++] = arr[i]; 
            }
            else if(arr[i] < 0){
                negative[l++] = arr[i];
            }
        }
        int x = 0;
        for(int i = k;i < n;i++){
            positive[i] = negative[x++];
        }
        for(int i = 0;i < n;i++){
            arr[i] = positive[i];
        }
    }
}