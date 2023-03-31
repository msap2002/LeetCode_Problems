//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    //int sum = 0;
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        int sum = 0;
        ArrayList<Integer>ans = new ArrayList<>();
        subsetSumsBetter(arr,0,0,ans);
        return ans;
    }
    public void subsetSumsBetter(ArrayList<Integer> arr,int index,int sum,ArrayList<Integer>ans){
        if(index == arr.size()){
            ans.add(sum);
            return;
        }
        subsetSumsBetter(arr,index + 1,sum + arr.get(index),ans);
        subsetSumsBetter(arr,index + 1,sum,ans);
    }
}