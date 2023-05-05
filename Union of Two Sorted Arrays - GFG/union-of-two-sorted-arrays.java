//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String st[] = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
              arr1[i] = Integer.parseInt(st[i]);
            
            st = read.readLine().trim().split(" ");  
            for(int i = 0; i< M; i++)
              arr2[i] = Integer.parseInt(st[i]);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(arr1, arr2, N, M);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println(); 
        }
    }
}



// } Driver Code Ends


//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
         int i = 0,j = 0;
         ArrayList<Integer>union = new ArrayList<>();
         while(i < n && j < m){
             if(arr1[i] <= arr2[j]){
                 if(union.size() == 0 || union.get(union.size() - 1) != arr1[i]){
                     union.add(arr1[i]);
                 }
                 i++;
             }
             else{
                   if(union.size() == 0||union.get(union.size() - 1) != arr2[j]){
                       union.add(arr2[j]);
                   }
                   j++;
                 }
             }
             while(i < n){
                 if(union.size() == 0 || union.get(union.size() - 1) != arr1[i]){
                     union.add(arr1[i]);
                 }
                 i++;
             }
             while(j < m){
                 if(union.size() == 0 || union.get(union.size() - 1) != arr2[j]){
                     union.add(arr2[j]);
                 }
                 j++;
             }
             return union;
         }
    }



