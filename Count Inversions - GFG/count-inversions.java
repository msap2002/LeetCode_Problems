//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return merge(arr,0,(int)N - 1);
    }
    static long mergeSort(long arr[],int low,int mid,int high){
        long cnt = 0;
        int left = low;
        int right = mid + 1;
        ArrayList<Long>temp = new ArrayList<>();
        while(left <= mid && right <= high){
            if(arr[left] > arr[right]){
                temp.add(arr[right]);
                cnt += (mid - left + 1);
                right++;
            }
            else{
                temp.add(arr[left]);
                left++;
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }
        for(int i = low;i <= high;i++)
           arr[i] = temp.get(i - low);
        return cnt;
    }
    static long merge(long arr[],int low,int high){
        long cnt = 0;
        if(low >= high)
          return 0;
        int mid = low + (high - low)/2;
        cnt += merge(arr,low,mid);
        cnt += merge(arr,mid + 1,high);
        cnt += mergeSort(arr,low,mid,high);
        return cnt;
    }
}