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
        String output = "";
        ArrayList<String>res = new ArrayList<>();
        output += S.charAt(0);
        helper(S.substring(1),output,res);
        Collections.sort(res);
        return res;
    }
    public static void helper(String input, String output, ArrayList<String>res){
        if(input.length() == 0){
            res.add(output);
            return;
        }
        String op1 = output;
        String op2 = output;
        op1 += " " + input.charAt(0);
        op2 += input.charAt(0);
        helper(input.substring(1),op1,res);
        helper(input.substring(1),op2,res);
    }
}