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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here
        if(S.length() <= 1)
           return S;
        String LPS = "";
        for(int i = 1;i < S.length();i++){
            //odd length strings
            int low = i;
            int high = i;
            while(S.charAt(low) == S.charAt(high)){
                low--;
                high++;
                if(low == -1||high == S.length())
                    break;
            }
            String palindrome = S.substring(low + 1,high);
            if(palindrome.length() > LPS.length())
               LPS = palindrome;
            // even length strings
            low = i - 1;
            high = i;
            while(S.charAt(low) == S.charAt(high)){
                low--;
                high++;
                if(low == -1||high == S.length())
                   break;
            }
            palindrome = S.substring(low + 1,high);
            if(palindrome.length() > LPS.length())
                LPS = palindrome;
        }
        if(LPS.length() == 1)
           return Character.toString(S.charAt(0));
        return LPS;
    }
}