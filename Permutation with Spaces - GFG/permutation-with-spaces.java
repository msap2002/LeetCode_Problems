//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java



class Solution{
    
    ArrayList<String> permutation(String S){
        // Code Here
        ArrayList<String>res = new ArrayList<>();
        String output = "";
        int index = 1;
        output += S.charAt(0);
        helper(1,S,output,res);
        Collections.sort(res);
        return res;
    }
    public static void helper(int index, String inp, String output, ArrayList<String>res){
        if(index == inp.length()){
            res.add(output);
            return;
        }
        // op2 += inp.charAt(0);
        helper(index + 1,inp,output + inp.charAt(index),res);
        helper(index + 1,inp,output + " " + inp.charAt(index),res);
    }
    
}