//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int numerator = Integer.parseInt(S[0]);
            int denominator = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            String ans = ob.fractionToDecimal(numerator, denominator);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String  fractionToDecimal(int numerator, int denominator)
    {
        // code here
        if(numerator == 0)
           return "0";
        StringBuilder sb = new StringBuilder();
        if(numerator < 0||denominator < 0)
           sb.append("-");
        long num = Math.abs((long)(numerator));
        long deno = Math.abs((long)(denominator));
        sb.append(num/deno);
        num %= deno;
        if(num == 0)
           return sb.toString();
        sb.append(".");
        Map<Long,Integer>map = new HashMap<>();
        while(num != 0){
            if(map.containsKey(num)){
                int index = map.get(num);
                sb.insert(index,"(");
                sb.append(")");
                break;
            }
            map.put(num,sb.length());
            num *= 10;
            sb.append(num/deno);
            num %= deno;
        }
        return sb.toString();  
    }
}